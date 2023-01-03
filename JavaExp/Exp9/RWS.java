import java.io.*;
public class RWS {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: RemoveWhitespace <filename>");
      return;
    }
    String filename = args[0];
    String line;
    try {
      FileReader fileReader = new FileReader(filename);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      while ((line = bufferedReader.readLine()) != null) {
        line = line.replaceAll("\\s", "");
      System.out.println(line);
      }
      bufferedReader.close();
    } catch (FileNotFoundException ex) {
      System.out.println("Unable to open file '" + filename + "'");
    } catch (IOException ex) {
      System.out.println("Error reading file '" + filename + "'");
    }
  }
}
