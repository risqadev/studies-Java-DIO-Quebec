package Exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class CheckedExceptions {
  public static void main(String[] args) {
    
  }

  private static void printFile (String filename) {
    File file = new File(filename);
    BufferedReader br = new BufferedReader(new FileReader(file.getName()));
    String line = br.readLine();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    do {
      bw.write(line);;
      bw.newLine();
      line = br.readLine();
    } while (line != null);
    bw.flush();
    br.close();
  }
}

