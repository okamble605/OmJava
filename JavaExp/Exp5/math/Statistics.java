package math;

public class Statistics {
  public static double mean(double[] values) {
    double sum = 0;
    for (double value : values) {
      sum += value;
    }
    return sum / values.length;
  }

  public static double median(double[] values) {
    int n = values.length;
    if (n % 2 == 1) {
      return values[n / 2];
    } else {
      return (values[n / 2 - 1] + values[n / 2]) / 2;
    }
  }

  public static double standardDeviation(double[] values) {
    double mean = mean(values);
    double sum = 0;
    for (double value : values) {
      sum += Math.pow(value - mean, 2);
    }
    return Math.sqrt(sum / values.length);
  }
}

