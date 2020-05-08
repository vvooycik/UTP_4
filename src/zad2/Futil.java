package zad2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Futil {
    public static void processDir(String startDir, String resultFile){

        try {
            Files.deleteIfExists(Paths.get(resultFile));
            Files.createFile(Paths.get(resultFile));
            Predicate<Path> isFile = Files::isRegularFile;

            List<String> text = Files.walk(Paths.get(startDir))
                 .filter(isFile)
                 .flatMap(path -> {
                     try {
                         return Files.lines(path, Charset.forName("Cp1250"));
                     } catch (IOException ex) {
                         ex.printStackTrace();
                     }
                     return null;
                 })
                 .collect(Collectors.toList());
            Files.write(Paths.get(resultFile),text, StandardCharsets.UTF_8);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
