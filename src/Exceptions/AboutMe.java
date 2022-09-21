package Exceptions;
import java.util.Locale;
import java.util.Scanner;

public class AboutMe {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    try {
      System.out.println("Digite o seu nome: ");
      String name = scanner.next();
      System.out.println("Digite o seu sobrenome: ");
      String lastName = scanner.next();
      System.out.println("Digite a sua idade: ");
      int age = scanner.nextInt();
      System.out.println("Digite a sua altura: ");
      double height = scanner.nextDouble();
      System.out.printf("%s %s, %d anos, %.2f m de altura %n", name, lastName, age, height);
    } catch (Exception e) {
      System.out.println("Erro nas entradas do usuário");
      System.out.println(e);
    } finally {
      System.out.println("Finalmente esse");
    }
    scanner.close();
  }
}