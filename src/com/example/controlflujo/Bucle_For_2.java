package com.example.controlflujo;

public class Bucle_For_2 {

    public static void main(String[] args) {

        // Anidamiento de bucles for
        for (int i = 0;i < 10;i++) {

            for (int j = 0;j < 10; j++) {

                System.out.println("i="+i+",j="+j);
            }
        }
        System.out.println("Bucle finalizado!");
    }
}
