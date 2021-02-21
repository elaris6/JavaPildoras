package com.example.controlflujo;

import javax.swing.JOptionPane;

public class Condicionales_if_3 {

    public static void main(String[] args) {
        /*  USO OPERADORES LOGICOS

            Programa para evaluar las condiciones de un alumno para el acceso a una beca
            en función de los ingresos familiares, la distancia al centro de estudio
            y el número de hermanos en el centro.
         */

        int distancia = Integer.parseInt(JOptionPane.showInputDialog("Introduce distancia al centro de estudios en km"));
        double renta = Double.parseDouble(JOptionPane.showInputDialog("Introduce la renta familiar"));
        byte hermanos = Byte.parseByte(JOptionPane.showInputDialog("Introduce número de hermanos en el centro"));

        // Si el bloque del if o del else solo tiene una instrucción,
        // se podrían omitir las llaves
        if ((distancia > 10 && renta < 20000) || (hermanos > 1)) {
            JOptionPane.showMessageDialog(null,"El alumno tiene derecho a beca");
        }
        else if ((renta < 10000) || (distancia > 5 && hermanos > 0)){
            JOptionPane.showMessageDialog(null,"El alumno tiene derecho a beca");
        }
        else JOptionPane.showMessageDialog(null, "El alumno NO tiene derecho a beca");
    }
}
