package com.example.interfacesGraficasEventos;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventosTeclado {

    public static void main(String[] args) {

        VentanaEventosTeclado ventana = new VentanaEventosTeclado();

        /* Añadimos el "KeyListener" como en anteriores ejemplos, para que el objeto
            quede a la escucha. */
        ventana.addKeyListener(new EventoTeclado());
    }
}

class VentanaEventosTeclado extends JFrame {

    public VentanaEventosTeclado(){

        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Eventos de teclado");

        setVisible(true);
    }
}

/* Necesitamos implementar la interfaz "KeyListener" y sus métodos asociados.
* Podríamos implementar por herencia la clase "KeyAdapter", para no implementar
* todos los métodos si no nos es necesario.
*
* Importante conocer los eventos asociados asociados a la clase "KeyEvent".
* https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html */
class EventoTeclado implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Pulsación completa");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*  Usamos algunos métodos que devuelven el caracter pulsado (si es un caracter),
            otro método que te devuevle el código y otro que devuelve la tecla en base al
            código de la misma. */
        System.out.println("Presionada tecla: "+e.getKeyText(e.getKeyCode())+" con código: "+e.getKeyCode()+" cuyo caracter es: "+e.getKeyChar());

        /* Para determinar la tecla pulsada podemos usar su código o las constantes definidas
           para cada una de las teclas, que se pueden consultar en la API dentro de "KeyEvent".

           En el ejemplo detectamos la pulsación de la tecla ESCAPE y salimos del programa. */
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Tecla liberada"+"\n");
    }
}

