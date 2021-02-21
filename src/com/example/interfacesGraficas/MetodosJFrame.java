package com.example.interfacesGraficas;

import javax.swing.*;

public class MetodosJFrame {

    public static void main(String[] args) {

        // Instanciamos un Frame
        CrearJFrame ventana = new CrearJFrame();
    }
}

// La forma adecuada de crear Frames es crear el JFrame mediante una clase
// específica en lugar de hacerlo en el main para poder organizar mejor el
// código y poder reutilizarlo.

class CrearJFrame extends JFrame {

    public CrearJFrame (){

        // Método para ubicar y definir la posición en una única llamada
        setBounds(900,500,640,480);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Método para ubicar la ventana en el medio, pasando null como parámetro
        setLocationRelativeTo(null);

        // Método para permitir (true) o no (false) que la ventana sea redimensionable
        setResizable(true);

        // Método para establecer el estado inicial de una ventana/frame
        // (minimizada=ICONIFIED, maximizada=MAXIMIZED_BOTH)
        // https://docs.oracle.com/javase/7/docs/api/java/awt/Frame.html#setExtendedState(int)
        setExtendedState(NORMAL);

        // Aplicar título a la ventana
        setTitle("JFrame de pruebas");

        // Siempre hacer visible en último lugar
        setVisible(true);
    }

}
