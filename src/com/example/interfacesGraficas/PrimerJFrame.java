package com.example.interfacesGraficas;

import javax.swing.*;

public class PrimerJFrame {

    public static void main(String[] args) {

        /*
            En la creación inicial la ventana se crea:
            - invisible
            - con tamaño 0 px
            - sin comportamiento para el cierre

            Es necesario inciar estos atributos para que la ventana sea útil.
            https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html
         */

        // Creación ventana
        JFrame ventana = new JFrame();

        // Asignamos un tamaño en píxeles
        ventana.setSize(640,480);

        // Asignamos un valor al comportamiento del cierre
        // Se le debe pasar un "int", pero lo que se le suele pasar son constantes con el valor "int" deseado.
        // https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html#setDefaultCloseOperation-int-
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Si no deseamos cerrar la aplicación, pues no es la ventana principal,
        // elegimos el valor HIDE_ON_CLOSE
        //ventana.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        // OPCIONAL, asignamos una ubicación de creación.
        // Hay sobrecarga de métodos. Usamos uno sencillo que se basa en ubicación por píxles
        ventana.setLocation(640,480);

        // La hacemos visible
        // IMPORTANTE: asignar esta propiedad en último lugar para que el refresco
        // de la información.
        ventana.setVisible(true);

    }
}
