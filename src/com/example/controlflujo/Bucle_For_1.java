package com.example.controlflujo;

public class Bucle_For_1 {

    public static void main(String[] args) {

        // El incremento/decremento del contador se hace al finalizar el bloque de código
        // Para finalizar la ejecución del bloque usamos la instrucción break
        for (int i=1;i<11;i++) {
            System.out.println("Iteración "+i+" del bucle");
            if (i == 6) break;
        }
        System.out.println("Bucle finalizado.");
    }
}
