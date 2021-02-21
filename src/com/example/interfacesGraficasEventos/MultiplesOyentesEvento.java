package com.example.interfacesGraficasEventos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Creamos una ventana con dos botones.
* Un botón que llame a una clase que crea ventanas.
* Otro botón que será el oyente y que pasaremos como parámetro a las nuevas ventanas
* con el fin de que cuando sea pulsado, el evento viaje a cada ventana y haga lo que
* se desee. En nuestro ejemplo, cerrar la ventana. */

public class MultiplesOyentesEvento {

    public static void main(String[] args) {

        VentanaMultOyentesEvento ventana = new VentanaMultOyentesEvento();

    }
}

class VentanaMultOyentesEvento extends JFrame {

    public VentanaMultOyentesEvento () {

        setBounds(900,300,320,240);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Ventana Principal");

        add(new PanelPrincipal());

        setVisible(true);
    }
}

class PanelPrincipal extends JPanel implements ActionListener {

    JButton cerrarVentanas;

    public PanelPrincipal(){

        /* Creamos un botón normal que llame a la clase de crear ventanas. */
        JButton nuevaVentana = new JButton("Crear ventana");
        add(nuevaVentana);
        nuevaVentana.addActionListener(this);

        cerrarVentanas = new JButton("Cerrar ventanas");
        add(cerrarVentanas);

    }

    /* Aquí está la clave. En la acción de crear la ventana, pasamos como parámetro
    * el botón de cerrar ventanas, para que actúe como "listener" en cada nueva
    * ventana creada, además de actuar como objeto fuente, en la ventana principal. */
    @Override
    public void actionPerformed(ActionEvent e) {
        NuevaVentana ventanita = new NuevaVentana(cerrarVentanas);
    }
}

/* INTERFACES Y CLASES DE INTERES
*
* Usamos el método "dispose" de la clase JFrame, que permite cerrar ventanas y
* liberar los recursos del sistema de las mismas. */
class NuevaVentana extends JFrame {

    private static int contador = 0;

    public NuevaVentana (JButton boton) {

        contador++;
        setTitle("Ventana "+contador);
        setBounds(50*contador,50*contador,320,240);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setVisible(true);

        boton.addActionListener(new cierraVentanas());

    }

    private class cierraVentanas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /* Aquí usamos el método para cerrar la ventana, que se ejecutará
            * a la vez en todas las ventanas hijas, pues el evento se replicará
            * para todas al tener el mismo listener. */
            dispose();
        }
    }
}
