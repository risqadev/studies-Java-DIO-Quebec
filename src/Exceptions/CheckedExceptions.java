package Exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;

public class CheckedExceptions {
  public static void main(String[] args) {
    String crouchRomances = "romances-blake-crouch.txt";
    try {
      printFile(crouchRomances);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Verifique o nome do arquivo informado.\n" + e.getMessage());
    } catch (IOException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Outro erro de IO. Contate o suporte.\n" + e.getMessage());
    } finally {
      System.out.println("Esse bloco sempre será executado, ocorrendo ou não exceptions.");
    }
    System.out.println("Apesar da exception, o programa continua.");
  }

  private static void printFile (String filename) throws IOException {
    File file = new File(filename);
    BufferedReader br = new BufferedReader(new FileReader(file.getName()));
    String line = br.readLine();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    do {
      bw.write(line);
      bw.newLine();
      line = br.readLine();
    } while (line != null);
    bw.flush();
    br.close();
  }
}

