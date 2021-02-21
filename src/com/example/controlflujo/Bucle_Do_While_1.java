package com.example.controlflujo;

import javax.swing.*;

public class Bucle_Do_While_1 {

    public static void main(String[] args) {

        String clave = "secreto";
        String input_usuario = "";

        // El bloque de código del do-while se ejecutará seguro al menos una vez
         do {
            input_usuario = JOptionPane.showInputDialog("Por favor, introduce contraseña");
            if (!clave.equals(input_usuario)) {
                // Implementamos la opción de warning en el showMessageDialog
                JOptionPane.showMessageDialog(null,"Contraseña incorrecta","Aviso",JOptionPane.WARNING_MESSAGE);
            }
        } while (!clave.equals(input_usuario));
        JOptionPane.showMessageDialog(null,"Acceso autorizado");
    }
}
