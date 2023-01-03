import java.io.*;
import java.util.Scanner;

public class DOS {
  public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the student's name: ");
    String name = scanner.nextLine();
    System.out.print("Enter the student's age: ");
    int age = scanner.nextInt();
    System.out.print("Enter the student's weight: ");
    double weight = scanner.nextDouble();
    System.out.print("Enter the student's height: ");
    double height = scanner.nextDouble();
    scanner.nextLine();  
    System.out.print("Enter the student's city: ");
    String city = scanner.nextLine();
    System.out.print("Enter the student's phone number: ");
    String phone = scanner.nextLine();

    scanner.close();

    try {
      FileOutputStream fos = new FileOutputStream("student.dat");
      DataOutputStream dos = new DataOutputStream(fos);
      dos.writeUTF(name);
      dos.writeInt(age);
      dos.writeDouble(weight);
      dos.writeDouble(height);
      dos.writeUTF(city);
      dos.writeUTF(phone);
      dos.close();
      fos.close();
     
      FileInputStream fis = new FileInputStream("student.dat");
      DataInputStream dis = new DataInputStream(fis);
      name = dis.readUTF();
      age = dis.readInt();
      weight = dis.readDouble();
      height = dis.readDouble();
      city = dis.readUTF();
      phone = dis.readUTF();
      dis.close();
      fis.close();

      System.out.println("Student Information:");
      System.out.println("Name: " + name);
      System.out.println("Age: " + age);
      System.out.println("Weight: " + weight);
      System.out.println("Height: " + height);
      System.out.println("City: " + city);
      System.out.println("Phone: " + phone);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
