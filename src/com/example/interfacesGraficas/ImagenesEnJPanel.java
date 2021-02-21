package com.example.interfacesGraficas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagenesEnJPanel {

    public static void main(String[] args) {

        VentanaImagen ventana = new VentanaImagen();
    }
}

class VentanaImagen extends JFrame {

    public VentanaImagen(){

        setBounds(600,600,640,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jugando con imágenes");

        PanelImagen panel = new PanelImagen();
        add(panel);

        setVisible(true);


    }
}

class PanelImagen extends JPanel {

    private Image imagen;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*
            Creamos un objeto de tipo File del paquete java.io. Usaremos este objeto para
            cargar el archivo de imagen.
            La imagen debe estar en la raíz del proyecto si no se define ubicación de forma
            explícita, partiendo desde la raíz del proyecto o mediante una ruta absoluta "C:/...".
         */
        File archivo = new File("src/com/example/interfacesGraficas/emoji.png");

        // Java es un lenguaje estricto en muchos sentidos y en este caso, para usar el método
        // read(), nos obliga a meterla dentro de un try - catch.

        try {
            imagen = ImageIO.read(archivo);
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Error al cargar la imagen");
        }

        // Pintamos la imagen con el método correspondiente al tipo de objeto
        g.drawImage(imagen,0,0,null);

        // Vamos a hacer un bucle for anidado, para copiar por todo el planel
        // la misma imagen en modo mosaico

        // Usamos los métodos "getWidth" y "getHeight" para obtener los atributos
        // de anchura y altura de la imagen cargada.
        int anchoImagen = imagen.getWidth(this);
        int altoImagen = imagen.getHeight(this);

        for (int i=0;i<this.getWidth();i++){
            for (int j=0;j<this.getHeight();j++) {
                /* El método "copyArea" copia una sección del panel que definamos y la pega
                en la ubicación que determinemos.
                Este caso lo que queremos es que copie exactamente la sección que ocupa
                nuestra imagen. */
                g.copyArea(0,0,anchoImagen,altoImagen,anchoImagen*i,altoImagen*j);
            }
        }
    }

}


