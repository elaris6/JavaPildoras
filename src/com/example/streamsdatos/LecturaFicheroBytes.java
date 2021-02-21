package com.example.streamsdatos;

import java.io.FileInputStream;
import java.io.IOException;

public class LecturaFicheroBytes {

    public static void main(String[] args) {

        lectorFicheroBytes fichero = new lectorFicheroBytes();
        fichero.leeFicheroBytes("C:/CODE/Java/JavaLearn/src/com/example/streamsdatos/emoji.png");

    }
}

/* LECTURA FICHEROS DE BYTES
*
* Para leer ficheros como bytes en lugar de como texto plano, deberemos usar la clase
* "FileInputStream".
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/FileInputStream.html
*
* Muy similar a la lectura de caracteres sin buffer, vamos recorriendo los bytes del fichero.
* */

class lectorFicheroBytes {

    public void leeFicheroBytes (String ruta_fichero){
        int total_bytes=0;
        int un_byte;
        try {
            FileInputStream fichero = new FileInputStream(ruta_fichero);

            un_byte = fichero.read();

            /* Leemos los bytes mientras la lectura no devuelva "-1", indicando
            * que no hay más bytes para leer. */
            while (un_byte != -1) {
                total_bytes++;
                //System.out.println(un_byte);
                un_byte = fichero.read();
            }

            fichero.close();
            System.out.println("Total bytes fichero: "+total_bytes);
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

}

