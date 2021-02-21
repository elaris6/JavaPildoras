package com.example.interfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class FuentesEnLocal {

    public static void main(String[] args) {

        VentanaFuente ventana = new VentanaFuente();
    }
}
class VentanaFuente extends JFrame {

    public VentanaFuente () {

        setSize(640,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Jugando con fuentes");

        PanelFuente panel = new PanelFuente();
        add(panel);

        setVisible(true);

    }
}
class PanelFuente extends JPanel {

    String[] fuentesLocales;
    String fuenteElegida;
    String fuenteOK = "";

    // Usamos el constructor del panel para introducir la lógica del mismo.
    public PanelFuente (){

        // Usamos la siguiente instrucción para cargar en una array todas las fuentes
        // instaladas en el sistema
        this.fuentesLocales = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        // Pedimos al usuario una fuente y comprobamos si está entre las fuentes instaladas
        this.fuenteElegida = JOptionPane.showInputDialog("En que fuente quieres escribir?");
        this.fuenteElegida = this.fuenteElegida.toLowerCase();

        for (String fuente : fuentesLocales) {
            if (fuenteElegida.equals(fuente.toLowerCase())) {
                fuenteOK=fuente;
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        if (this.fuenteOK != "") {
            g2.setColor(Color.GREEN);
            g2.setFont(new Font(this.fuenteOK,Font.BOLD,18));
            g2.drawString("Escribiendo con la fuente '"+this.fuenteOK+"' que es muy bonita",100,100);
        }
        else {
            g2.setColor(Color.RED);
            g2.setFont(new Font("Arial",Font.BOLD,18));
            g2.drawString("La fuente indicada no está instalada en el sistema",100,100);
            g2.drawString("Vuelve a intentarlo!",100,130);
        }
    }
}



