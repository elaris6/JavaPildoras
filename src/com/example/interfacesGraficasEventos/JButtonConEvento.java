package com.example.interfacesGraficasEventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* https://docs.oracle.com/javase/8/docs/api/javax/swing/JButton.html */

public class JButtonConEvento {

    public static void main(String[] args) {

        VentanaJButtonEvento ventana = new VentanaJButtonEvento();
    }
}

class VentanaJButtonEvento extends JFrame {

    public VentanaJButtonEvento() {

        setSize(640,480);
        setLocationRelativeTo(null); //Para ubicarlo en el medio de la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("JButton con Evento");

        PanelJButtonEvento panel = new PanelJButtonEvento();
        add(panel);

        setVisible(true);

    }
}

/* Para gestionar eventos es obligatorio implementar la interfaz "ActionListener",
y por tanto el método "actionPerformed". */
class PanelJButtonEvento extends JPanel implements ActionListener {

    /* Creamos un JButton con uno de sus constructores que solo pide un String
    https://docs.oracle.com/javase/8/docs/api/javax/swing/JButton.html */
    JButton botonColores = new JButton("Aleatorio");
    JButton botonBlanco = new JButton("Blanco");
    JButton botonNegro = new JButton("Negro");

    int red;
    int green;
    int blue;

    /* Dentro del constructor del panel, es necesario añadir el elemento de tipo
    * JButton, al igual que añadimos el panel a la ventana.
    * Aquí se requiere implementar el método requerido "addActionListener", cuyo argumento
    * es el objeto destino de la acción. En nuestro ejemplo, el propìo panel. */
    public PanelJButtonEvento(){

        add(botonBlanco);
        add(botonColores);
        add(botonNegro);

        botonColores.addActionListener(this);
        botonBlanco.addActionListener(this);
        botonNegro.addActionListener(this);
    }

    /* Este método es el encargado de ejecutar la acción que desencadena el evento. */
    @Override
    public void actionPerformed(ActionEvent e) {

        /* Empleamos el método "getActionCommand" de la clase "ActionEvent"
        * Para conocer el origen del evento y poder actuar en consecuencia.
        * En el curso se resuelve de forma más correcta con:
        *
        * Object botonPulsado = e.getSource();
        *
        * if (botonPulsado == botonColores) { .... }
        *
        * https://docs.oracle.com/javase/7/docs/api/java/util/EventObject.html
        * */
        if (e.getActionCommand().equals("Aleatorio")) {

            // Asignamos números aleatorios a los valores de RGB
            red = (int) ((Math.random() * 255) + 0);
            green = (int) ((Math.random() * 255) + 0);
            blue = (int) ((Math.random() * 255) + 0);

            // Asignamos los valores RGB random al fondo del panel
            setBackground(new Color(red, green, blue));
        }
        else if (e.getActionCommand().equals("Blanco")) {
            setBackground(new Color(255, 255, 255));
        }
        else if (e.getActionCommand().equals("Negro")) {
            setBackground(new Color(0, 0, 0));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
