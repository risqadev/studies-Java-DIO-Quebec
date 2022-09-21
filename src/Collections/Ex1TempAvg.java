package Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex1TempAvg {
  public static void main(String[] args) {
    final List<String> months = List.of("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    final int n = 6;
    List<Double> temperatures = new ArrayList<>();
    
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < n; i++) {
      System.out.printf("Insert %s temperature: ", months.get(i));
      Double input = scanner.nextDouble();
      temperatures.add(i, input);
    }
    scanner.close();
    
    Double avg = ListAverage.avg(temperatures);
    List<Integer> monthsAboveAvgIndexes = ListAverage.aboveAvg(temperatures, avg);

    System.out.println("Average temperatures: " + avg);
    System.out.println("Above average temperatures:");

    for (int i : monthsAboveAvgIndexes)
      System.out.printf("%.1f (%s)%n", temperatures.get(i), months.get(i));
  }
}

class ListAverage {
  public static Double avg(List<Double> list) {
    Double sum = 0d;
    for (Double value : list) sum += value;
    return sum / list.size();
  }

  public static List<Integer> aboveAvg(List<Double> list, Double avg) {
    List<Integer> indexesAbove = new ArrayList<>();
    for (int i = 0; i < list.size(); i++)
      if (list.get(i) > avg)
        indexesAbove.add(i);
    return indexesAbove;
  }
}