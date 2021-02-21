package com.example.ejercicios;

import javax.swing.*;

public class PesoIdeal {

    public static void main(String[] args) {

        String genero = JOptionPane.showInputDialog("Introduce género (H/M)");
        short altura = Short.parseShort(JOptionPane.showInputDialog("Introduce tu altura en cm"));
        String peso = "Entrada género incorrecta";

        if (genero.equals("H") || genero.equals("h")) {
            peso="Tu peso ideal es: "+(altura-110);
        }
        else if (genero.equals("M") || genero.equals("m")) {
            peso="Tu peso ideal es: "+(altura-120);
        }
        JOptionPane.showMessageDialog(null,peso);
    }
}
