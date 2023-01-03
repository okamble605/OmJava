package math.convert;

public class DecimalConverter {
  public static String decimalToOctal(int decimal) {
    return Integer.toOctalString(decimal);
  }

  public static String decimalToBinary(int decimal) {
    return Integer.toBinaryString(decimal);
  }

  public static String decimalToHex(int decimal) {
    return Integer.toHexString(decimal);
  }

  public static int octalToDecimal(String octal) {
    return Integer.parseInt(octal, 8);
  }

  public static int binaryToDecimal(String binary) {
    return Integer.parseInt(binary, 2);
  }

  public static int hexToDecimal(String hex) {
    return Integer.parseInt(hex, 16);
  }
}
