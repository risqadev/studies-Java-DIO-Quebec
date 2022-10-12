package Maps;

import java.util.HashMap;
import java.util.Random;

public class Maps_Ex2 {
  /**
   * Write a program that simulates rolling dice. Cast it 100 times.
   * Then show how many times each side was drawn.
   */
  public static void main(String[] args) {
    Dice dice1 = new Dice(6);
    System.out.println(dice1);
    dice1.throwMany(100);
    System.out.println(dice1);
    
  }
}

class Dice {
  private HashMap<Integer, Integer> accumulator = new HashMap<>();
  private int size;
  
  public Dice(int size) {
    this.size = size;
    for (int i = 1; i <= size; i++) {
      accumulator.put(i, 0);
    }
  }
  
  public int getSize() {
    return size;
  }
  
  private void increment(int side) {
    accumulator.put(side, accumulator.get(side) + 1);
  }
  
  public void throwOne() {
    Random r = new Random();
    increment(r.nextInt(this.size) + 1);
  }

  public void throwMany(int n) {
    for (int i = 0; i < n; i++) throwOne();
  }

  @Override
  public String toString() {
    return "Dice " + accumulator;
  }
}