package com.example.programasbasicos;

public class ClasePrueba {
    public static void main(String[] args){
        // Comments blah, blah
        /*
            Comments several lines
            Variables, constantes e impresión por pantalla
         */
        int num1,num2=4,num3;
        num1 = 0;
        num3 = num1;
        System.out.println(num3);
        char letra;
        letra = 'a';
        double numdecimal = 3.14159;
        final double PULGADA = 2.54; // Esto es una constante. Por convención, se ponen en mayúsculas.
        // Imprimendo variables y texto con variables:
        System.out.println("Imprimiendo cositas por pantalla :)");
        System.out.println(num1 + "/" + num2 + '/' + num3 + '/' + letra + '/' + numdecimal);
        System.out.printf("num1: %s\nnum2: %s\nnum3: %s\nletra: %s\nnumdecimal: %s\n", num1, num2, num3, letra, numdecimal);
        System.out.println(num2+" pulgadas son: "+num2 * PULGADA+" cm");
        // En la anterior no es neceario, pero en la siguiente es necesario el paréntesis para que sume y no concatene
        System.out.println("El resultado de esta suma es: "+(num2+numdecimal));
        // Si usamos print en lugar de println, no se genera un sálto de línea entre ella y la siguiente
        System.out.print("Chachi que SI!");
        System.out.print("Chachi que NO!");
    }
}
