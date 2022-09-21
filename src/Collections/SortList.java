package Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** Given the following information about some cats, create a list and sort it by displaying:
(name - age - color);
Cat 1 = name: Jon, age: 18, color: black
Cat 2 = name: Simba, age: 6, color: white
Cat 3 = name: Jon, age: 12, color: yellow
*/

public class SortList {
  public static void main(String[] args) {
    List<Cat> myCats = new ArrayList<>(){{
      add(new Cat("Jon", 18, "black"));
      add(new Cat("Simba", 6, "white"));
      add(new Cat("Jon", 12, "yellow"));
    }};

    // in order of insertion
    System.out.println("List in order of insertion");
    System.out.println(myCats);

    // in random order
    Collections.shuffle(myCats);
    System.out.println("List in random order");
    System.out.println(myCats);

    // in natural order (by name)
    Collections.sort(myCats);
    System.out.println("List in natural order (by name)");
    System.out.println(myCats);
    
    // in order of age
    myCats.sort(new AgeComparator());
    // Collections.sort(myCats, new AgeComparator());
    System.out.println("List in order of age");
    System.out.println(myCats);

    // in color order
    // myCats.sort(new ColorComparator());
    Collections.sort(myCats, new ColorComparator());
    System.out.println("List in color order");
    System.out.println(myCats);

    // in order of name, color and age
    myCats.sort(new NameColorAgeComparator());
    System.out.println("List in order of name, color and age");
    System.out.println(myCats);

  }
}

class Cat implements Comparable<Cat> {
  private String name;
  private Integer age;
  private String color;
  
  public Cat(String name, Integer age, String color) {
    this.name = name;
    this.age = age;
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String getColor() {
    return color;
  }

  @Override
  public String toString() {
    return "{age: " + age + ", color: " + color + ", name: " + name + "}";
  }

  @Override
  public int compareTo(Cat cat) {
    return this.getName().compareToIgnoreCase(cat.getName());
  }
}

class AgeComparator implements Comparator<Cat> {
  @Override
  public int compare(Cat c1, Cat c2) {
    return Integer.compare(c1.getAge(), c2.getAge());
  }
}

class ColorComparator implements Comparator<Cat> {
  @Override
  public int compare(Cat c1, Cat c2) {
    return c1.getColor().compareToIgnoreCase(c2.getColor());
  }
}

class NameColorAgeComparator implements Comparator<Cat> {
  @Override
  public int compare(Cat c1, Cat c2) {
    int nameCompare = c1.getName().compareToIgnoreCase(c2.getName());
    if (nameCompare != 0) return nameCompare;
    int colorCompare = c1.getColor().compareToIgnoreCase(c2.getColor());
    if (colorCompare != 0) return colorCompare;
    return Integer.compare(c1.getAge(), c2.getAge());
  }
}