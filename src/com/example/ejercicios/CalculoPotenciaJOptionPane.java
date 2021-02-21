package com.example.ejercicios;

import javax.swing.JOptionPane;

public class CalculoPotenciaJOptionPane {

    public static void main(String[] args) {
        // Ejercicios 3 y 4 vídeo 21, pero con salida en showMessageDialog en vez de consola

        /*
        int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce un valor para la base"));
        int exp = Integer.parseInt(JOptionPane.showInputDialog("Introduce un valor para el exponente"));
        String resultado = "El resultado de "+base+" elevado a "+exp+" es "+Math.pow(base,exp);
        JOptionPane.showMessageDialog(null,resultado);
        */

        // En una sola línea pasando todo como argumento
        JOptionPane.showMessageDialog(null,
                "El resultado es "+Math.pow(Integer.parseInt(JOptionPane.showInputDialog("Introduce la base")),
                        Integer.parseInt(JOptionPane.showInputDialog("Introduce el exponente"))));

    }
}
