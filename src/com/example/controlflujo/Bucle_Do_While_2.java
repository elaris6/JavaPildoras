package com.example.controlflujo;

import javax.swing.*;

public class Bucle_Do_While_2 {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,"Este programa cuenta los caracteres de la cadena introducida\n"
                +"Para terminar, pulsa salir");

        /* String texto = "";
           while (!texto.equals("salir")) {

               texto = JOptionPane.showInputDialog("Introduce una cadena de texto");
               if (!texto.equals("salir")) JOptionPane.showMessageDialog(null,"El texto tiene: "
                       +texto.length()+ " caracteres");
           }
           JOptionPane.showMessageDialog(null,"Has salido del programa");
        */
        // En este caso la ventaja es que podemos prescindir de inicializar la variable
        // de manera previa al bucle. Hay que declararla, pero no hace falta inicializarla
        String texto;
        do {
            texto = JOptionPane.showInputDialog("Introduce una cadena de texto");
            if (!texto.equals("salir")) JOptionPane.showMessageDialog(null,"El texto tiene: "
                    +texto.length()+ " caracteres");
        } while (!texto.equals("salir"));
        JOptionPane.showMessageDialog(null,"Has salido del programa");
    }
}
