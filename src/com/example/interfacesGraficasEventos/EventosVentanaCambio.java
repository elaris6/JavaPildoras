package com.example.interfacesGraficasEventos;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class EventosVentanaCambio {

    public static void main(String[] args) {

        VentanaCambioEvento ventana = new VentanaCambioEvento();
        ventana.addWindowStateListener(new CambioEventosVentana());

    }
}

class VentanaCambioEvento extends JFrame {

    public VentanaCambioEvento(){

        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Cambios estado ventana");



        setVisible(true);

    }
}

class CambioEventosVentana implements WindowStateListener {

    String nuevo_estado;

    @Override
    public void windowStateChanged(WindowEvent e) {

        if (e.getNewState() == Frame.MAXIMIZED_BOTH) {
            System.out.println("La ventana ha cambiado de estado: MAXIMIZADO");
        }
        else if (e.getNewState() == Frame.ICONIFIED) {
            System.out.println("La ventana ha cambiado de estado: MINIMIZADO");
        }
        else if (e.getNewState() == Frame.NORMAL) {
            System.out.println("La ventana ha cambiado de estado: NORMAL");
        }
        else {
            System.out.println("La ventana ha cambiado de estado: NO CONTROLADO");
        }
        /*
        switch (e.getNewState()) {

            case Frame.MAXIMIZED_BOTH:
                System.out.println("La ventana ha cambiado de estado: MAXIMIZADO");

            case Frame.ICONIFIED:
                System.out.println("La ventana ha cambiado de estado: MINIMIZADO");

            case Frame.NORMAL:
                System.out.println("La ventana ha cambiado de estado: NORMAL");

            default:
                System.out.println("La ventana ha cambiado de estado: NO CONTROLADO");

        }*/
    }
}
