package com.example.interfacesGraficasDispoAvanzadas;

import javax.swing.*;

public class DisposicionBox {

    public static void main(String[] args) {

        VentanaBox ventana = new VentanaBox();
        ventana.setVisible(true);

    }
}
/*  DISPOSICION BOX
*
*   Partimos de la clase Box, con los siguientes métodos principales: createHorizontalBox(),
*   createVerticalBox(), createHorizontalStrut(int width), createVerticalStrut(int height), createGlue().
*
*   Se pueden anidar cajas con diferentes disposiciones para crear la interfaz.
*
*   https://docs.oracle.com/javase/8/docs/api/javax/swing/Box.html  */

class VentanaBox extends JFrame {

    public VentanaBox (){

        setSize(320,240);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Disposición tipo BOX");

        // ------- Primera Box ---------
        JLabel labUsuario = new JLabel("Usuario");
        JTextField camUsuario = new JTextField(10);
        // Método de JTextField para definir un tamaño máximo
        camUsuario.setMaximumSize(camUsuario.getPreferredSize());

        /* Creamos la caja con disposición horizontal y disponemos los elementos.
        * La diposición se hace de forma literal, en el orden en que hacemos el .add()
        * de los elementos, incluidas las separaciones. */
        Box cajaUsuario = Box.createHorizontalBox();
        cajaUsuario.add(labUsuario);
        cajaUsuario.add(Box.createHorizontalStrut(10));
        cajaUsuario.add(camUsuario);

        // ------- Segunda Box ---------
        JLabel labPassword = new JLabel("Contraseña");
        JTextField camPassword = new JTextField(10);
        camPassword.setMaximumSize(camPassword.getPreferredSize());

        Box cajaPassword = Box.createHorizontalBox();
        cajaPassword.add(labPassword);
        cajaPassword.add(Box.createHorizontalStrut(10));
        cajaPassword.add(camPassword);

        // ------- Tercera Box ---------
        JButton boton1 = new JButton("OK");
        JButton boton2 = new JButton("Cancelar");

        Box cajaBotones = Box.createHorizontalBox();
        cajaBotones.add(boton1);
        /* createGlue() consigue que al redmiensionar los componentes se separen, pero quedando siempre
        * en una misma alineación indicada por su caja contenedora. */
        cajaBotones.add(Box.createGlue());
        cajaBotones.add(boton2);

        // ------- Caja vertical principal --------
        /* Creamos una caja principal contenedora con disposición vertical en este caso, que contendrá
        * las otras cajas con disposición horizontal que hemos creado. */
        Box cajaVertical = Box.createVerticalBox();
        cajaVertical.add(cajaUsuario);
        cajaVertical.add(cajaPassword);
        cajaVertical.add(cajaBotones);

        // Agregamos la caja principal vertical  a la ventana
        add(cajaVertical);

    }
}
