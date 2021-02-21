package com.example.interfacesGraficasEventos;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventosDeVentana {

    public static void main(String[] args) {

        /* Creamos dos ventanas para poder ver la interacción de los eventos */
        EventosVentana ventana = new EventosVentana();
        EventosVentana ventana2 = new EventosVentana();

        ventana.addWindowListener(new GeneraEventosVentana());
        ventana2.addWindowListener(new GeneraEventosVentana());

    }
}

class EventosVentana extends JFrame {

    public EventosVentana() {

        setSize(640,480);
        // Para que aparezca en el centro
        setLocationRelativeTo(null);
        /* Implementamos el cierre con "DISPOSE_ON_CLOSE", para que de tiempo a
           que se ejecute el evento de ventana cerrada, porque si no, el programa
           cerraría antes de que se ejecute el método. */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Eventos en Ventana");

        setVisible(true);
    }
}

/* Como queremos trabajar con eventos de ventana, necesitamos implementar la interfaz
* "WindowsListener", junto con todos sus métodos. */
class GeneraEventosVentana implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Ventana Abierta");
    }

    /* Se ejecuta durante el proceso de cierre. */
    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Ventana Cerrando...");
    }

    /* Se ejecuta una vez la ventana está ya cerrada. */
    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Ventana Cerrada");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Ventana Minimizada");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Ventana Restaurada");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Ventana a primer plano");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Ventana a segundo plano");
    }
}
