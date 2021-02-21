package com.example.interfacesGraficasEventos;

import javax.swing.*;
import java.awt.event.*;

public class EventosRaton {

    public static void main(String[] args) {

        VentanaRaton ventana = new VentanaRaton();
        ventana.addMouseListener(new EventoRaton());
        ventana.addMouseMotionListener(new EventoRaton());
        ventana.addMouseWheelListener(new EventoRaton());
    }
}

class VentanaRaton extends JFrame {

    public VentanaRaton (){

        setSize(640,480);
        setLocationRelativeTo(null);//para que salga en el centro
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Eventos de Ratón");


        setVisible(true);
    }
}

/* INTERFACES Y CLASES RELEVANTES
- MouseListener - El listener para eventos de ratón estándar
- MouseMotionListener - El listener para eventos de ratón de arrastrar
- MouseWheelLister - El listener para la rueda del ratón
- MouseAdapter - El adaptador de interfaz de eventos de ratón, para no tener que implementar
métodos que no vamos a usar.
- MouseEvent - Evento de ratón
https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseEvent.html */

class EventoRaton implements MouseListener, MouseMotionListener, MouseWheelListener {

    // Evento de pulsación de cualquier botón
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Evento mousePressed. Botón: "+e.getButton());

    }

    // Evento de liberación de cualquier botón
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Evento mouseReleased");
    }

    // Evento completo tras Pressed y Released de cualquier botón
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Se ha completado el click con el ratón");
    }

    // Evento de entrada del puntero en una zona concreta
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Evento mouseEntered");
    }

    // Evento de salida del puntero de una zona concreta
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Evento mouseExited");
    }
    // Evento que detecta el movimiento de la rueda del ratón
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(e.getWheelRotation()==-1){
            System.out.println("Rueda del ratón girada haciendo scroll up");
        }
        else if (e.getWheelRotation()==1){
            System.out.println("Rueda del ratón girada haciendo scroll down");
        }

    }
    //Evento para detectar el arrastre del ratón
    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Se está arrastrando con el botón pulsado");
    }
    // Evento para detectar el movimiento del ratón
    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Se está moviendo el cursor");
    }
}
