package com.example.controlflujo;

import javax.swing.*;

public class Condicionales_switch_2 {

    public static void main(String[] args) {

        String dia = JOptionPane.showInputDialog("Introduce el día de la semana");

        // Se pueden agrupar múltiples case si las instrucciones a ejecutar son iguales
        // Pasamos el String dia a minúsculas con el método toLowerCase.
        switch (dia.toLowerCase()) {

            case "lunes":
            case "martes":
            case "miércoles":
            case "miercoles":
            case "jueves":
            case "viernes":
                JOptionPane.showMessageDialog(null,"Es un día laborable");
                break;
            case "sábado":
            case "sabado":
            case "domingo":
                JOptionPane.showMessageDialog(null,"Es un día de finde!");
                break;
            default:
                JOptionPane.showMessageDialog(null,"Día no identificado");
        }

    }
}
