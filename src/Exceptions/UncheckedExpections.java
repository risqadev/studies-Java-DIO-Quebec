package Exceptions;

import javax.swing.JOptionPane;

public class UncheckedExpections {
  public static void main(String[] args) {
    /* Em tempo de execução pode ocorrer os seguintes erros: caso o usuário informe
    um valor que não pode ser convertido para inteiro, como uma palavra, irá
    estourar uma NumberFormatException; ou caso informe o valor zero no denominador,
    estourando uma ArithmeticException. Ambas são excessões do tipo unchecked,
    ou seja o compilador não nos obriga a tratá-la, mas caso ela ocorra, o programa
    para, não tendo como se recuperar e continuar a execução.
    Como sabemos que a exceção pode ocorrer, podemos tratá-la, permitindo que
    o nosso programa possa se recuperar e continuar a sua execução.
    */
    Boolean continueLoop = true;
    do {
      try {
        String a = JOptionPane.showInputDialog("Numerador: ");
        String b = JOptionPane.showInputDialog("Denominador: ");

        int resultado = Integer.parseInt(a) / Integer.parseInt(b);
        JOptionPane.showMessageDialog(null, "Resultado a/b: " + resultado);
        continueLoop = false;
      } catch (NumberFormatException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Você inseriu um valor inválido. Informe somente números inteiros.");
      } catch (ArithmeticException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Atenção! Não é possível dividir por zero. Informe um valor diferente de zero no denominador.");
      } finally {
        JOptionPane.showMessageDialog(null, "O bloco finally é executado ao final, tanto em caso de sucesso quanto de falha.");
      }
    } while (continueLoop);

    JOptionPane.showMessageDialog(null, "O programa pode continuar...");
  }
}
