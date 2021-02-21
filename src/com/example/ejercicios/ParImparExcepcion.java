package com.example.ejercicios;

import javax.swing.*;

public class ParImparExcepcion {

    public static void main(String[] args) {

        int num=0;
        double numD=0;
        String input;
        input=JOptionPane.showInputDialog("Introduce un número");

        try {
            num=Integer.parseInt(input);
        }
        catch (NumberFormatException e1) {
            try {
                numD=Double.parseDouble(input);
                JOptionPane.showMessageDialog(null,"El valor introducido no es un número entero.\nEl programa se cerrará.");
                System.exit(1);
            }
            catch (NumberFormatException e2) {
                JOptionPane.showMessageDialog(null,"El valor introducido no es un número.\nEl programa se cerrará.");
                System.exit(1);
            }
        }

        if (num%2 == 0) JOptionPane.showMessageDialog(null,"El número es par");
        else JOptionPane.showMessageDialog(null,"El número es impar");

    }
}
