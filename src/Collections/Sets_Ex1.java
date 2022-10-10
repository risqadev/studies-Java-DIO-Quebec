package Collections;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sets_Ex1 {
  /**
   * Crie um conjunto contendo as cores do arco-íris e:
   * a. Exiba todas as cores uma abaixo da outra;
   * b. Exiba a quantidade de cores que ele tem;
   * c. Exiba as cores em ordem alfabética;
   * d. Exiba as cores na ordem inversa da informada;
   * e. Exiba todas as cores que começam com a letra 'v';
   * f. Remova topdas as cores que não começam com a letra 'v';
   * g. Limpe o conjunto;
   * h. Confira se o conjunto está vazio.
   */

   public static void main(String[] args) {
    Set<String> arcoiris = new HashSet<>(Arrays.asList("vermelha", "laranja", "amarela", "verde", "azul", "anil", "violeta"));
    System.out.println("Cores do arcoiris:");
    for (String cor : arcoiris)
      System.out.println(cor);

    System.out.println("Quantidade de cores do arcoiris: " + arcoiris.size());

    Set<String> arcoiris2 = new TreeSet<>(arcoiris);
    System.out.println("Cores em ordem alfabética: " + arcoiris2);

    Set<String> arcoiris3 = new LinkedHashSet<>(Arrays.asList("vermelha", "amarela", "violeta", "anil", "laranja", "verde", "azul"));
    System.out.println("Ordem de insersão direta: " + arcoiris3);
    List<String> arcoiris4Lista = new ArrayList<>(arcoiris3);
    Collections.reverse(arcoiris4Lista);
    System.out.println("Ordem de insersão inversa: " + arcoiris4Lista);

    System.out.printf("Cores que começam com 'v':");
    for (String cor : arcoiris) {
      if (cor.startsWith("v"))
        System.out.printf(" %s,", cor);
    }
    System.out.println("");

    Iterator<String> iterador = arcoiris.iterator();
    while (iterador.hasNext()) {
      String proximo = iterador.next();
      if (proximo.startsWith("v"))
        iterador.remove();
    }
    System.out.println("Removidos os que começam com a letra 'v': " + arcoiris);

    arcoiris.clear();
    System.out.println("Remover todos os elementos: " + arcoiris);

    System.out.println("Todos os elementos foram removidos? " + (
      arcoiris.isEmpty() ? "Sim" : "Não"
    ));
  }
}