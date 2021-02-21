package com.example.componentesSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menus {

    public static void main(String[] args) {

        VentanaMenu ventana = new VentanaMenu();
    }
}
/* MENUS EN JAVA SWING

* Clases necesarias: JMenuBar, JMenu, JMenuItem
* https://docs.oracle.com/javase/7/docs/api/javax/swing/JMenuBar.html
* https://docs.oracle.com/javase/7/docs/api/javax/swing/JMenu.html
* https://docs.oracle.com/javase/7/docs/api/javax/swing/JMenuItem.html

  MENUS EMERGENTES

  Clase: JPopUpMenu
  Métodos útiles: add(Action a)
  Para agregar elementos usaremos la clase JMenuItem.
    https://docs.oracle.com/javase/7/docs/api/javax/swing/JPopupMenu.html
    Para agregar el menú emergente por ejemplo a un panel, usaremos el método
    de JPanel .setComponentPopipMenu()
    https://docs.oracle.com/javase/7/docs/api/javax/swing/JComponent.html#setComponentPopupMenu(javax.swing.JPopupMenu)

 */

class VentanaMenu extends JFrame {

    public VentanaMenu (){

        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Jugando con Menús");

        PanelMenu panel = new PanelMenu();
        add(panel);

        setVisible(true);

    }
}

class PanelMenu extends JPanel {

    public PanelMenu(){

        /* Creamos la barra principal del menú.  */
        JMenuBar barraMenu = new JMenuBar();

        /* Creamos las opciones de menú, para la barra principal del menú. */

        JMenu opcionArc = new JMenu("Archivo");
        JMenu opcionEdi = new JMenu("Edición");
        JMenu opcionHer = new JMenu("Herramientas");

        /* Asociamos las opciones a la barra principal de menú. */

        barraMenu.add(opcionArc);
        barraMenu.add(opcionEdi);
        barraMenu.add(opcionHer);

        /* Creamos items de las opciones principales del menú y los agregamos a su opción de menú. */

        // Archivo
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem guardarComo = new JMenuItem("Guardar como");
        JMenuItem salir = new JMenuItem("Salir");

        opcionArc.add(abrir);
        opcionArc.add(guardar);
        opcionArc.add(guardarComo);
        opcionArc.addSeparator(); // Agregar un separador de menú
        opcionArc.add(salir);

        // Edición
        JMenuItem copiar = new JMenuItem("Copiar");
        JMenuItem cortar = new JMenuItem("Cortar");
        JMenuItem pegar = new JMenuItem("Pegar");
        JMenuItem buscar = new JMenuItem("Buscar");

        opcionEdi.add(copiar);
        opcionEdi.add(cortar);
        opcionEdi.add(pegar);
        opcionEdi.add(buscar);

        // Herramientas
        JMenuItem config = new JMenuItem("Configuración");
        /* Creamos una nueva opción de menú, como item de la opción principal
        y creamos y agregamos a su vez los JMenuItem finales. */
        JMenu ayuda = new JMenu("Ayuda");

        JMenuItem version = new JMenuItem("Versión");
        JMenuItem faq = new JMenuItem("FAQ");

        ayuda.add(version);
        ayuda.add(faq);

        opcionHer.add(config);
        opcionHer.add(ayuda);


        /* IMPORTANTE: No se debe agregar la barra al panel, hasta que esté completa */
        add(barraMenu);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        /* Creamos un JPopupMenu agregamos varios JMenuItem y algunos separadores. */
        JPopupMenu menuPop = new JPopupMenu();
        menuPop.add(copiar);
        menuPop.add(cortar);
        menuPop.add(pegar);
        menuPop.add(new JPopupMenu.Separator());
        menuPop.add(buscar);
        menuPop.add(new JPopupMenu.Separator());
        menuPop.add(salir);

        /* Agregamos el menú emergente al JPanel */
        setComponentPopupMenu(menuPop);

    }
}
