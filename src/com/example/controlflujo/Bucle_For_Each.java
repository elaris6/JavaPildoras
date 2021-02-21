package com.example.controlflujo;

public class Bucle_For_Each {

    public static void main(String[] args) {

        //BUCLE FOR EACH
        // Similar funcionamiento a los pythonianos


        int array_valores[] = {25,17,6,2345,-79,0,12};

        for (int elemento:array_valores) {
            System.out.println("Valor: "+elemento);
        }

        String nombre_personas[] = {"Mari","Ali","Nata","Isra","Vicen","Rubén"};

        for (String nombre:nombre_personas) {
            System.out.println("Nombre: "+nombre);
        }

        String palabra = "Esternocleidomastoideo";

        // Usamos la función toCharArray para recorrer un string con for each

        for (char letra:palabra.toCharArray()) {
            System.out.println("Letra: "+letra);
        }

        // Para recorrer un array bidimensional, el primer bucle
        // deberá recorrer un elemento de tipo array

        String array_words[][] = {
                {"uno","dos","tres"},
                {"cuatro","cinco","seis"},
                {"siete","ocho","nueve"}
        };

        for (String fila[]:array_words) {
            for (String elemento:fila) {
                System.out.print(elemento+"\t");
            }
            System.out.println();
        }

    }
}
