package com.example.excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EjemploEntradaDatos {

    public static void main(String[] args) {

        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Introducir datos");
        System.out.println("2. Salir del programa");

        Scanner entrada=new Scanner (System.in);
        String decision=entrada.nextLine();

        if (decision.equals("1")){
            /* En caso de que el método lance una excepción no controlada, el sistema
            * no nos obliga a rodearla de un bloque try catch.
            * Sin embargo, si es una excepción controlada, si que se nos obligará a
            * usar un try catch simplemente para que se permita la compilación. */
            try {
                pedirDatos();
            }
            /* Al realizar el catch en la invocación, podríamos informar
            * un tipo de excepción más genérico, o el más genérico "Exception" y seguiría
            * funcionando perfectamente, pero no se considera una buan práctica y
            * siempre que sea posible se deberá informar el tipo de excepción precisa para
            * aportar el mayor detalle posible al código. */
            catch (InputMismatchException e){
                System.out.println("Valor introducido incorrecto.");
                //Con el método "printStackTrace" imprimimos la traza del error sin que el
                // programa caiga.
                e.printStackTrace();

            }

        }
        else if (decision.equals("2")) {
            System.out.println("Adios");
            System.exit(0);
        }
        else{
            System.out.println("Opción no válida.");
        }
        entrada.close();
        System.out.println("Hemos terminado");
    }

    /* Usamos la instrucción "throws" para informar de que el método puede lanzar una
    * excepción.
    *
    * En este caso, al tratarse de una excepción no controlada, en realidad no sería
    * obligatorio el uso del "throws tipo_excepción", si ya lo estamos controlando con
    * un try catch al invocar el método, pero se considera una buena práctica.
    *
    * Así mismo, al igual que al realizar el catch en la invocación, podríamos informar
    * un tipo de excepción más genérico, o el más genérico "Exception" y seguiría
    * funcionando perfectamente, pero de nuevo, no se considera una buan práctica y
    * siempre que sea posible se deberá informar el tipo de excepción precisa para
    * aportar el mayor detalle posible al código. */
    static void pedirDatos() throws InputMismatchException {

        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduce tu nombre, por favor");
        String nombre_usuario=entrada.nextLine();
        System.out.println("Introduce edad, por favor");
        int edad=entrada.nextInt();
        System.out.println("Hola " + nombre_usuario + ". El año que viene en esta fecha tendrás " + (edad+1) + " años :)");
        entrada.close();
    }
}
