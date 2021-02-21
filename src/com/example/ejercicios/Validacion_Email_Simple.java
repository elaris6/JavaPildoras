package com.example.ejercicios;

import javax.swing.*;

public class Validacion_Email_Simple {

    public static void main(String[] args) {

        // Solo se cxontrola que tenga una y no más arrobas, que tenga un punto
        // y que tenga más de 4 caracteres

        String email;
        int arrobas;
        int puntos;
        int lenght_email;
        while (true) {
            arrobas = 0;
            puntos = 0;
            email = JOptionPane.showInputDialog("Introduce una dirección de email válida");
            lenght_email = email.length();
            if (lenght_email > 3) {
                for (int i=0;i<lenght_email;i++) {
                    if (email.charAt(i) == '@') arrobas++;
                    if (email.charAt(i) == '.') puntos++;
                } // fin for lenght
            } // fin if
            if (arrobas != 1 || puntos == 0) {
                JOptionPane.showMessageDialog(null,"La dirección introducida no es válida");
            }
            else break;
        } // fin while
        JOptionPane.showMessageDialog(null,"Validaciones email OK");
    }
}
