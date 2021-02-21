package com.example.pooAbstractas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class UsoActionListenerClaseInternaAnonima2 {

    public static void main(String[] args) {

        RelojAnonimo miReloj = new RelojAnonimo();
        miReloj.ejecutarTemp(3000,true);

        JOptionPane.showMessageDialog(null,"Aceptar para finalizar");
    }
}

class RelojAnonimo {

    // Respecto al ejemplo de la clase interna local, creamos la clase necesaria para la gestión
    // de la interfaz ActionListener, directamente en la creación de la instancia de la clase Timer
    public void ejecutarTemp (int intervalo, boolean sonido) {

        // Podemos prescindir de crear una clase completa, y hacerlo de forma online anónima en la
        // instanciación de Timer

        Timer miTemporizador = new Timer(intervalo, new ActionListener() {
            // Al igual que en las clases internlas locales, son posibles porque solo crearemos una
            // instancia de las mismas, creada justo en la creación del objeto Timer en este caso.
            @Override
            public void actionPerformed(ActionEvent e) {
                Date ahora = new Date();
                System.out.println("Ahora es: "+ahora);
                // Como si fuese una clase interna local, puede acceder al atributo "sonido"
                // que pertenece al método por ser una clase interna a este.
                if (sonido) Toolkit.getDefaultToolkit().beep();
            }
        });
        miTemporizador.start();
    }
}
