package com.example.streamsdatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscrituraFicheroBytes {

    public static void main(String[] args) {

        String rutaOrigen ="C:/CODE/Java/JavaLearn/src/com/example/streamsdatos/emoji.png";
        String rutaDestino ="C:/CODE/Java/JavaLearn/src/com/example/streamsdatos/copia.png";
        CopiarFicheroBytes fichero = new CopiarFicheroBytes();
        fichero.copiaFicheroBytes(rutaOrigen,rutaDestino);
    }
}

class CopiarFicheroBytes {

    public void copiaFicheroBytes (String ficheroOrigen, String ficheroDestino ){

        int totalBytes=0;

        /* LEEMOS FICHERO */

        try {
            /* Creamos un objeto "FileInputStream", para poder leer los bytes de
            * un fichero. */
            FileInputStream fichero = new FileInputStream(ficheroOrigen);

            /* Usamos la clase "File" y el método "length()" para determinar el
            * tamaño en bytes del fichero. Hay que hacer un casting a int, pues
            * el método devuelve un long. */
            totalBytes = (int)(new File(ficheroOrigen)).length();

            /* Creamos un array para almacenar los bytes del fichero. */
            int bytesFichero[] = new int[(int)totalBytes];

            /* Como ya sabemos la longitud del fichero, no necesitamos un bucle
            * while, podemos recorrerlo con un for. */

            for (int i =0;i<totalBytes;i++) {
                // Leemos los bytes con el método read()
                bytesFichero[i] = fichero.read();
            }
            fichero.close();

            /* Creamos un método interno para realizar la escritura, pues al estar
            * el array dentro de un bloque try catch, el compilador no reconoce el
            * array como inicializado.
            * Tendríamos que hacerlo dentro del mismo bloque, que es menos limpio. */
            escribeFicheroBytes(bytesFichero,ficheroDestino);

        }
        catch (IOException e){
            //e.printStackTrace();
            System.out.println("No se puede abrir el fichero.");
        }
        System.out.println("Total bytes fichero: "+totalBytes);
    }

    private void escribeFicheroBytes(int arrayBytes[], String ficheroDestino ){

        /* CREAMOS FICHERO COPIA
        Creamos un fichero nuevo con el contenido de lo leído. */

        try {
            /* Creamos un objeto "FileOutputStream", para poder leer los bytes de
             * un fichero. */
            FileOutputStream ficheroCopia = new FileOutputStream(ficheroDestino);

            for (int i =0;i<arrayBytes.length;i++) {
                // Escribimos los bytes con el método write()
                 ficheroCopia.write(arrayBytes[i]);
            }
            ficheroCopia.close();
        }
        catch (IOException e) {
            System.out.println("No se pudo crear fichero destino.");
        }
    }
}