package com.example.componentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BarraHerramientas {

    public static void main(String[] args) {

        VentanaHerramientas ventana = new VentanaHerramientas();
    }
}

/*  BARRAS DE HERRAMIENTAS
*
*   JToolBar - Objeto de tipo barra de hrramientas. Método importante add(Action a), para añadir las acciones
*   a la barra de herramientas.
*   https://docs.oracle.com/javase/7/docs/api/javax/swing/JToolBar.html */

class VentanaHerramientas extends JFrame {

    public VentanaHerramientas () {

        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Barras de Herrmientas");

        add(new PanelHerramientas());

        setVisible(true);
    }
}

class PanelHerramientas extends JPanel {

    public PanelHerramientas () {

        EventoColorFondo colorRojo = new EventoColorFondo("Rojo",Color.RED,new ImageIcon("src/com/example/componentesSwing/bola_roja.gif"));
        EventoColorFondo colorVerde = new EventoColorFondo("Verde",Color.GREEN,new ImageIcon("src/com/example/componentesSwing/bola_verde.gif"));
        EventoColorFondo colorAzul = new EventoColorFondo("Azul",Color.BLUE,new ImageIcon("src/com/example/componentesSwing/bola_azul.gif"));

        JToolBar barra = new JToolBar("Colores");
        barra.add(colorRojo);
        barra.add(colorVerde);
        barra.add(colorAzul);

        add(barra,BorderLayout.NORTH);

    }

    /* Implementamos una clase que herede de "AbrstractAction", para pasar sus instancias
        como acción a la barra de herramientas. */
    private class EventoColorFondo extends AbstractAction {

        public EventoColorFondo (String nombre, Color color_fondo, Icon icono){

            putValue(Action.NAME,nombre);
            putValue("colorFondo",color_fondo);
            putValue(Action.SMALL_ICON, icono);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            Color c = (Color) getValue("colorFondo");
            setBackground(c);
            System.out.println("Nombre acción: "+getValue(Action.NAME));
        }
    }
}
