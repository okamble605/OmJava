import java.util.*;
class Engine {
  private boolean running;

  public void start() {
    running = true;
    System.out.println("Engine started");
  }

  public void stop() {
    running = false;
    System.out.println("Engine stopped");
  }
}

class Tyre {
  private int pressure;

  public Tyre(int pressure) {
    this.pressure = pressure;
  }
  public void inflate(int amount) {
    pressure += amount;
    System.out.println("Tyre pressure increased to " + pressure + " PSI");
  }
  public void deflate(int amount) {
    pressure -= amount;
    System.out.println("Tyre pressure decreased to " + pressure + " PSI");
  }
}

class Door {
  private boolean open;

  public void open() {
    open = true;
    System.out.println("Door opened");
  }
  public void close() {
    open = false;
    System.out.println("Door closed");
  }
}

class Car {
  private Engine engine;
  private Tyre[] tyres;
  private Door[] doors;
  public Car(int numTyres, int numDoors) {
    engine = new Engine();
    tyres = new Tyre[numTyres];
    for (int i = 0; i < numTyres; i++) {
      tyres[i] = new Tyre(32);
    }
    doors = new Door[numDoors];
    for (int i = 0; i < numDoors; i++) {
      doors[i] = new Door();
    }
  }

  public void start() {
    engine.start();
  }
  public void stop() {
    engine.stop();
  }
  public void inflateTyres(int amount) {
    for (Tyre tyre : tyres) {
      tyre.inflate(amount);
    }
  }
  public void deflateTyres(int amount) {
    for (Tyre tyre : tyres) {
      tyre.deflate(amount);
    }
  }

  public void openDoors() {
    for (Door door : doors) {
      door.open();
    }
  }
  public void closeDoors() {
    for (Door door : doors) {
      door.close();
    }
  }
}

public class CarP {
  public static void main(String[] args) {
    Car car = new Car(4, 4);
    car.start();
    car.inflateTyres(10);
    car.openDoors();
    car.closeDoors();
    car.deflateTyres(5);
    car.stop();
  }
}
