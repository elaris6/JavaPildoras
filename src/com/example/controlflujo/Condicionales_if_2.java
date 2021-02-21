package com.example.controlflujo;

import java.util.Scanner;

public class Condicionales_if_2 {

    public static void main(String[] args) {
        // USO IF, ELSE IF, ELSE

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        byte edad = entrada.nextByte();
        entrada.close();

        // Si el bloque del if o del else solo tiene una instrucción,
        // se podrían omitir las llaves
        if (edad<12) {
            System.out.println("Eres un niño");
        }
        // El else if es opcional
        else if (edad<18){
            System.out.println("Eres un adolescente");
        }
        else if (edad < 25){
            System.out.println("Eres un joven");
        }
        else if (edad < 40){
            System.out.println("Eres un adulto");
        }
        else if (edad < 60){
            System.out.println("Eres un madurito");
        }
        else if (edad < 75){
            System.out.println("Eres un mayor");
        }
        // El else es opcional
        else {
            System.out.println("Eres un viejuno");
        }
        System.out.println("Programa finalizado!");

    }
}
