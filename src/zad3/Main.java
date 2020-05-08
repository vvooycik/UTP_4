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
                  if(!map.containsKey(arr.toString())){
                      map.put(arr.toString(), new ArrayList<String>());
                  }
                      map.get(arr.toString()).add(word);
            });
      Optional<Map.Entry<String, List<String>>> max = map.entrySet().stream().max(bySize);
      System.out.print(max.get().getKey() + " ");
      for(String word : max.get().getValue()){
          System.out.print(word + " ");
      }
  }
}
