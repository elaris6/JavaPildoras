package com.example.pooAbstractas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class UsoActionListenerClaseInternaLocal {

    public static void main(String[] args) {

        // Al prescindir del constructor en la clase externa y pasar los atributos al
        // método, debemos modificar la instanciación y la llamada al método.
        /*
        RelojLocal miReloj = new RelojLocal(3000,true);
        miReloj.ejecutarTemp();
        */
        RelojLocal miReloj = new RelojLocal();
        miReloj.ejecutarTemp(3000,true);

        JOptionPane.showMessageDialog(null,"Aceptar para finalizar");
    }
}

class RelojLocal {

    /*
    private int intervalo;
    private boolean sonido;

    public RelojLocal (int intervalo, boolean sonido) {
        this.intervalo = intervalo;
        this.sonido = sonido;
    } */


    // Respecto al ejemplo de la clase interna "no local", si pasamos los atributos como
    // entrada al método, podemos incluso prescindir del constructor de clase externa,
    // puesto que quien los va a usar realmente es el método y la clase interna local.
    public void ejecutarTemp (int intervalo, boolean sonido) {

        // Definimos la una clase interna dentro de un método de la clase externa.
        // Esto es una "clase interna local", que solo será accesible dentro del ámbito
        // del método en el que se ha definido.
        // La clase interna local podrá acceder a los recursos y métodos de la clase externa
        // pero no al revés.
        // Estas clases no admiten los modificadores public, private ni protected
        class DameLaHora implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {

                // La clase interna local es posible porque solo la vamos a instanciar
                // una únca vez, en caso contrario no podríamos usar esta estructura.
                Date ahora = new Date();
                System.out.println("Ahora es: "+ahora);
                // La clase "DameLaHora" puede acceder al atributo "sonido" que pertenece
                // al método por ser una clase interna a este.
                if (sonido) Toolkit.getDefaultToolkit().beep();
            }
        }

        ActionListener listener = new DameLaHora();

        Timer miTemporizador = new Timer(intervalo,listener);
        miTemporizador.start();
    }
}