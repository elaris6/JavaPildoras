package com.example.interfacesGraficasEventos;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventosVentanaClasesAdaptadoras {

    public static void main(String[] args) {

        EventosVentana2 ventana = new EventosVentana2();

        ventana.addWindowListener(new GeneraEventosVentana2());

    }
}

class EventosVentana2 extends JFrame {

    public EventosVentana2() {

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

/* Si no necesitamos usar todos los métodos de la interfaz, nos quedará
* un código largo sin sentido, pues quedarán muchos métodos vacíos.
*
* Para evitar esto se usan las llamadas "clases adaptadoras", que implementan
* varias intarfaces de forma que si creamos una clase que herede de ellas,
* solo deberemos implementar los métodos que usemos sobreescribiendo los mismos.
*
* En nuestro ejemplo, en lugar de implementar la interfaz "WindowsListener",
* heredamos de "WindowAdapter", e implementamos sobreescribiendo los métodos
* que necesitemos. */
class GeneraEventosVentana2 extends WindowAdapter {

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Bienvenid@ a la aplicación!");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Hasta pronto!");
    }
}