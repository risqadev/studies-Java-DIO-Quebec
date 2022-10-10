package Collections;

import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sets_Sort {
  /**
   * Dadas as seguintes informações sobre minhas séries favoritas,
   * crie um conjunto e ordene-o, exibindo:
   * (nome - genero - tempo de episodio)
   * 
   * Série 1 = nome: GoT, genero: fantasia, tempoEpisodio: 60
   * Série 2 = nome: Dark, genero: drama, tempoEpisodio: 60
   * Série 3 = nome: That '70s show, genero: comedia, tempoEpisodio: 25
   */
  public static void main(String[] args) {

    // Ordem aleatória: HashSet
    Set<Serie> series1 = new HashSet<>(){{
      add(new Serie("GoT", "fantasia", 60));
      add(new Serie("Dark", "drama", 60));
      add(new Serie("That '70s show", "comédia", 25));
    }};
    System.out.println("Ordem aleatória: HashSet: ");
    for (Serie serie : series1)
      System.out.printf("%s - %s - %d %n", serie.getNome(), serie.getGenero(), serie.getTempoEpisodio());
    
    // Ordem de inserção: LinkedHashSet
    Set<Serie> series2 = new LinkedHashSet<>(){{
      add(new Serie("GoT", "fantasia", 60));
      add(new Serie("Dark", "drama", 60));
      add(new Serie("That '70s show", "comédia", 25));
    }};
    System.out.println("Ordem de inserção: LinkedHashSet");
    for (Serie serie : series2)
      System.out.printf("%s - %s - %d %n", serie.getNome(), serie.getGenero(), serie.getTempoEpisodio());
    
    // Ordem natural do tempo de episódio: TreeSet
    Set<Serie> series3 = new TreeSet<>(series1);
    System.out.println("Ordem natural de tempoEpisodio: TreeSet");
    System.out.println(series3);
    // ou
    Set<Serie> series4 = new TreeSet<>(new ComparatorNomeGeneroTempo());
    series4.addAll(series2);
    System.out.println("Ordem natural Nome-Genero-Tempo: TreeSet");
    System.out.println(series4);

  }
}

class Serie implements Comparable<Serie> {
  private String nome;
  private String genero;
  private Integer tempoEpisodio;

  public Serie (String nome, String genero, Integer tempo) {
    this.nome = nome;
    this.genero = genero;
    this.tempoEpisodio = tempo;
  }

  public String getNome() {
    return nome;
  }

  public String getGenero() {
    return genero;
  }

  public Integer getTempoEpisodio() {
    return tempoEpisodio;
  }

  @Override
  public String toString() {
    return  "{ nome: " + nome +
            ", genero: " + genero +
            ", tempoEpisodio: " + tempoEpisodio + " }";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((genero == null) ? 0 : genero.hashCode());
    result = prime * result + ((tempoEpisodio == null) ? 0 : tempoEpisodio.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Serie other = (Serie) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (genero == null) {
      if (other.genero != null)
        return false;
    } else if (!genero.equals(other.genero))
      return false;
    if (tempoEpisodio == null) {
      if (other.tempoEpisodio != null)
        return false;
    } else if (!tempoEpisodio.equals(other.tempoEpisodio))
      return false;
    return true;
  }

  @Override
  public int compareTo(Serie serie) {
    int tempo = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
    if (tempo != 0)
      return tempo;
    return this.getNome().compareTo(serie.getNome());
  }
}

class ComparatorNomeGeneroTempo implements Comparator<Serie> {

  @Override
  public int compare(Serie s1, Serie s2) {
    int nome = s1.getNome().compareTo(s2.getNome());
    if (nome != 0) return nome;
    int genero = s1.getGenero().compareTo(s2.getGenero());
    if (genero != 0) return genero;
    return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
  }
}