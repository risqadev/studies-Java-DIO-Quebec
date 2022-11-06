package Exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class CustomExceptions {
  public static void main(String[] args) {
    String crouchRomances = "romances-blake-crouch.txt";
    
    printFile(crouchRomances);
    
    System.out.println("Apesar da exception, o programa continua.");
  }

  private static void printFile (String filename) {
    try {
      BufferedReader br = readFile(filename);
      String line = br.readLine();
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  
      do {
        bw.write(line);
        bw.newLine();
        line = br.readLine();
      } while (line != null);
      bw.flush();
      br.close();
    } catch (CustomFileNotFoundException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Outro erro de IO. Contate o suporte.\n" + e.getMessage());
    }
  }

  private static BufferedReader readFile(String filename) throws CustomFileNotFoundException {
    File file = new File(filename);
    try {
      return new BufferedReader(new FileReader(file.getName()));
    } catch (FileNotFoundException e) {
      throw new CustomFileNotFoundException(file.getName(), file.getAbsolutePath());
    }
  }
}

class CustomFileNotFoundException extends Exception {
  private String filename;
  private String directory;
  
  public CustomFileNotFoundException(String filename, String directory) {
    super("File " + filename + " not found in directory "  + directory);
    this.filename = filename;
    this.directory = directory;
  }
  
  @Override
  public String toString() {
    return "CustomFileNotFoundException [filename=" + filename + ", directory=" + directory + "]";
  }
}