package com.example.ejercicios;

import javax.swing.*;
import java.util.Random;

public class AdivinaNumero {

    public static void main(String[] args) {
        /*
            Generación de un número aleatorio y bucle while para adivinarlo.
            Dos formas de generar random en java. Con la clase Random, función nextInt
            y con la función random de la clase Math.
        */

        // Con la clase Random. max es exclusivo y min es inclusivo
        // random.nextInt(max - min) + min
        Random num = new Random();
        int num1 = num.nextInt(100)+1;

        // Con la clase Math. La función random devuelve entre 0.0 y 1.0.
        // max y min son inclusivos
        // ((Math.random() * (max - min) + min)
        int num2 = (int)((Math.random()*99)+1);

        //System.out.println("Con clase Random: "+num1+"\nCon clase Math: "+num2);

        JOptionPane.showMessageDialog(null,"Adivina el número entre 1 y 100!");

        int userNum = -1;
        int intentos = 1;
        String mensaje = "";

        while (userNum != num1) {
            userNum = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número y prueba suerte!"));
            if (userNum == num1) {
                mensaje = "Correcto. Adivinado con "+intentos+" intentos!";
            }
            else {
                if (userNum > num1) {
                    mensaje = "No! El número es menor. Llevas "+intentos+" intentos!";
                }
                else {
                    mensaje = "No! El número es mayor. Llevas "+intentos+" intentos!";
                }
                intentos += 1;
            }
            JOptionPane.showMessageDialog(null,mensaje);
        }
    }
}
