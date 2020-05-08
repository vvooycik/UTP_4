/**
 *
 *  @author Wójcik Maciej S18305
 *
 */

package zad3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import static java.util.stream.Collectors.toList;

public class Main {
  public static void main(String[] args) throws IOException {

      URL url = new URL("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt");
      BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
      LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
      Comparator<Map.Entry<String, List<String>>> bySize = Comparator.comparingInt(o -> o.getValue().size());
      reader.lines()
            .forEach(word -> {
                  char[] arr = word.toCharArray();
                  Arrays.sort(arr);
                  if(!map.containsKey(String.valueOf(arr))){
                      map.put(String.valueOf(arr), new ArrayList<String>());
                  }
                      map.get(String.valueOf(arr)).add(word);
            });

      List<Map.Entry<String, List<String>>> max = map
              .entrySet()
              .stream()
              .filter(e -> e.getValue().size() == map
                      .entrySet()
                      .stream()
                      .max(bySize)
                      .get()
                      .getValue()
                      .size())
              .collect(toList());

      max.forEach(entry -> {
          entry.getValue()
                  .forEach(word -> {
                      System.out.print(word + " ");
                  });
          System.out.println();
      });
  }
}
