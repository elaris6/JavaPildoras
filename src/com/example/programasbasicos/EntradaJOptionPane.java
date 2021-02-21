package com.example.programasbasicos;

import javax.swing.JOptionPane;

public class EntradaJOptionPane {

    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog("Dime tu nombre pisha!");

        // Para capturar un entero es necesario usar el método parseInt de la clase Integer
        // pues showInputDialog siempre devuevle String
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Dime tu edad pisha!"));

        // Aquí usamos el método showMessageDialog para mostrar un mensaje emergente
        // con los datos capturados :)
        String mensaje = "Hola "+nombre+" tienes "+edad+" años.";
        JOptionPane.showMessageDialog(null,mensaje);

    }
}
