package com.example.interfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class IconoJFrame {

    public static void main(String[] args) {

        // Instanciamos un Frame
        CreaJFrameIcono ventana = new CreaJFrameIcono();
    }
}

// El objetivo es ver como partiendo de la clase Toolkit, obtenemos una imagen
// y la usamos para algo.

class CreaJFrameIcono extends JFrame {

    public CreaJFrameIcono (){

        setSize(640,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Para poner en el medio
        setLocationRelativeTo(null);


        setTitle("Cambio icono JFrame");

        // Obtenemos las herramientas del sistema en el que corre el programa
        Toolkit miSistema = Toolkit.getDefaultToolkit();

        /*  Creamos un objeto de tipo "Image"
            Las extensiones admitidas para los iconos son: jgp, gif y png
            La imagen debe estar en la raíz del proyecto si no se define
            ubicación de forma explícita, partiendo desde la raíz del proyecto
         */
        Image miIcono = miSistema.getImage("src/com/example/interfacesGraficas/emoji.png");

        // Asignar el objeto "Image" obtenido, como icono del frame
        setIconImage(miIcono);

        // Recordar que debe ir en último lugar
        setVisible(true);
    }
}