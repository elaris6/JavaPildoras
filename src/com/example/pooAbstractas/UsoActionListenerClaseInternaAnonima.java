package com.example.pooAbstractas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/*
    Vamos a crear un ejemplo sencillo de temporizador que ejecuta una acción cada x milisegundos,
    mientras el programa está en ejecución.

    Los vamos ha hacer mediando el uso de la clase "Timer" de javax.swing, pero esta clase
    requiere a su vez del uso de un objeto que haya implementado la interfaz "ActionListener".

    A diferencia del ejemplo de la clase "UsoActionListener", en este caso lo hacemos implementando
    directamente el método "actionPerformed" de la interfaz "ActionListener" en la creación del
    objeto de tipo "Timer", mediante el uso de una clase interna y anónima.
 */
public class UsoActionListenerClaseInternaAnonima {

    public static void main(String[] args) {

        // En la creación del objeto "Timer", creamos una clase interna y anónima dentro del
        // segundo parámetro que requiere la clase Timer.
        // Dentro de esa clase interna y anónima, implementamos el método requerido por la
        // intrerfaz "ActionListener" ("actionPerformed"), para definir el evento a ejecutar
        // por el objeto "Timer".
        Timer temporizador = new Timer(3000, new ActionListener(){
            private int counter = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                Date horaActual = new Date();
                System.out.println("Evento "+counter+" "+horaActual);
                counter++;
            }
        });

        temporizador.start();
        // Opciones para mantener el timer en ejecución.
        JOptionPane.showMessageDialog(null,"Pulsa 'Aceptar' para detener el temporizador.");
        //while (true){}
    }
}
