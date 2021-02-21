package com.example.interfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class DibujandoJava2DENJFrame {

    public static void main(String[] args) {

        UnMarco ventana = new UnMarco();

    }
}

class UnMarco extends JFrame {

    public UnMarco () {

        setBounds(100,100,640,480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Panel lamina = new Panel(Color.GREEN, new Dimension(320,240),0,0);
        Panel lamina = new Panel();
        add(lamina);

        //Panel lamina2 = new Panel(Color.RED, new Dimension(320,240),0,241);
        //add(lamina2);

        setVisible(true);
    }
}

class Panel extends JPanel {

    /*public Panel (Color color, Dimension d, int x, int y){

        setBackground(color);
        super.setSize(d);
        super.setLocation(x,y);
    }*/

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Dibujando figuras geométricas de "Java2D"
        // https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html

        // Hacemos un casting de Graphics a Graphics2D
        Graphics2D g2D = (Graphics2D)g;

        // Creamos un objeto de la clase Grpahics2D, por ejemplo Rectangle2D.Double,
        // que hereda de la interfaz Rectable2D
        Rectangle2D miRectangulo = new Rectangle2D.Double(50,50,200,150);

        // Esta biblioteca permite hacer cosas más avanzadas como modificar el trazo del dibujo.
        // Para ello primero deberemos crear un objeto de tipo Stroke ("BasicStroke"), para luego
        // aplicarlo sobre el elemento gráfico de tipo Graphics2D.
        // Por ejemplo, en este caso creamos un trazo sencillo en el que solamente incrementamos
        // el grosor.
        // https://docs.oracle.com/javase/7/docs/api/java/awt/BasicStroke.html
        BasicStroke miTrazo = new BasicStroke(4);
        g2D.setStroke(miTrazo);

        // Finalmente dibujamos el objeto de tipo "Shape", que pide el método "draw",
        // en este caso un Rectable2D
        g2D.draw(miRectangulo);

        // Creamos otro rectángulo, esta vez con un trazo discontínuo
        Rectangle2D miRectangulo2 = new Rectangle2D.Double(300,50,200,150);

        // Creamos un trazo de tipo discontínuo y lo aplicamos al objeto Graphics2D
        float dash[] = {10.0f};
        BasicStroke mitrazo2 = new BasicStroke(6,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10,dash,0);
        g2D.setStroke(mitrazo2);

        // Usamos el método "setPaint" para asignar un color a la forma. setPaint requiere como parámetro
        // una interfaz llamada "Paint", que está heredada en la clase "Color", que tiene varios constructores.
        g2D.setPaint(new Color(0,0,255,100));

        // Finalmente dibujamos el objeto
        g2D.draw(miRectangulo2);

    }
}