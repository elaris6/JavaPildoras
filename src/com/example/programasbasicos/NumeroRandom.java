package com.example.programasbasicos;

import java.util.Random;

public class NumeroRandom {

    public static void main(String[] args) {

        // Con la clase Random. max es exclusivo y min es inclusivo
        // random.nextInt(max - min) + min
        // Ejemplo para random entre 1 y 10
        Random num = new Random();
        int num1;// = num.nextInt(62)+1;

        // Con la clase Math. La función random devuelve entre 0.0 y 1.0.
        // max y min son inclusivos
        // ((Math.random() * (max - min) + min)
        // Ejemplo para random entre 1 y 10
        int num2;// = (int)((Math.random()*62));

        for (int i=0;i<10;i++) {
            num1 = num.nextInt(62)+1;
            num2 = (int)((Math.random()*62));

            System.out.println("Con clase Random: "+num1+" Con clase Math: "+num2);
        }

        /*
        Random num = new Random();
        long num1;
        double num2;

        for (int i=0;i<20;i++){
            num1 = (long) Math.floor(num.nextDouble()*9999999999L);
            System.out.println(num1);
        }
        for (int i=0;i<0;i++){
            num2 = num.nextDouble()*999999;
            System.out.println(num2);
        }*/

    }
}
