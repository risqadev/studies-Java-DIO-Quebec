package Collections;

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
// import java.util.Collections;
// import java.util.Iterator;
// import java.util.List;
// import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Sets {
  public static void main(String[] args) {
    // Dada uma lista com sete notas de um aluno, faça:
    // Notas: [ 7, 8.5, 9.3, 5, 7, 0, 3.5 ]

    /** Formas de declarar um Set:
     Set notas = new HashSet();                                           // antes do Java 5
     Set<Double> notas = new HashSet<Double>();                           // Generics (jdk 5) - Diamond operator (jdk 7)
     HashSet<Double> notas = new HashSet<>();
     Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
     Set<Double> notas = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
    */

    /* Adicionar elementos individualmente:
    notas.add(7d);
    notas.add(8.5);
    notas.add(9.3);
    notas.add(5d);
    notas.add(7d);
    notas.add(0d);
    notas.add(3.5);
    */

    // Crie um conjunto e adicione as sete notas.
    Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
    System.out.println("HashSet: " + notas);

    // notas.remove(5d);
    // System.out.println(notas.toString());

    // Exiba a posição da nota 5.0
    // hashset não tem posição, então não é possível fazer isso.

    // Exiba a terceira nota adicionada
    // hashset não tem posição e não guarda a ordem de inserção, então não é possível fazer isso.

    // Adicione na lista a nota 8.0 na posição 4
    // hashset não tem posição, então não é possível fazer isso.
    
    // Confira se a nota 5.0 está na lista
    System.out.println("A nota '5.0' está na lista? " + (notas.contains(5d) ? "Sim" : "Não"));
    
    // Exiba a menor nota
    System.out.println("A menor nota da lista é " + Collections.min(notas));
    
    // Exiba a maior nota
    System.out.println("A maior nota da lista é " + Collections.max(notas));
    
    // Exiba a soma dos valores
    Double soma = 0d;
    for (Double nota : notas) soma += nota;
    System.out.println("A soma das notas é " + soma);
    // ou usando iterator
    soma = 0d;
    Iterator<Double> iterator = notas.iterator();
    while (iterator.hasNext()) {
      Double next = iterator.next();
      soma += next;
    }
    System.out.println("A soma das notas é " + soma);
    
    // Exiba a média das notas
    System.out.println("A média das notas é " + soma/notas.size() );
    
    // Remova a nota '0'
    notas.remove(0d);
    System.out.println("Removendo a nota '0': " + notas);
    
    // Substitua a nota 5.0 pela nota 6.0
    // não é possível fazer por métodos posicionais como o set, mas...
    notas.remove(5d);
    notas.add(6d);
    System.out.println("Removendo a nota 5.0 e incluindo a nota 6.0: " + notas);
    
    // Remova a nota da posição '0'
    // hashset não tem posição, então não é possível fazer isso.
    
    // Remova as notas menores que '7'
    Iterator<Double> iterador = notas.iterator();
    while (iterador.hasNext()) {
      Double prox = iterador.next();
      if (prox < 7) iterador.remove();
    }
    System.out.println("Removendo as notas menores que '7': " + notas);
    
    // Apague toda a lista
    notas.clear();
    System.out.println("Removendo todos os elementos da lista: " + notas);
    
    // Exiba todas as notas na ordem em que foram informadas
    // hashset não tem posição e não guarda a ordem de inserção, mas LinkedHashSet sim
    Set<Double> notas2 = new LinkedHashSet<>();
    notas2.add(7d);
    notas2.add(8.5);
    notas2.add(9.3);
    notas2.add(5d);
    notas2.add(7d);
    notas2.add(0d);
    notas2.add(3.5);
    System.out.println("LinkedHashSet guarda a ordem de inserção, mas não duplica elementos inseridos mais de uma vez: " + notas2);
    
    // Exiba todas as notas na ordem crescente.
    Set<Double> notas3 = new TreeSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
    System.out.println("TreeSet guarda os elementos em sua ordem natural: " + notas3);

    // Confira se as listas estão vazias
    System.out.println("A lista 'notas' está vazia? " + ( notas.isEmpty() ? "Sim" : "Não" ) );
    System.out.println("A lista 'notas2' está vazia? " + ( notas2.isEmpty() ? "Sim" : "Não" ) );
    System.out.println("A lista 'notas3' está vazia? " + ( notas3.isEmpty() ? "Sim" : "Não" ) );
  }
}