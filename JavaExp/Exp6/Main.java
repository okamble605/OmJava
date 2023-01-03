import java.util.*;
class Car {
  
  private static int numCars;

  private final int id;

  private String make;
  private String model;

  public Car(String make, String model) {
    this.make = make;
    this.model = model;
    id = ++numCars;
  }

 
  public static int getNumCars() {
    return numCars;
  }


  public void setMake(String make) {
    this.make = make;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Car #" + id + ": " + make + " " + model;
  }
}

public class Main {
  public static void main(String[] args) {
    Car car1 = new Car("Toyota", "Camry");
    Car car2 = new Car("Honda", "Accord");
    Car car3 = new Car("Ford", "Mustang");

    System.out.println(car1);
    System.out.println(car2);
    System.out.println(car3);

    System.out.println("Number of cars: " + Car.getNumCars());

    car1.setMake("Lexus");
    System.out.println(car1);
  }
}
