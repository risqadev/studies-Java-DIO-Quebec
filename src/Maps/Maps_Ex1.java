package Maps;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;

public class Maps_Ex1 {
  /**
   * Estado, População
   * PE , 9.916.621
   * AL , 3.351.543
   * CE , 9.187.103
   * RN , 3.534.265
   * 
   * Dada a população estimada de alguns estados do NE brasileiro, faça:
   * 
   * a. Crie um dicionário e relacione os estados e suas populações;
   * b. Substitua a população do estado do RN por 3.534.165;
   * c. Confira se o estado da PB está no dicionário, caso não esteja, insira-o
   *    com 4.039.277;
   * d. Exiba a população de PE;
   * e. Exiba todos os estados e suas populações na ordem que foi informado;
   * f. Exiba os estados e suas populações em ordem alfabética;
   * g. Exiba o estado com a menor população e sua quantidade;
   * h. Exiba o estado com a maior população e sua quantidade;
   * i. Exiba a soma das populações desses estados;
   * j. Exiba a média da população deste dicionário de estados;
   * k. Remova os estados com população menor que 4.000.000;
   * l. Apague o dicionário de estados;
   * m. Confira se o dicionário está vazio.
   */
  public static void main(String[] args) {

    //  a. Crie um dicionário e relacione os estados e suas populações;
    Map<String, Integer> estados1 = new HashMap<>(){{
      put("PE", 9916621);
      put("AL", 3351543);
      put("CE", 9187103);
      put("RN", 3534265);
    }};
    System.out.println("Alguns estados do Nordeste e suas populações: ");
    for (Map.Entry<String, Integer> estado : estados1.entrySet()) {
      System.out.println(estado.getKey() + " - " + estado.getValue());
    }

    //  b. Substitua a população do estado do RN por 3.534.165;
    estados1.put("RN", 3534165);
    System.out.println("Alterada a população do RN: " + estados1.get("RN"));
    for (Map.Entry<String, Integer> estado : estados1.entrySet()) {
      System.out.println(estado.getKey() + " - " + estado.getValue());
    }

    //  c. Confira se o estado da PB está no dicionário, caso não esteja, insira-o
    //     com 4.039.277;
    System.out.println("O estado da PB está no dicionário? " + (
      estados1.containsKey("PB") ? "Sim" : "Não"
    ));
    if (!estados1.containsKey("PB")) estados1.put("PB", 4039277);
    System.out.println("Inserindo o estado da PB.");
    for (Map.Entry<String, Integer> estado : estados1.entrySet()) {
      System.out.println(estado.getKey() + " - " + estado.getValue());
    }

    //  d. Exiba a população de PE;
    System.out.println("População de PE: " + estados1.get("PE"));

    //  e. Exiba todos os estados e suas populações na ordem que foi informado;
    Map<String, Integer> estados2 = new LinkedHashMap<>(){{
      put("PE", 9916621);
      put("AL", 3351543);
      put("RN", 3534265);
      put("CE", 9187103);
    }};
    System.out.println("Na ordem de inserção: ");
    for (Map.Entry<String, Integer> estado : estados2.entrySet()) {
      System.out.println(estado.getKey() + " - " + estado.getValue());
    }

    //  f. Exiba os estados e suas populações em ordem alfabética;
    TreeMap<String, Integer> estados3 = new TreeMap<>(estados1);
    System.out.println("Na ordem natural (alfabética): ");
    for (Map.Entry<String, Integer> estado : estados3.entrySet()) {
      System.out.println(estado.getKey() + " - " + estado.getValue());
    }

    //  g. Exiba o estado com a menor população e sua quantidade;
    TreeSet<Map.Entry<String, Integer>> estados4 = new TreeSet<>(new ComparatorPopulacao());
    estados4.addAll(estados1.entrySet());
    System.out.println("Estado com a menor população: ");
    System.out.println(estados4.first().getKey() + " - " + estados4.first().getValue());

    //  h. Exiba o estado com a maior população e sua quantidade;
    System.out.println("Estado com a maior população: ");
    System.out.println(estados4.last().getKey() + " - " + estados4.last().getValue());

    //  i. Exiba a soma das populações desses estados;
    Integer soma = 0;
    for (int valor : estados1.values()) soma += valor;
    System.out.println("Soma das populações: " + soma);

    //  j. Exiba a média da população deste dicionário de estados;
    Double media = (double) soma / estados1.size();
    System.out.println("Média das populações dos " + estados1.size() +
                      " estados do dicionário 'estados1': " + media);

    //  k. Remova os estados com população menor que 4M;
    Iterator<Integer> iterador = estados1.values().iterator();
    while (iterador.hasNext())
      if (iterador.next() < 4000000) iterador.remove();
    System.out.println("Removidos estados com população menor que 4M: ");
    for (Map.Entry<String, Integer> estado : estados1.entrySet()) {
      System.out.println(estado.getKey() + " - " + estado.getValue());
    }

    //  l. Apague o dicionário de estados;
    estados1.clear();
    System.out.println("Dicionário 'estados1' esvaziado: " + estados1);

    //  m. Confira se o dicionário está vazio.
    System.out.println("O dicionário 'estado1' está vazio? " + (
      estados1.isEmpty() ? "Sim" : "Não"
    ));
  }
}

class ComparatorPopulacao implements Comparator<Map.Entry<String, Integer>> {

  @Override
  public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
    return e1.getValue().compareTo(e2.getValue());
  }
}