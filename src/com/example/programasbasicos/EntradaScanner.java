package com.example.programasbasicos;

import java.util.Scanner;

public class EntradaScanner {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("Hola "+nombre+"!");
        System.out.print("Introduce el primer número: ");
        int numero1 =  entrada.nextInt();
        System.out.print("Introduce el segundo número: ");
        int numero2 =  entrada.nextInt();
        System.out.println("El resultado de la suma es: "+(numero1+numero2)+" !");

        /*  Al usar un nextLine después de otro input el funcionamiento no es el esperado.
            La instancia de Scanner va a recoger el último enter introducido, en lugar de
            esperar el nuevo input.
            Para evitar esto debemos usar nextLine en primer lugar o capturar el anterior "enter"
            mediante un nextLine adicional, antes del realmente deseado.
            Esto no ocurre cuando al nextLine le precede otro nextLine.
            Ejemplo:
        */
        System.out.print("Introduce tu número de la suerte: ");
        byte lucknum = entrada.nextByte();
        System.out.print("Introduce tu nombre: ");
        entrada.nextLine(); // Esta instrucción es la que previene el comportamiento no deseado
        String name = entrada.nextLine();
        System.out.println(lucknum+" es tu número de la suerte, "+name+"?");

        // Es una buena práctica cerrar el escáner cuando dejas de usarlo
        // para ahorrar memoria, pues se queda siempre a la escucha en caso contrario
        entrada.close();

    }
}
