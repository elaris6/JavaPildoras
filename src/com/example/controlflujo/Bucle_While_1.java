package com.example.controlflujo;

import javax.swing.*;

public class Bucle_While_1 {

    public static void main(String[] args) {

        /*
        int i=0;
        while (i<10) {
            System.out.println("Iteración " + i);
            i+=1;
        }
        */

        String clave = "secreto";
        String input_usuario = "";

        while (!clave.equals(input_usuario)) {

            input_usuario = JOptionPane.showInputDialog("Por favor, introduce contraseña");
            if (!clave.equals(input_usuario)) {
                // Implementamos la opción de warning en el showMessageDialog
                JOptionPane.showMessageDialog(null,"Contraseña incorrecta","Aviso",JOptionPane.WARNING_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null,"Acceso autorizado");
    }
}
