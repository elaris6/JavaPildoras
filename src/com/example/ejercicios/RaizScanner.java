package com.example.ejercicios;

import java.util.Scanner;

public class RaizScanner {

    public static void main(String[] args) {
        // Ejercicios 1 y 2 vídeo 21

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un número para el cálculo de raíz cuadrada: ");

        /* Versión normal

        int num = entrada.nextInt();
        double resultado = Math.sqrt(num);
        System.out.print("La raíz de "+num+" es "+resultado);

        */

        // Versión en una sola línea
        System.out.print("La raíz es "+Math.sqrt(entrada.nextInt()));

        entrada.close();

    }
}
