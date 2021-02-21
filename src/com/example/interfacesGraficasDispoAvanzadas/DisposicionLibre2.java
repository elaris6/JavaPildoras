package com.example.interfacesGraficasDispoAvanzadas;

import javax.swing.*;
import java.awt.*;

public class DisposicionLibre2 {

    public static void main(String[] args) {

        VentanaDispoLibre2 ventana = new VentanaDispoLibre2();
        ventana.setVisible(true);

    }
}
/*  DISPOSICION LIBRE
 *
 *   Los componentes se ubican libremente en base a coordenadas en píxeles.
 *   Para ello hay que anular la disposición por defecto FlowLayout, asignando
 *   como layout el valor "null" al objeto en el que queramos asignar esta disposción.
 *
 *   La verdadera utilidad es construir una clase para que ubique los componentes.
 *   Para ello necesitaremos la interfaz "LayoutManager", cuyo método más importante
 *   es layoutContainer(Container padre)
 *   https://docs.oracle.com/javase/7/docs/api/java/awt/LayoutManager.html
 *
 *   Necesitareos también la clase "Container", con sus métodos
 *   getComponentCount() y getComponent(int i)
 *   https://docs.oracle.com/javase/7/docs/api/java/awt/Container.html
 *
 * */

class VentanaDispoLibre2 extends JFrame {

    public VentanaDispoLibre2 () {

        setSize( 480,320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Disposición Libre");

        add(new PanelDispoLibre2());
    }
}

class PanelDispoLibre2 extends JPanel {

    public PanelDispoLibre2 () {

        // Asignamos el layout como la clase que implementa la interfaz LayoutManager
        setLayout(new EnColumnas(2));

        JLabel userLabel = new JLabel("User");
        JLabel passLabel = new JLabel("Password");
        JTextField userText = new JTextField();
        JTextField passText = new JTextField();
        JButton boton1 = new JButton("Login");

        add(userLabel);
        add(userText);
        add(passLabel);
        add(passText);
        add(boton1);
    }
}

/*  Creamos la clase implementadora de LayoutManager, que será la encargada
*   de ir disponiendo los componentes según especifiquemos en el método
*   layoutContainer(Container parent) */
class EnColumnas implements LayoutManager {

    // Creamos unas coordenadas iniciales
    private int x;
    private int y = 20;
    private int grupo;

    // Creamos un constructor para indicar que insertamos los componentes
    // en grupos de n elementos indicados por el argumento "grupo".
    public EnColumnas(int grupo) {
        this.grupo = grupo;

    }

    @Override
    public void addLayoutComponent(String name, Component comp) {    }

    @Override
    public void removeLayoutComponent(Component comp) {    }

    @Override
    public Dimension preferredLayoutSize(Container parent) { return null; }

    @Override
    public Dimension minimumLayoutSize(Container parent) { return null; }

    @Override
    public void layoutContainer(Container parent) {

        int anchoParent = parent.getWidth();
        x = anchoParent/2;

        // Obtenemos el número de componentes del contenedor
        int n = parent.getComponentCount();
        int contador = 1;
        // Los recorremos con un blucle for y los vamos ubicando jugando
        // con las coordenadas.
        for (int i=0;i<n;i++) {
            Component c = parent.getComponent(i);
            c.setBounds(x-80,y,80,20);

            // Aquí usamos el argumento "grupo" para hacer un "salto de línea"
            // al alcanzar cada grupo. En este caso, cada 2 elementos.
            if (contador%grupo == 0) {
                y+= 50;
                x = anchoParent/2;
            }
            else x+=80;
            contador+=1;

        }
    }
}