package com.example.excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsoFinallyLimpieza {

    public static void main(String[] args) {

        /* Uso de try catch con cláusula "finally" a modo de limpieza, para cerrar
        * conexiones con la consola, ficheros, bbdd... etc, aunque haya algún error
        * previo. */

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un número para el cálculo de raíz cuadrada: ");

        try {
            int num = entrada.nextInt();
            double resultado = Math.sqrt(num);
            System.out.print("La raíz de "+num+" es "+resultado);
        }
        catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("Tipo de entrada incorrecto. Se espera un entero.");
        }
        // Aquí se cierra la conexión con la consola, ocurra o no una excepción en el try
        finally {
            entrada.close();
        }
    }
}
