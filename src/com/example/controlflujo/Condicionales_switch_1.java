package com.example.controlflujo;

import java.util.Scanner;

public class Condicionales_switch_1 {

    public static void main(String[] args) {

        /* USO BASICO DE SWITCH
           Detalle de usos:
           https://javadesdecero.es/basico/sentencia-switch-java-ejemplo/

           Un switch SOLO puede evaluar los siguientes tipos y clases
           char, byte, short, int, String y enum.

           IMPORTANTE: El break es opcional, pero si no se indica, una vez encuentre un punto de entrada
           se ejecutarán las instrucciones del resto de case aunque no se cumplan.
        */

        Scanner entrada = new Scanner(System.in);
        System.out.print("Cuántos lenguajes de programación conoces? ");
        byte num = entrada.nextByte();
        entrada.close();

        switch (num) {

            case (0):
                System.out.println("Deberías aprender alguno!");
                break;
           case (1):
                System.out.println("Deberías aprender alguno más para mejorar!");
                break;
            case (2):
                System.out.println("Vas por el buen camino!");
                break;
            case (3):
                System.out.println("Eres un buen profesional!");
                break;
            case (4):
                System.out.println("Eres una máquina!");
                break;
            default:
                // El default es opcional. En caso de usarse deber ir siempre al final
                System.out.println("Eres leyenda!");
        }
        System.out.println("Programa finalizado.");
    }
}
