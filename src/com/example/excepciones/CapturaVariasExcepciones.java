package com.example.excepciones;

import javax.swing.*;

public class CapturaVariasExcepciones {

    public static void main(String[] args) {

        /* VARIAS EXCEPCIONES
        *
        * Capturar varias excepciones es tan sencillo como incluir tantas cláusulas
        * "catch" como excepciones se deseen capturar/controlar. */
        try {
            division();
        }
        catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null,"División por 0 no permitida");
            // En lugar de imprimir la traza completa de la excepción, podemos
            // imprimir solo el nombre de la excepción generada.
            System.out.println(e.getClass().getName());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Valor de entrada inválido");
            System.out.println(e.getClass().getName());
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error no controlado");
            System.out.println(e.getClass().getName());
        }
        /* La cláusula "catch" no es obligatoria para excepciones de tipo RuntimeException,
         * pero si no se usa lo que estaremos haciendo es no capturar la excepción concreta,
         * siendo necesario usar una cláusula "finally" en este caso.
         * Las instruccioes incluidas en la cláusula "finally" se ejecutarán siempre, se
         * genere o no excepción en el "try". */

        finally {
            System.out.println("Sentencias cláusula finally");
        }
    }

    static void division (){
        int dividendo = Integer.parseInt(JOptionPane.showInputDialog("Introduce dividendo"));
        int divisor = Integer.parseInt(JOptionPane.showInputDialog("Introduce dividendo"));

        JOptionPane.showMessageDialog(null,"El resultado de la división es "+(dividendo/divisor));
    }
}
