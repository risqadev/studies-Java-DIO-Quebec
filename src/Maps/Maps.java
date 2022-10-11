package Maps;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.Set;
import java.util.Iterator;

public class Maps {
  /**
   * modelo, consumo
   * gol  ,  14,4 km/l
   * uno  ,  15,6 km/l
   * mobi ,  16,1 km/l
   * hb20 ,  14,5 km/l
   * kwid ,  15,6 km/l
   * 
   * Dado os modelos de carros e seus respectivos consumos na estrada, faça:
   * a. Crie um dicionário que relacione os modelos e seus respectivos consumos.
   * b. Substitua o consumo do gol por 15,2 km/l.
   * c. Confira se o modelo 'tucson' está no dicionário.
   * d. Exiba o consumo do uno.
   * e. Exiba o terceiro modelo adicionado.
   * f. Exiba os modelos.
   * g. Exiba os consumos dos carros.
   * h. Exiba o modelo mais econômico e seu consumo.
   * i. Exiba o modelo menos econômico e seu consumo.
   * j. Exiba a soma dos consumos.
   * k. Exiba a média dos consumos deste dicionário de carros.
   * l. Remova os modelos com o consumo igual a 15,6 km/l.
   * m. Exiba todos os carros na ordem em que foram informados.
   * n. Exiba o dicionário ordenado pelo modelo.
   * o. Apague o dicionario de carros.
   * p. Confira se o dicionário está vazio.
   */
  public static void main(String[] args) {
    Map<String, Double> carros1 = new HashMap<>();
    carros1.put("gol", 14.4);
    carros1.put("uno", 15.6);
    carros1.put("mobi", 16.1);
    carros1.put("hb20", 14.5);
    carros1.put("kwid", 15.6);
    System.out.println("Modelos e consumos: " + carros1);

    carros1.put("gol", 15.2);
    System.out.println("Modelos e consumos: " + carros1);

    System.out.println("Modelo 'tucson' está presente? " + (
      carros1.containsKey("tucson") ? "Sim" : "Não"
    ));

    System.out.println("Consumo do 'uno': " + carros1.get("uno") );

    System.out.println("Modelos: " + carros1.keySet() );

    System.out.println("Consumos: " + carros1.values() );

    Double consumoMaisEficiente = Collections.max(carros1.values());
    Double consumoMenosEficiente = Collections.min(carros1.values());
    Set<Map.Entry<String, Double>> entries = carros1.entrySet();
    
    for (Map.Entry<String, Double> entry : entries) {
      if (entry.getValue().equals(consumoMaisEficiente))
        System.out.println("Modelo mais eficiente: " + entry.getKey() + " - " + consumoMaisEficiente);
      if (entry.getValue().equals(consumoMenosEficiente))
        System.out.println("Modelo menos eficiente: " + entry.getKey() + " - " + consumoMenosEficiente);
    }

    Double soma = 0d;
    for (Double value : carros1.values()) soma += value;
    System.out.println("Soma de consumos: " + soma);

    Double media = soma / carros1.values().size();
    System.out.println("Média de consumos: " + media);

    Iterator<Double> iterador = carros1.values().iterator();
    while (iterador.hasNext())
      if (iterador.next().equals(15.6)) iterador.remove();
    System.out.println("Removidos os com valores iguais a 15.6: " + carros1);

    Map<String, Double> carros2 = new LinkedHashMap<>(){{
      put("gol", 14.4);
      put("uno", 15.6);
      put("mobi", 16.1);
      put("hb20", 14.5);
      put("kwid", 15.6);
    }};
    System.out.println("Na ordem de inserção (LinkedHashMap): "+ carros2);

    Map<String, Double> carros3 = new TreeMap<>(carros2);
    System.out.println("Na ordem natural (alfabética das chaves/modelos): " + carros3);

    carros1.clear();
    System.out.println(carros1);

    System.out.println("O dicionário 'carros1' está vazio? " + (
      carros1.isEmpty() ? "Sim" : "Não"
    ));
  }
}