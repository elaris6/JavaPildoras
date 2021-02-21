package com.example.interfacesGraficasEventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Vamos a modificar la el programa "JButtonConEvento" para modificar el listener,
* de forma que pase a ser el Objeto "Color", en lugar del panel. */

public class JButtonConEvento2 {

    public static void main(String[] args) {

        VentanaJButtonEvento2 ventana = new VentanaJButtonEvento2();
    }
}

class VentanaJButtonEvento2 extends JFrame {

    public VentanaJButtonEvento2() {

        setSize(640,480);
        setLocationRelativeTo(null); //Para ubicarlo en el medio de la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("JButton con Evento 2");

        PanelJButtonEvento2 panel = new PanelJButtonEvento2();
        add(panel);

        setVisible(true);

    }
}

/* Para gestionar eventos es obligatorio implementar la interfaz "ActionListener",
y por tanto el método "actionPerformed". */
class PanelJButtonEvento2 extends JPanel {

    /* Creamos un JButton con uno de sus constructores que solo pide un String
    https://docs.oracle.com/javase/8/docs/api/javax/swing/JButton.html */
    JButton botonColores = new JButton("Aleatorio");
    JButton botonBlanco = new JButton("Blanco");
    JButton botonNegro = new JButton("Negro");


    /* Dentro del constructor del panel, es necesario añadir el elemento de tipo
     * JButton, al igual que añadimos el panel a la ventana. */

    public PanelJButtonEvento2(){

        add(botonBlanco);
        add(botonColores);
        add(botonNegro);

        ColorDeFondo blanco = new ColorDeFondo(Color.WHITE);
        ColorDeFondo negro = new ColorDeFondo(Color.BLACK);
        ColorDeFondo colores = new ColorDeFondo(Color.GRAY);

        /* Aquí se requiere implementar el método requerido "addActionListener", cuyo argumento
        es el objeto destino de la acción. En nuestro ejemploactual, el Objeto "Color". */
        botonColores.addActionListener(colores);
        botonBlanco.addActionListener(blanco);
        botonNegro.addActionListener(negro);
    }

    /* También aquí implementamos el método requerido "actionPerformed", que es el encargado
    * de llevar a cabo la acción, recibiendo el Objeto "ActionEvent" que se genera automáticamente
    * al realizarse el evento. */
    private class ColorDeFondo implements ActionListener {

        private Color colorDeFondo;
        private int red;
        private int green;
        private int blue;

        public ColorDeFondo(Color c) {

            colorDeFondo = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == botonColores) {

                // Asignamos números aleatorios a los valores de RGB
                red = (int) ((Math.random() * 255) + 0);
                green = (int) ((Math.random() * 255) + 0);
                blue = (int) ((Math.random() * 255) + 0);

                colorDeFondo = new Color(red,green,blue);
            }
            setBackground(colorDeFondo);
        }
    }
}

