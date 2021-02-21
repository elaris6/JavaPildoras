package com.example.programasbasicos;

public class ClaseString {
    public static void main(String[] args) {
        /*
            Ejemplos de declaración de la clase String
            Ejemplos de métodos de la clase String
        */


        String palabras = "Esto es una cadena";
        System.out.println("La longitud de la cadena es: "+palabras.length());
        System.out.println(palabras.charAt(6)); // El índice en String empieza desde 0

        String frase = "No hay nada mejor que levantarse un domingo a estudiar programación";
        System.out.println(frase.substring(0,17));

        String word1 = "palabra";
        String word2 = "Palabra";
        System.out.println(word1.equals(word2));
        System.out.println(word1.equalsIgnoreCase(word2));
    }
}
