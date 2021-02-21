package com.example.excepciones;

import javax.swing.*;

/*  RUNTIME EXCEPTIONS
*   En este tipo de errores o excepciónes debe ser el programador el que se encargue
*   de controlarlas, puesto que se deben a fallos en la "lógica" del programa, o a
*   circunstancias que pueden ser previsibles de antemano. */
public class ExcepcionesRuntime {

    public static void main(String[] args) {

        // Matriz con impresión de su contenido en consola
        int matriz[] = {5,10,15,20,25};

        /*  for (int i=0;i<6;i++) {
        *   Si intentamos acceder a una posición que no existe en el array, se generaría
        *   un error en tiempo de ejecución, ya que durante la compilación esto no
        *   genera un error, puesto que la sintaxis es correcta.
        *   https://docs.oracle.com/javase/9/docs/api/java/lang/ArrayIndexOutOfBoundsException.html */
        for (int i=0;i<5;i++) {
            System.out.println("Valor "+i+" = "+matriz[i]);
        }

        // Petición de datos e impresión

        String nombre = JOptionPane.showInputDialog("Introduce tu nombre");

        /*  En este caso, si el usuario introduce una cadena de texto que el programa no es
        *   capaz de convertir a un entero, también se genera un error en tiempo de ejecución.
        *   En este caso un error diferente:
        *   https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/NumberFormatException.html*/
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu país de residencia"));
        JOptionPane.showMessageDialog(null,"Hola "+nombre+" de "+edad+" años de edad");

    }
}
