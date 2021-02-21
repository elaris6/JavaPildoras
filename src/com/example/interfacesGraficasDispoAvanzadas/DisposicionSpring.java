package com.example.interfacesGraficasDispoAvanzadas;

import javax.swing.*;

public class DisposicionSpring {

    public static void main(String[] args) {

        VentanaSpring ventana = new VentanaSpring();
        ventana.setVisible(true);

    }
}
/*  DISPOSICION SPRING (muelle)
*
*   Clase Spring, método importante static constant(int a, int b, int c) para establecer el
*   comportamiento del muelle.
*   https://docs.oracle.com/javase/7/docs/api/javax/swing/Spring.html
*
*   SptingLayout, métodos putConstraint(String e1, Component c1, int pad, String e2, Component c2)
*   para establecer la distancia entre los componentes unidos por el muelle.
*   https://docs.oracle.com/javase/7/docs/api/javax/swing/SpringLayout.html
*
*  */

class VentanaSpring extends JFrame {

    public VentanaSpring(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480,320);
        setLocationRelativeTo(null);
        setTitle("Disposicion SPRING");

        add(new PanelSpring());

    }
}

class PanelSpring extends JPanel {

    public PanelSpring () {

        JButton boton1 = new JButton("Botón 1");
        JButton boton2 = new JButton("Botón 2");
        JButton boton3 = new JButton("Botón 3");

        /* Creamos la disposición Spring (muelle) para el panel */
        SpringLayout dispoMuelle = new SpringLayout();
        setLayout(dispoMuelle);


        add(boton1);
        add(boton2);
        add(boton3);

        /* Creamos un muelle con los atributos de elasticidad que deseamos */
        Spring muelle1 = Spring.constant(0,10,200);

        /* Fijamos el muelle entre los elementos deseados. Los argumentos del método son:
        * - Punto de anclaje del destino
        * - Componente destino
        * - Muelle a fijar
        * - Punto de anclaje del origen
        * - Componente origen
        * En este ejemplo, fijamos un muelle entre el lado izquierdo (WEST) del panel (this) y el
        * lado izquierdo (WEST) del componente boton1. */
        dispoMuelle.putConstraint(SpringLayout.WEST,boton1,muelle1,SpringLayout.WEST,this);

        /* Podemos usar el mismo muelle para unir más elementos, que tendrá las mismas propiedades
        * para todas las uniones. En caso de requerir distintas propiedades, deberíamos crear nuevos
        * objetos de tipo muelle.
        *
        * Vamos uniendo los botones entre si y con el panel usando el mismo muelle. */
        dispoMuelle.putConstraint(SpringLayout.WEST,boton2,muelle1,SpringLayout.EAST,boton1);

        dispoMuelle.putConstraint(SpringLayout.WEST,boton3,muelle1,SpringLayout.EAST,boton2);

        dispoMuelle.putConstraint(SpringLayout.EAST,this,muelle1,SpringLayout.EAST,boton3);

    }
}
