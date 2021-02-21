package com.example.controlflujo;

import java.util.Scanner;

public class Condicionales_operador_ternario {

    public static void main(String[] args) {

        // No muy usado, pero muy limpio para condicionales muy sencillos
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        byte edad = entrada.nextByte();
        entrada.close();

        /*
        if (edad>=18) {
            System.out.println("Autorizado!");
        }
        else {
            System.out.println("No autorizado!");
         */

        // Mismo ejemplo
        String mayor = (edad >= 18)?"Autorizado!":"NO autorizado!";
        System.out.println(mayor);

    }
}
