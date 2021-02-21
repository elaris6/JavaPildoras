package com.example.arrays;

public class Arrays_1 {

    public static void main(String[] args) {

        //En arrays NO SE PUEDEN MEZCALR TIPOS
        //Los corchetes del inicio se pueden informar delante o detrás del nombre del array
        //Los valores se pueden inicializar en la definición (implícita) o posteriormente (explícita)

        //int array_val[] = {12,11,12,13,14};


        int [] array_valores = new int[5];

        array_valores[0] = 10;
        array_valores[1] = 11;
        array_valores[2] = 12;
        array_valores[3] = 13;
        array_valores[4] = 14;

        //Para recorrer un array podemos usar la propiedad lenght de un array
        //que nos proporcionará la longitud

        for (int i=0;i< array_valores.length;i++) {

            System.out.println("Índice "+i+" valor: "+array_valores[i]);
        }

        //El bucle for each es ideal para recorrer arrays

        for (int elemento:array_valores) {
            System.out.println("Valor: "+elemento);
        }

        String nombre_personas[] = {"Mari","Ali","Nata","Isra","Vicen","Rubén"};

        for (String nombre:nombre_personas) {
            System.out.println("Nombre: "+nombre);
        }

        String palabra = "Esternocleidomastoideo";

        for (char letra:palabra.toCharArray()) {
            System.out.println("Letra: "+letra);
        }


    }
}
