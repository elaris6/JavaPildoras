package com.example.interfacesGraficasDispoAvanzadas;

import javax.swing.*;

public class DisposicionLibre {

    public static void main(String[] args) {

        VentanaDispoLibre ventana = new VentanaDispoLibre();
        ventana.setVisible(true);

    }
}
/*  DISPOSICION LIBRE
*
*   Los componentes se ubican libremente en base a coordenadas en píxeles.
*   Para ello hay que anular la disposición por defecto FlowLayout, asignando
*   como layout el valor "null" al objeto en el que queramos asignar esta disposción.
*
* */

class VentanaDispoLibre extends JFrame {

    public VentanaDispoLibre () {

        setSize( 640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Disposición Libre");

        add(new PanelDispoLibre());
    }
}

class PanelDispoLibre extends JPanel {

    public PanelDispoLibre () {

        // Asignamos el layout como "null" para que se anule el layout
        // por defecto FlowLayout.
        setLayout(null);

        JLabel userLabel = new JLabel("User");
        JLabel passLabel = new JLabel("Password");
        JTextField userText = new JTextField();
        JTextField passText = new JTextField();
        JButton boton1 = new JButton("Login");

        userLabel.setBounds(100,150,80,20);
        userText.setBounds(200,150,80,20);
        passLabel.setBounds(100,200,80,20);
        passText.setBounds(200,200,80,20);
        boton1.setBounds(200,300,80,30);

        add(userLabel);
        add(userText);
        add(passLabel);
        add(passText);



        add(boton1);
    }
}
