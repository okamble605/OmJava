import math.Statistics;
import math.convert.DecimalConverter;

public class Application {
  public static void main(String[] args) {
    double[] values = {1, 2, 3, 4, 5};
    System.out.println("Mean: " + Statistics.mean(values));
    System.out.println("Median: " + Statistics.median(values));
    System.out.println("Standard deviation: " + Statistics.standardDeviation(values));

    int decimal = 10;
    System.out.println("Decimal: " + decimal);
    String octal = DecimalConverter.decimalToOctal(decimal);
    System.out.println("Octal: " + octal);
    String binary = DecimalConverter.decimalToBinary(decimal);
    System.out.println("Binary: " + binary);
    String hex = DecimalConverter.decimalToHex(decimal);
    System.out.println("Hex: " + hex);
  }
}
