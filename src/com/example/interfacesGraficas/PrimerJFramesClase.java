package com.example.interfacesGraficas;

import javax.swing.*;

public class PrimerJFramesClase {

    public static void main(String[] args) {

        // Instanciamos un Frame
        CreaJFrame ventana = new CreaJFrame();
    }
}

// La forma adecuada de crear Frames es crear el JFrame mediante una clase
// específica en lugar de hacerlo en el main para poder organizar mejor el
// código y poder reutilizarlo.

class CreaJFrame extends JFrame {

    public CreaJFrame (){

        setSize(640,480);
        // Muchas gente pone este método en el main
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(640,480);
        // Mucha gente pone este método en el main
        // Recordar que debe ir en último lugar
        setVisible(true);
    }
}