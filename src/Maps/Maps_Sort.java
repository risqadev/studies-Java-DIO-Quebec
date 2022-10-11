package Maps;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class Maps_Sort {
  /**
   * autor: Hawking, Stephen; nome: Uma Breve História do Tempo; páginas: 256.
   * autor: Duhiga, Charles; nome: O Poder do Hábito; páginas: 408.
   * autor: Harari, Yuval Noah; nome: 21 Lições Para o Século 21; páginas: 432.
   * 
   * Dadas as seguintes informações sobre meus livros favoritos e seus autores,
   * crie um dicionário e ordene-o, exibindo
   * (nome do autor - nome do livro).
   * 
   * a. Exiba em ordem aleatória;
   * b. Exiba em ordem de inserção;
   * c. Exiba em ordem alfabética dos autores;
   * d. Exiba em ordem alfabética dos nomes dos livros;
   * e. Exiba em ordem crescente dos números de páginas.
   */
  public static void main(String[] args) {
    Map<String, Livro> livros1 = new HashMap<>(){{
      put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
      put("Duhiga, Charles", new Livro("O Poder do Hábito", 408));
      put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
    }};
    System.out.println("Ordem aleatória:");
    for (Map.Entry<String, Livro> livro : livros1.entrySet()) {
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }

    Map<String, Livro> livros2 = new LinkedHashMap<>(){{
      put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
      put("Duhiga, Charles", new Livro("O Poder do Hábito", 408));
      put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
    }};
    System.out.println("Ordem de inserção:");
    for (Map.Entry<String, Livro> livro : livros2.entrySet()) {
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }

    Map<String, Livro> livros3 = new TreeMap<>(livros1);
    System.out.println("Ordem natural (alfabética de autores):");
    for (Map.Entry<String, Livro> livro : livros3.entrySet()) {
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }

    Set<Map.Entry<String, Livro>> livros4 = new TreeSet<>(new ComparatorNome());
    livros4.addAll(livros1.entrySet());
    System.out.println("Ordem alfabética dos nomes dos livros:");
    for (Map.Entry<String,Livro> livro : livros4) {
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }

    Set<Map.Entry<String, Livro>> livros5 = new TreeSet<>(new ComparatorPagina());
    livros5.addAll(livros1.entrySet());
    System.out.println("Ordem da qtde de páginas:");
    for (Map.Entry<String,Livro> livro : livros5) {
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas());
    }
  }
}

class Livro {
  private String nome;
  private int paginas;

  public Livro(String nome, int paginas) {
    this.nome = nome;
    this.paginas = paginas;
  }

  public String getNome() {
    return nome;
  }

  public Integer getPaginas() {
    return paginas;
  }

  @Override
  public String toString() {
    return "[nome=" + nome + ", paginas=" + paginas + "]";
  }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

  @Override
  public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
    return l1.getValue().getNome().compareTo(l2.getValue().getNome());
  }
}

class ComparatorPagina implements Comparator<Map.Entry<String, Livro>> {

  @Override
  public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
    return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
  }
}