/**
 *
 *  @author Wójcik Maciej S18305
 *
 */

package zad1;


public class Main {
  public static void main(String[] args) {
    String dirName = System.getProperty("user.home")+"/UTP6dir";
    String resultFileName = "UTP6res.txt";
    Futil.processDir(dirName, resultFileName);
  }
}
