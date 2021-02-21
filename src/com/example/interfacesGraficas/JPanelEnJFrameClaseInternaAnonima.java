package com.example.interfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class JPanelEnJFrameClaseInternaAnonima {

    public static void main(String[] args) {

        CrearVentana ventana = new CrearVentana();

    }
}
class CrearVentana extends JFrame {

    public CrearVentana (){

        setSize(640,480);
        // Muchas gente pone este método en el main
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Creando un JPanel");

        // Nos ahorramos crear una instancia de la clase tipo lámina o panel
        //CrearJPanel panel = new CrearJPanel();

        // Añadimos la lámina al frame/ventana directamente mediante
        // una clase que hereda de JPanel, pero interna y anónima.
        // Hacer esto es mucho más complicado si el JPanel requiere un constructor.
        add(new JPanel(){
            @Override
            public void paintComponent(Graphics g) {

                super.paintComponent(g);

                // Nos podemos ahorrar crear la instancia de Color
                //Color color1 = new Color(0,0,255);
                g.setColor(new Color(0,0,255));

                // Nos podemos ahorrar crear la instancia de Font
                //Font fuente = new Font("Times New Roman",Font.BOLD,24);
                g.setFont(new Font("Times New Roman",Font.BOLD,24));

                g.drawString("JPanel o Lámina",200,200);

                // Con el método "setBackground" podemos establecer un color de fondo
                // a la lámina o panel, para que deje de ser transparente.
                this.setBackground(new Color(0,0,0));
            }
        });

        // Recordar que debe ir en último lugar
        setVisible(true);

    }
}
/* Nos ahorramos la clase que hereda de JPanel
class CrearJPanel extends JPanel {


    @Override
    public void paintComponent(Graphics g) {

        // Como hemos sobreescrito el método heredado, pierde el comportamiento especial
        // de autoinvocarse. Para ello, procedemos a invocar al método original consiguiendo
        // mantener este comportamiento especial de autoejecución.
        super.paintComponent(g);
        Color color1 = new Color(0,0,255);
        g.setColor(color1);
        Font fuente = new Font("Times New Roman",Font.BOLD,24);
        g.setFont(fuente);
        g.drawString("JPanel o Lámina",200,200);
    }
}
*/
