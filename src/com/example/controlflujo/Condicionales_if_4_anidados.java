package com.example.controlflujo;

import javax.swing.*;

public class Condicionales_if_4_anidados {

    public static void main(String[] args) {
        // Ejemplo IF anidados
        // Determinar si un año es bisiesto

        short anio = Short.parseShort(JOptionPane.showInputDialog("Introduce un año"));

        // Si el bloque del if o del else solo tiene una instrucción,
        // se podrían omitir las llaves, como se muestra en el ejemplo.
        if (Math.floorMod(anio, 4) == 0) {
            if (Math.floorMod(anio, 100) == 0) {
                if (Math.floorMod(anio, 400) == 0) JOptionPane.showMessageDialog(null, "El año es bisiesto!");
                else JOptionPane.showMessageDialog(null, "El año NO es bisiesto!");
            }
            else JOptionPane.showMessageDialog(null, "El año es bisiesto!");
        }
        else JOptionPane.showMessageDialog(null, "El año NO es bisiesto!");
    }
}
