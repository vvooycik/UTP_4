package zad1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Futil {
    public static void processDir(String startDir, String resultFile){

        try {
            Files.deleteIfExists(Paths.get(resultFile));
            Files.createFile(Paths.get(resultFile));
            List<String> text = new ArrayList<>();
            Files.walkFileTree(Paths.get(startDir), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    try {
                        text.addAll(Files.readAllLines(file, Charset.forName("Cp1250")));
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
            Files.write(Paths.get(resultFile),text, Charset.forName("UTF-8"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
