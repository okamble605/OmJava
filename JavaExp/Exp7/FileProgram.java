import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileProgram {
  public static void main(String[] args) {
   
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the file name: ");
    String fileName = scanner.nextLine();

    File file = new File(fileName);
    if (file.exists()) {

      try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
      } catch (IOException e) {
        System.out.println("An error occurred while reading the file.");
      }

      System.out.print("Do you want to add data to the file? (y/n) ");
      String response = scanner.nextLine();
      if (response.equalsIgnoreCase("y")) {
  
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
          System.out.print("Enter the data to add: ");
          String data = scanner.nextLine();
          writer.write(data);
          writer.newLine();
        } catch (IOException e) {
          System.out.println("An error occurred while writing to the file.");
        }
      }
    } else {
    
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        System.out.print("Enter the data to store in the new file: ");
        String data = scanner.nextLine();
        writer.write(data);
        writer.newLine();
      } catch (IOException e) {
        System.out.println("An error occurred while creating the file.");
      }
    }

    scanner.close();
  }
}
