package com.example.interfacesGraficasLayouts;

import javax.swing.*;
import java.awt.*;

public class GridLayoutEjemplo {


    /* Ejemplo de uso de "GridLayout". Layout que dispone en formato
    * filaes y columnas los componentes para dotar de una mayor flexibilidad.
    *
    * - https://docs.oracle.com/javase/8/docs/api/java/awt/GridLayout.html */
    public static void main(String[] args) {

        VentanaGridLayout ventana = new VentanaGridLayout();

    }
}

/* En el ejmplo vamos a construir una ventana con dos paneles. El marco o
* ventana tendrá una disposición BorderLayout, y en ella ubicaremos en
* NORTH y CENTER a su vez dos paneles.
* El panel superior lo crearemos como un BorderLayout y el central, lo
* haremos como un GridLayout. */

class VentanaGridLayout extends JFrame {

    public VentanaGridLayout (){

        setBounds(500,500,240,480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("GridLayout");

        add(new PanelVisor(),BorderLayout.NORTH);
        add(new PanelGridLayout(),BorderLayout.CENTER);


        setVisible(true);
    }
}
class PanelVisor extends JPanel{

    public PanelVisor(){

        setLayout(new BorderLayout());
        JTextField visor = new JTextField("Resultado");
        visor.setSize(230,40);
        add(visor,BorderLayout.EAST);

    }
}
class PanelGridLayout extends JPanel{

    public PanelGridLayout(){

        /* Usamos el constructor en el que se especifican filas y columnas.
        * Hay otro constructuro permite indicar la separación horizontal y
        * vertical.
        * Los elementos se van disponiendo automáticamente de izquierda a
        * derecha y de arriba a abajo. */
        setLayout(new GridLayout(4,4));

        add(new JButton("7"));
        add(new JButton("8"));
        add(new JButton("9"));
        add(new JButton("X"));

        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        add(new JButton("-"));

        add(new JButton("1"));
        add(new JButton("2"));
        add(new JButton("3"));
        add(new JButton("+"));

        add(new JButton("C"));
        add(new JButton("0"));
        add(new JButton(","));
        add(new JButton("="));

    }
}



