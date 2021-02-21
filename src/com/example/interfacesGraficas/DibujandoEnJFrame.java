package com.example.interfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class DibujandoEnJFrame {

    public static void main(String[] args) {

        MarcoDibujos ventana = new MarcoDibujos();

    }
}

class MarcoDibujos extends JFrame {

    public MarcoDibujos () {

        setBounds(100,100,640,480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Lamina lamina = new Lamina();
        add(lamina);


        setVisible(true);
    }
}

class Lamina extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Dibujando figuras geométricas y asignando colores
        // https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
        g.setColor(new Color(0,255,0));
        g.drawRect(50,50,250,150);

        g.setColor(new Color(0,0,255));
        g.drawLine(50,50,300,200);

        g.setColor(new Color(255,130,50));
        g.fillRect(350,250,250,150);

        g.setColor(new Color(255,0,0));
        g.drawLine(600,250,350,400);

    }
}
