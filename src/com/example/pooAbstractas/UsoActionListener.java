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

    Por lo tanto, necesitamos crear una clase que implemente ActionListener, que a su vez
    nos obliga a implementar el método "actionPerformed" con la acción a realizar.
 */

public class UsoActionListener {

    public static void main(String[] args) {


        // Creamos un objeto de la clase que implementa la interfaz "ActionListener"
        Temporizador listener = new Temporizador();

        // Creamos un objeto "Timer" que ejecutará las acciones y controlará el tiempo entre ellas
        Timer temporizador = new Timer(3000, listener);

        // Es necesario iniciar el objeto Timer para que arranque la ejecución
        temporizador.start();

        // Debemos hacer que el programa continúe en ejecución para que la clase "Timer" haga
        // su trabajo, ya que si no el programa finalizará justo tras la ejecución del método
        // .start() y no llegará a levantar ningún evento.
        // Esto lo podemos hacer mediante un while infinito, o un mensaje JOptionPane que
        // mantiene el programa en ejecución mientras no se cierre.
        JOptionPane.showMessageDialog(null,"Pulsa 'Aceptar' para detener el temporizador.");

        // Manteniendo el programa en ejecución con un bucle while infinito.
        // Esto nos obligaría a finalizar el programa manualmente.
        //while (true){}

    }
}
// Clase para implementar la interfaz "ActionListener"
class Temporizador implements ActionListener {

    private int counter = 0;

    // Método heredado y de implementación obligatoria, para definir el evento a ejecutar
    @Override
    public void actionPerformed(ActionEvent e) {

        Date horaActual = new Date();
        System.out.println("Evento "+counter+" "+horaActual);
        counter++;

    }
}