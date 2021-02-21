package com.example.interfacesGraficas;

// Aunque se pueden ubicar elementos directamente en el JFrame, lo normal y recomendable
// es hacerlo mediante la creación de "JPanel o Láminas", que se comportan como capas que
// se pueden superponer.

import javax.swing.*;
import java.awt.*;


public class JPanelEnJFrame {

    public static void main(String[] args) {

        CreaVentana ventana = new CreaVentana();

    }
}
class CreaVentana extends JFrame {

    public CreaVentana (){

        setSize(640,480);
        // Muchas gente pone este método en el main
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Creando un JPanel");

        // Creamos una instancia de la clase tipo lámina o panel
        CrearJPanel panel = new CrearJPanel();
        // Añadimos la lámina al frame/ventana
        add(panel);

        // Recordar que debe ir en último lugar
        setVisible(true);

    }
}
// El tamaño por defecto del JPanel se adaptará al tamaño máximo del frame en el que se cree
class CrearJPanel extends JPanel {

    // En este ejemplo sencillo en el que solo vamos a escribir texto,
    // no es necesario crear un constructor.

    // Este método es especial, pues cuando se construye un objeto de tipo JPanel,
    // este método se autoinvoca al levantarse.

    @Override
    public void paintComponent(Graphics g) {

        // Como hemos sobreescrito el método heredado, pierde el comportamiento especial
        // de autoinvocarse. Para ello, procedemos a invocar al método original consiguiendo
        // mantener este comportamiento especial de autoejecución.
        super.paintComponent(g);

        // Estableder COLORES: https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
        // Primero debemos crear un objeto de tipo Color y luego aplicarlo
        // sobre el objeto de tipo Graphics
        Color color1 = new Color(0,0,255);
        g.setColor(color1);

        // Establecer FUENTES: https://docs.oracle.com/javase/7/docs/api/java/awt/Font.html
        // Primero debemos crear un objeto de tipo Font y luego aplicarlo
        // sobre el objeto de tipo Graphics
        Font fuente = new Font("Times New Roman",Font.BOLD,24);
        g.setFont(fuente);

        // Usamos el método "drawString" para pintar el contenido
        g.drawString("JPanel o Lámina",200,200);
    }
}
