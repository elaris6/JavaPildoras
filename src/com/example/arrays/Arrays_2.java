package com.example.arrays;

public class Arrays_2 {

    public static void main(String[] args) {

        // Arrays de 2 dimensiones

        // Declaración con inicialización explícita
        int array_valores[][] = new int[5][5];

        // Recorrer con bucle FOR clásico
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                array_valores[i][j] = i*j;
                System.out.print(array_valores[i][j]+"\t");
            }
            System.out.print("\n");
        }


        // Declaración con inicialización implícita

        String array_words[][] = {
                {"uno","dos","tres"},
                {"cuatro","cinco","seis"},
                {"siete","ocho","nueve"}
        };

        // Recorrer con bucle FOR EACH

        for (String fila[]:array_words) {
            for (String elemento:fila) {
                System.out.print(elemento+"\t");
            }
            System.out.println();
        }

    }
}
