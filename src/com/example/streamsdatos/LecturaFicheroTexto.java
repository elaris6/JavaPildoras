package com.example.streamsdatos;

import java.io.FileReader;
import java.io.IOException;

public class LecturaFicheroTexto {

    public static void main(String[] args) {

        LeerFichero fichero = new LeerFichero();
        // Para la ruta podemos usar doble barra invertida o barra normal
        fichero.leeDatos("C:\\CODE\\Java\\JavaLearn\\src\\com\\example\\streamsdatos\\fichero_lectura.txt");
    }
}
/* LEER FICHERO TEXTO
*
*  https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Reader.html
*  https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/InputStreamReader.html
*  https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/FileReader.html
*
*  Para el ejemplo se usará la clase abstracta FileReader, pero será necesario aprender
*  a usar también la clase "InputStreamReader", que es más compleja, pero más potente.
*
*  */
class LeerFichero {

    public void leeDatos(String fichero) {
        try {
            FileReader lector = new FileReader(fichero);

            int caracter = 0;
            char letra;

            /* Leemos el stream de datos (en este caso un fichero) con un bucle while,
            * ya aprovechando que el método "read()" devuelve el valor -1 si no hay
            * más datos que leer. */
            while ( caracter!= -1) {
                /* El método "read()" devuelve el valor int correspondiente al código unicode
                 * del caracter leído.
                 * https://en.wikipedia.org/wiki/List_of_Unicode_characters
                 * Hacemos por tanto un casting del código al tipo char, para convertir en
                 * caracter el código de caracter leído. */
                caracter=lector.read();
                //System.out.println(caracter);
                letra=(char)caracter;
                System.out.print(letra);
            }
            /* Cerramos el lector del fichero con el método "close()". Se podría hacer
            * dentro de una cláusula "finally", pero para ello deberíamos hacer ciertos
            * cambios, pues no detectaría tal como está ahora el objeto "lector", al
            * estar ya dentro del "try".
            *
            * El método "close()" debe estar dentro de un try catch, peus devuelve una
            * excepción de tipo IOException. */
            lector.close();
        }
        /* La clase "FileReader" lanza una excepción de tipo "FileNotFoundException",
        * pero la clase el método read() lanza una excepción de tipo "IOException", por
        * lo que deberemos hacer el catch de "IOException" para englobar ambas, ya que
        * "FileNotFoundException" hereda de "IOException". */
        catch (IOException e) {
            System.out.println("Fichero no encontrado");
            e.printStackTrace();
        }
    }
}
