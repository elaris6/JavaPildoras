package com.example.ejercicios;

import java.util.Scanner;

public class CalculoAreas {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.print("Qué tipo de área quieres calcular?\n1.Cuadrado\n2.Rectángulo\n3.Triángulo\n4.Círculo\nOpción: ");
        byte opcion = entrada.nextByte();

        switch (opcion) {

            case 1:
                System.out.print("Introduce longitud del lado: ");
                double lado = entrada.nextDouble();
                System.out.println("El área del cuadrado es: "+(lado*lado));
                break;
            case 2:
                System.out.print("Introduce longitud de la base: ");
                double base = entrada.nextDouble();
                System.out.print("Introduce longitud de la altura: ");
                double altura = entrada.nextDouble();
                System.out.println("El área del rectángulo es: "+(base*altura));
                break;
            case 3:
                System.out.print("Introduce longitud de la base: ");
                double baseT = entrada.nextDouble();
                System.out.print("Introduce longitud de la altura: ");
                double alturaT = entrada.nextDouble();
                System.out.println("El área del triángulo es: "+(baseT*alturaT)/2);
                break;
            case 4:
                System.out.print("Introduce longitud del radio: ");
                double radio = entrada.nextDouble();
                System.out.print("El área del círculo es: ");
                // Usamos printf para imprimir con formato, haciendo un redondeo del resultado
                System.out.printf("%1.5f",(Math.PI*(radio*radio)));
                break;
            default:
                System.out.println("Error: Opción incorrecta.");

        }
    }
}
