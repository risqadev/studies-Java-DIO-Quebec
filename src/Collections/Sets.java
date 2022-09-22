package Collections;
import java.util.Set;
import java.util.HashSet;
// import java.util.Collections;
// import java.util.Iterator;
// import java.util.List;
// import java.util.ArrayList;

public class Sets {
  public static void main(String[] args) {
    /** Formas de declarar um Set:
     Set notas = new HashSet();                                           // antes do Java 5
     Set<Double> notas = new HashSet<Double>();                           // Generics (jdk 5) - Diamond operator (jdk 7)
     HashSet<Double> notas = new HashSet<>();
     Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
     Set<Double> notas = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
    */
    
    // Dada uma lista com sete notas de um aluno, faça:
    // Notas: [ 7, 8.5, 9.3, 5, 7, 0, 3.5 ]

    // Crie um conjunto e adicione as sete notas
    Set<Double> notas = new HashSet<>();
    notas.add(7d);
    notas.add(8.5);
    notas.add(9.3);
    notas.add(5d);
    notas.add(7d);
    notas.add(0d);
    notas.add(3.5);
    System.out.println(notas);

    // notas.remove(5d);
    // System.out.println(notas.toString());

    // Exiba a posição da nota 5.0
    // System.out.printf("A nota '5.0' está na posição '%d'%n", notas.indexOf(5d));

    // Adicione na lista  a nota 8.0 na posição 4
    // notas.add(4, 8d);
    // System.out.println("Inserindo a nota '8.0' na posição '4'");
    // System.out.println(notas);

    // Substitua a nota 5.0 pela nota 6.0
    // notas.set(notas.indexOf(5d), 6d);
    // System.out.println("Substituindo a nota '5.0' pela nota '6.0'");
    // System.out.println(notas);

    // Confira se a nota 5.0 está na lista
    // System.out.println("A nota '5.0' está na lista? " + (notas.contains(5d) ? "Sim" : "Não"));

    // Exiba todas as notas na ordem em que foram informadas
    // for (Double nota : notas) System.out.println(nota);

    // Exiba a terceira nota adicionada
    // System.out.println("A terceira nota é " + notas.get(2));

    // Exiba a menor nota
    // System.out.println("A menor nota da lista é " + Collections.min(notas));

    // Exiba a maior nota
    // System.out.println("A maior nota da lista é " + Collections.max(notas));

    // Exiba a soma dos valores
    // Double soma = 0d;
    // for (Double nota : notas) soma += nota;
    // System.out.println("A soma das notas é " + soma);

    // Exiba a média das notas
    // System.out.println("A média das notas é " + soma/notas.size() );

    // Remova a nota '0'
    // notas.remove(0d);
    // System.out.println("Removendo a nota '0'");
    // System.out.println(notas);

    // Remova a nota da posição '0'
    // notas.remove(0);
    // System.out.println("Removendo a nota da posição '0'");
    // System.out.println(notas);

    // Remova as notas menores que '7'
    // Iterator<Double> iterador = notas.iterator();
    // while (iterador.hasNext()) {
    //   Double prox = iterador.next();
    //   if (prox < 7) iterador.remove();
    // }
    // System.out.println("Removendo as notas menores que '7'");
    // System.out.println(notas);

    // Apague toda a lista
    // notas.clear();
    // System.out.println("Removendo todos os elementos da lista");
    
    // Confira se a lista está vazia
    // System.out.println("A lista está vazia? " + ( notas.isEmpty() ? "Sim" : "Não" ) );
    
    // System.out.println(notas);
  }
}