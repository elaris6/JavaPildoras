package com.example.controlflujo;

import java.util.Scanner;

public class Condicionales_if_1 {

    public static void main(String[] args) {
        // USO BASICO IF + ELSE

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        byte edad = entrada.nextByte();
        entrada.close();

        // Si el bloque del if o del else solo tiene una instrucción,
        // se podrían omitir las llaves
        if (edad>=18) {
            System.out.println("Autorizado!");
        }
        // El else es opcional
        else {
            System.out.println("No autorizado!");
        }

    }
}
