package com.example.interfacesGraficasLayouts;

import javax.swing.*;
import java.awt.*;

/*  Ejemplo con disposición "BorderLayout" usando dicha clase:
    - https://docs.oracle.com/javase/8/docs/api/java/awt/BorderLayout.html

  Además comenzamos a usar parámetros adcionales del método "add",
  para indicar la disposición del componente que se añade.
  - https://docs.oracle.com/javase/8/docs/api/java/awt/Container.html
* */
public class BorderLayoutEjemplo {

    public static void main(String[] args) {

        MarcoBorderLayout ventana = new MarcoBorderLayout();
    }
}

class MarcoBorderLayout extends JFrame {

    public MarcoBorderLayout(){

        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Panel con BorderLayout");

        add(new PanelBorderLayout());

        setVisible(true);
    }
}
class PanelBorderLayout extends JPanel {

    public PanelBorderLayout (){

        /*  Indicamos la disposición "BorderLayout" para el panel.
            Por defecto los componentes usarán todo el espacio disponible de la zona asignada.
            Opcionalmente podemos indicar separación horizontal y vertical de componentes. */
        setLayout(new BorderLayout(20,20));

        JButton botonR = new JButton("RED");
        JButton botonG = new JButton("GREEN");
        JButton botonB = new JButton("BLUE");
        JButton botonY = new JButton("YELLOW");
        JButton botonO = new JButton("ORANGE");

        /*  Usamos las constantes de clase para ubicar los componentes en cada región.
        *   Las 5 regiones básicas son NORTH, SOUTH, WEST, EAST y CENTER. */
        add(botonR,BorderLayout.NORTH);
        add(botonG,BorderLayout.SOUTH);
        add(botonB,BorderLayout.EAST);
        add(botonY,BorderLayout.WEST);
        add(botonO,BorderLayout.CENTER);

    }
}
