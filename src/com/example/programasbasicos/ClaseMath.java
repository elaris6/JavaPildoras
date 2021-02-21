package com.example.programasbasicos;

public class ClaseMath {
    public static void main(String[] args){
        // Consultar clases api standard: https://docs.oracle.com/javase/7/docs/api/

        int num1 = 9; // Lo declaramos como int a drede para comprobar que la JVM lo transforma en tiempo de ejecución
        System.out.println(Math.sqrt(num1));

        //Hay que invocar a round con un tipo float, para que nos devuelva un int
        int resultado = Math.round(3.4F);

        //Si el valor de entrada de round tuviera que ser forzosamente un double, necesitaríamos hacer un
        //"casting" informando al sistema el tipo que queremos que sea devuelto
        //Atención a la posible pérdida de precisión al hacer un casting
        int resultado2 = (int)Math.round(3.4);

        // Ejercicio 1
        int numero = 9;
        int resultado3 = (int)Math.sqrt(numero);

        System.out.println("La raíz cuadrada de "+numero+" es "+resultado3);

        // Ejercicio 2
        int base, exponente;
        base = 5;
        exponente = 12;
        long resultado4 = (long)Math.pow(base,exponente);
        System.out.println(base+" elevado a "+exponente+" es "+resultado4);

        // Ejercicio 3
        double num3 = 16.35;
        System.out.println(num3+" redondeado = "+Math.round(num3));


    }
}
