package com.example.interfacesGraficasEventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* INTERFACES Y CLASES DE INTERES
* - Action. Interfaz que implementa métodos importantes como:
* setEnabled, isEnabled, putValue, getValue, addPropertyChangedListener y
* removePropertyChangedListener. Además, implementa "actionPerformed".
* La interfaz "Action" no tiene un adaptador de interfaz, pero tenemos la
* clase "AbstractAction", que implementa (además de otros, todos los métodos
* de "Action" excepto "actionPeformed".
* - AbrstractAction. Clase importante de acciones sobre componentes.
*
* https://docs.oracle.com/javase/7/docs/api/javax/swing/Action.html
* https://docs.oracle.com/javase/7/docs/api/javax/swing/AbstractAction.html
*
*  PARA CREAR UNA COMBINACION DE TECLAS Y ASIGNAR UNA ACCION
*
* - JPanel. Clase con su método heredado getInputMap(int condición). Crear un mapa de entrada (decir a la aplicación quien tiene el foco)
* - KeyStroke. Clase, con su método getKeyStroke(String s). Crear una combinación de teclas
* - InputMap. Clase con su método put(KeyStroke, Object). Asignar combinación de teclas a Objeto descripción
* - ActionMap. Clase con su método put(Object, Action). Asignar objeto descripción a Acción
* */
public class MutiplesFuentesEvento {

    public static void main(String[] args) {

        VentanaMultFuentesEvento ventana = new VentanaMultFuentesEvento();
    }
}
class VentanaMultFuentesEvento extends JFrame {

    VentanaMultFuentesEvento(){

        setSize(360,240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Multiples fuentes de evento");

        add(new PanelMultFuentesEvento());

        setVisible(true);

    }
}
class PanelMultFuentesEvento extends JPanel {

    public PanelMultFuentesEvento (){

        EventoColorFondo colorRojo = new EventoColorFondo("Rojo",Color.RED);
        EventoColorFondo colorVerde = new EventoColorFondo("Verde",Color.GREEN);
        EventoColorFondo colorAzul = new EventoColorFondo("Azul",Color.BLUE);

        add(new JButton(colorRojo));
        add(new JButton(colorVerde));
        add(new JButton(colorAzul));

        /* Combinación teclas Paso 1. Creamos el mapa de entrada. Ver constantes de clase. */
        InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        /* Combinación teclas Paso 2. Crear combinación de teclas. Podríamos meterlo en la invocación
        * del put del Paso 3. */
        KeyStroke combiRED = KeyStroke.getKeyStroke("ctrl R");
        KeyStroke combiGREEN = KeyStroke.getKeyStroke("ctrl G");
        KeyStroke combiBLUE = KeyStroke.getKeyStroke("ctrl B");

        /* Combinación teclas Paso 3. Asignar combinación a un Object. */
        mapaEntrada.put(combiRED, "teclasRojo");
        mapaEntrada.put(combiGREEN, "teclasVerde");
        mapaEntrada.put(combiBLUE, "teclasAzul");

        /* Combinación teclas Paso 4. Crear objeto ActionMap y asignar el mapa de dentrada a una acción. */
        ActionMap mapaAccion = getActionMap();
        mapaAccion.put("teclasRojo",colorRojo);
        mapaAccion.put("teclasVerde",colorVerde);
        mapaAccion.put("teclasAzul",colorAzul);

    }

    /* Implementamos una clase que herede de "AbrstractAction". */
    private class EventoColorFondo extends AbstractAction {

        public EventoColorFondo (String nombre, Color color_fondo){

            putValue(Action.NAME,nombre);
            putValue("colorFondo",color_fondo);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            Color c = (Color) getValue("colorFondo");
            setBackground(c);
            System.out.println("Nombre acción: "+getValue(Action.NAME));
        }
    }
}

