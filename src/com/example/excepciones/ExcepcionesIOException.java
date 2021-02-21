package com.example.excepciones;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class ExcepcionesIOException {

    public static void main(String[] args) {
        VentanaImagen ventana = new VentanaImagen();
        ventana.setVisible(true);
    }
}

class VentanaImagen extends JFrame {

    public VentanaImagen(){

        setBounds(600,600,640,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jugando con imágenes");

        PanelImagen panel = new PanelImagen();
        add(panel);




    }
}

class PanelImagen extends JPanel {

    private Image imagen;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* Java es un lenguaje estricto en muchos sentidos y en este caso, para usar el método
        read(), nos obliga a meterla dentro de un try - catch ya que el propio lenguaje sabe
        que el método read puede lanzar un error de tipo IOException */

        try {
            imagen = ImageIO.read(new File("src/com/example/excepciones/_emoji.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la imagen");
        }

        /* Al haber controlado la excepción de tipo IOException de que la imagen no se pueda
         * cargar, el programa sigue, pero luego, al intentar usarla, se generaría una
         * excepción de tipo Runtime. No sería un error de sintaxis porque la variable existe,
         * pero se generaría error en tiempo de ejecución ya que durante la ejecución no
         * podría inicializarse dicha variable. */


        /* Para evitar que el programa caiga, comprobamos antes de usar el objeto imagen,
        *  si este es null porque no se pudo cargar y tal caso controlar la posibilidad. */

        if (imagen == null) {

            g.drawString("No se ha podido cargaar la imagen", 10, 10);
        } else {

            // Pintamos la imagen con el método correspondiente al tipo de objeto
            g.drawImage(imagen, 0, 0, null);

            // Vamos a hacer un bucle for anidado, para copiar por todo el planel
            // la misma imagen en modo mosaico

            // Usamos los métodos "getWidth" y "getHeight" para obtener los atributos
            // de anchura y altura de la imagen cargada.
            int anchoImagen = imagen.getWidth(this);
            int altoImagen = imagen.getHeight(this);

            for (int i = 0; i < this.getWidth(); i++) {
                for (int j = 0; j < this.getHeight(); j++) {
                /* El método "copyArea" copia una sección del panel que definamos y la pega
                en la ubicación que determinemos.
                Este caso lo que queremos es que copie exactamente la sección que ocupa
                nuestra imagen. */
                    g.copyArea(0, 0, anchoImagen, altoImagen, anchoImagen * i, altoImagen * j);
                }
            }
        }
    }

}
