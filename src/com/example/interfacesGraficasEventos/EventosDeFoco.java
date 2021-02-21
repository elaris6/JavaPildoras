package com.example.interfacesGraficasEventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* INTERFACES Y CLASES DE INTERES
- FocusListener - Eventos de foco en componentes
- FocusAdapter - Clase adaptadora de evetnos de foco en componentes
- WindowFocusListener - Eventos de foco en ventana
- WindowAdapter - Clase adaptadora de evetnos de foco en ventana
- FocusEvent - Evento de foco:
https://docs.oracle.com/javase/8/docs/api/java/awt/event/FocusEvent.html
 */

public class EventosDeFoco {

    public static void main(String[] args) {

        VentanaEventosFoco ventana1 = new VentanaEventosFoco("Ventana1",100,100);
        PanelEventosFoco panel1 = new PanelEventosFoco("Panel Ventana 1");
        ventana1.add(panel1);

        VentanaEventosFoco ventana2 = new VentanaEventosFoco("Ventana2",100,600);
        PanelEventosFoco panel2 = new PanelEventosFoco("Panel Ventana 2");
        ventana2.add(panel2);

    }
}

class VentanaEventosFoco extends JFrame {

    // Incuímos como parámetros del constructor, las coordenadas de
    // creación de la ventana.
    public VentanaEventosFoco(String nom_ventana, int loc_x, int loc_y) {

        setBounds(loc_x,loc_y,640,480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Eventos de Foco en "+nom_ventana);
        setName(nom_ventana);
        addWindowFocusListener(new EventosFocoVentana());


        setVisible(true);

    }
}
class PanelEventosFoco extends JPanel implements ActionListener {

    // Clase de cuadro de texto
    // https://docs.oracle.com/javase/8/docs/api/javax/swing/JTextField.html
    private JTextField campoTexto1, campoTexto2;
    private JButton boton = new JButton("Pulsame");;

    public PanelEventosFoco(String nom_panel){

        setName(nom_panel);
        boton.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* "setBounds" también se puede usar para ubicar componentes, así como
            la propia ventana. */
        campoTexto1 = new JTextField();
        campoTexto1.setBounds(50,50,500,100);
        campoTexto1.addFocusListener(new EventosFoco());
        campoTexto1.setName("Campo de texto 1");

        campoTexto2 = new JTextField();
        campoTexto2.setBounds(50,200,500,100);
        campoTexto2.addFocusListener(new EventosFoco());
        campoTexto2.setName("Campo de texto 2");

        boton.setBounds(260,320,120,40);
        boton.addFocusListener(new EventosFoco());
        boton.setName("Botón");

        add(campoTexto1);
        add(campoTexto2);
        add(boton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object botonPulsado = e.getSource();

        if (botonPulsado == boton) {
            System.out.println(campoTexto1.getText()+"\n"+campoTexto2.getText());
        }

    }
}

class EventosFoco implements FocusListener {

    @Override
    public void focusGained(FocusEvent e) {
        System.out.println("Foco ganado en componente: "+e.getComponent().getName()+" de "+e.getComponent().getParent().getName());
    }

    @Override
    public void focusLost(FocusEvent e) {
        System.out.println("Foco perdido de componente: "+e.getComponent().getName()+" de "+e.getComponent().getParent().getName());
    }
}

class EventosFocoVentana implements WindowFocusListener {

    @Override
    public void windowGainedFocus(WindowEvent e) {
        System.out.println("Foco ganado en ventana: "+e.getComponent().getName());
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        System.out.println("Foco perdido de vetana: "+e.getComponent().getName());
    }
}