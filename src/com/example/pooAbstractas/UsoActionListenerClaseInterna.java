package com.example.pooAbstractas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
// Toolkit nos permite acceder a los recusos hardware del sistema
import java.awt.Toolkit;

public class UsoActionListenerClaseInterna {

    public static void main(String[] args) {

        Reloj miReloj = new Reloj(3000,true);
        miReloj.ejecutarTemp();
        JOptionPane.showMessageDialog(null,"Aceptar para finalizar");
    }
}

class Reloj {

    private int intervalo;
    private boolean sonido;

    public Reloj (int intervalo, boolean sonido) {
        this.intervalo = intervalo;
        this.sonido = sonido;
    }

    public void ejecutarTemp () {

        ActionListener listener = new DameLaHora();

        Timer miTemporizador = new Timer(intervalo,listener);
        miTemporizador.start();
    }

    // Deinifimos una clase interna. La clase "DameLaHora", es interna respecto
    // a la clase "Reloj"
    // Solo se puede aplicar el modificador "private" a una clase interna
    private class DameLaHora implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Date ahora = new Date();
            System.out.println("Ahora es: "+ahora);
            // La clase "DameLaHora" puede acceder al atributo "sonido" que es
            // private, por ser una clase interna, en caso contrario, no podría.
            if (sonido) Toolkit.getDefaultToolkit().beep();
        }
    }
}
