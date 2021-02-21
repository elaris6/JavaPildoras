package com.example.ejercicios;

import javax.swing.*;

public class Factorial_Numero {

    public static void main(String[] args) {

        // Calcular el factorial de un número entero.
        // Dicho número multiplicado por todos los que le preceden.
        // Factorial de 5 es 5x4x3x2x1

        while (true) {
            int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número\npara caluclar su factorial"));
            long resultado = 1;
            for (int i = num; i > 0; i--) {
                System.out.println("i=" + i + " resultado=" + resultado);
                resultado *= i;
                System.out.println("resultado=" + resultado);

            }
            String mensaje = "El factorial de " + num + " es: " + resultado;
            JOptionPane.showMessageDialog(null, mensaje);
            String salir = JOptionPane.showInputDialog("Quieres salir S/N");
            if (salir.equals("s") || salir.equals("S")) break;
        }
    }
}
