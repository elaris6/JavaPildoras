package com.example.interfacesGraficasLayouts;


import javax.swing.*;
import java.awt.*;

/* La disposición por defecto de las interfaces gráficas de Java es "FlowLayout",
* aunque no se especifique. Pero si se requiere hacer uso de alineaciones u
* otros elementos de esta disposición, deberemos hacer uso de la clase "FlowLayout".
*
* Los layout se establecen a nivel de panel, y para ello necesitamos instanciar la
* clase del layout que deseemos (en este caso flowlayout) y establecerla en el panel
* mediante el método "setLayout" de la clase "Container" que es heredada por "JPanel".
*
* Clase "FlowLayout":
* - https://docs.oracle.com/javase/8/docs/api/java/awt/FlowLayout.html
* */
public class FlowLayoutEjemplo {

    public static void main(String[] args) {

        MaroConLayout miMarco=new MaroConLayout();

        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        miMarco.setVisible(true);
    }
}

class MaroConLayout extends JFrame {

    public MaroConLayout(){

        setTitle("Disposiciones");

        setBounds(600,350,600,300);

        PanelconLayout lamina=new PanelconLayout();

        /* Aquí creamos un layout y lo asignamos al panel/lámina.
        * Usamos un constructor que admite dos atributos que son separación horizontal
        * y separación vertical entre componentes. */
        FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT,50,75);
        lamina.setLayout(disposicion);

        add(lamina);
    }
}

class PanelconLayout extends JPanel{

    public PanelconLayout(){

        /* También podemos aplicar el layout al panel en el constructor:
        setLayout(new FlowLayout(FlowLayout.LEFT);
        * */

        add(new JButton("RED"));

        add(new JButton("GREEN"));

        add(new JButton("BLUE"));
    }
}
