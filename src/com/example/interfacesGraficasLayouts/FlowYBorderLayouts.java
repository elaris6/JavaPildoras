package com.example.interfacesGraficasLayouts;

import javax.swing.*;
import java.awt.*;

/*  En este ejemplo crearemos y ubicaremos DOS PANELES en la misma ventana.
*   Cada panel tendrá un tipo de Layout distinto Flow y Border y el propio
*   marco o ventana tendrá una disposición de tipo BorderLayout en la que
*   ubicaremos los paneles en si. */

public class FlowYBorderLayouts {

    public static void main(String[] args) {

        FlowBorderLayout ventana = new FlowBorderLayout();
    }
}

class FlowBorderLayout extends JFrame {

    public FlowBorderLayout(){

        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Panel con BorderLayout");

        /*  Creamos dos panales y aunque no definamos la ventana como BorderLayout,
        *   podemos usar la disposición de norte, sur, este, oeste, centro en la
        *   propia ventana. */
        add(new PanelLayout1(),BorderLayout.NORTH);
        add(new PanelLayout2(),BorderLayout.SOUTH);

        setVisible(true);
    }
}
/*  Creamos una clase JPanel para un panel con disposición FlowLayout.
*   Ubicamos dos botones en el panel con la disposicióin de este tipo. */
class PanelLayout1 extends JPanel {

    public PanelLayout1 (){

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(new JButton("Boton1"));
        add(new JButton("Boton2"));

    }
}
/*  Creamos una clase JPanel para un panel con disposición BorderLayout.
*   Ubicamos dos botones en el panel con la disposicióin de este tipo. */
class PanelLayout2 extends JPanel {

    public PanelLayout2 (){

        setLayout(new BorderLayout(20,20));

        add(new JButton("Boton3"),BorderLayout.WEST);
        add(new JButton("Boton4"),BorderLayout.CENTER);
        add(new JButton("Boton5"),BorderLayout.EAST);

    }
}
