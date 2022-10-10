package Collections;

import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Sets_Ex2 {
  /**
   * Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao
   * e ide. Em seguida, crie um conjunto com 3 linguagens e faça um programa que
   * ordene esse conjunto por:
   * a. ordem de inserção;
   * b. ordem natural (nome);
   * c. IDE;
   * d. ano de criação e nome;
   * e. nome, ano de criação e IDE. (fiz junto com a 'b')
   */
  public static void main(String[] args) {

    Set<Linguagem> linguagens1 = new LinkedHashSet<>(){{
      add(new Linguagem("Javascript", 1995, "Visual Studio Code"));
      add(new Linguagem("C", 1972, "Notepad"));
      add(new Linguagem("Java", 1995, "Eclipse IDE"));
    }};
    System.out.println("Ordem de inserção (LinkedHashSet):\n" + linguagens1);

    Set<Linguagem> linguagens2 = new TreeSet<>(linguagens1);
    System.out.println("Ordem natural (TreeSet):\n" + linguagens2);

    Set<Linguagem> linguagens3 = new TreeSet<>(new CompareIde());
    linguagens3.addAll(linguagens1);
    System.out.println("Ordem de IDEs (TreeSet):\n" + linguagens3);

    Set<Linguagem> linguagens4 = new TreeSet<>(new CompareAnoIde()){{
      addAll(linguagens1);
    }};
    System.out.println("Ordem de IDE:\n" + linguagens4);
  }
}



class Linguagem implements Comparable<Linguagem> {
  private String nome;
  private Integer anoDeCriacao;
  private String ide;

  public Linguagem(String nome, Integer anoDeCriacao, String ide) {
    this.nome = nome;
    this.anoDeCriacao = anoDeCriacao;
    this.ide = ide;
  }

  public String getNome() {
    return this.nome;
  }

  public Integer getAnoDeCriacao() {
    return this.anoDeCriacao;
  }

  public String getIde() {
    return this.ide;
  }

  @Override
  public String toString() {
    return "{\n  nome: " + nome + ",\n  anoDeCriacao: " + anoDeCriacao + ",\n  ide: " + ide + "\n}";
  }

  @Override
  public int compareTo (Linguagem linguagem) {
    int nome = this.getNome().compareTo(linguagem.getNome());
    if (nome != 0) return nome;
    int ano = this.getAnoDeCriacao().compareTo(linguagem.getAnoDeCriacao());
    if (ano != 0) return ano;
    return this.getIde().compareTo(linguagem.getIde());
  }
  
}

class CompareIde implements Comparator<Linguagem> {
  @Override
  public int compare(Linguagem l1, Linguagem l2) {
    return l1.getIde().compareTo(l2.getIde());
  }
}

class CompareAnoIde implements Comparator<Linguagem> {
  @Override
  public int compare (Linguagem l1, Linguagem l2) {
    int ano = l1.getAnoDeCriacao().compareTo(l2.getAnoDeCriacao());
    if (ano != 0) return ano;
    return l1.getIde().compareTo(l2.getIde());
  }
}