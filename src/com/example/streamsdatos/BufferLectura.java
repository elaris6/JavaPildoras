package com.example.streamsdatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferLectura {

    public static void main(String[] args) {

        lectorBuffer leerFichero = new lectorBuffer();
        leerFichero.leeConBuffer("C:/CODE/Java/JavaLearn/src/com/example/streamsdatos/fichero_lectura.txt");

    }
}

/* BUFFER DE LECTURA
*
* Cuando gestionamos un fichero grande, la lectura o escritura directa sobre el mismo
* es muy poco eficiente a nivel de recursos y más propensa al fallo no controlado.
* Para evitar esto, como en muchos otros ámbitos de los flujos de información, se puede
* usar un buffer de datos. En el caso de Java estos buffer son autogestionados.
*
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/BufferedReader.html
*
* Existe un constructor que genera un buffer con un tamaño por defecto, y otro que
* permite especificar el tamaño del buffer deseado.
* El buffer es autogestionado, llenándose y vaciándose según se va usando por el
* programa.
*
*  */
class lectorBuffer {

    public void leeConBuffer(String ruta_fichero) {

        try {
            /* Creamos un objeto de tipo FileReader, que hereda de Reader, que es
            * el objeto que necesitamos para instanciar la clase "BufferedReader" */
            FileReader lector_fichero = new FileReader(ruta_fichero);

            /* Instanciamos la clase "BufferedReader" */
            BufferedReader lector_buffer = new BufferedReader(lector_fichero);

            /* Hacemos una primera lectura para confirmar que el ficero no está
            * vacío antes de entrar en el bucle while de lectura de líneas ya que
            * sabemos que el método "readLine()" devolverá "null" si ha llegado al
            * final del fichero.
            * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/BufferedReader.html#readLine()
            *  */
            String buffer = lector_buffer.readLine();

            while (buffer != null) {
                System.out.print("línea: ");
                System.out.println(buffer);
                buffer = lector_buffer.readLine();
            }

            // Cerramos el stream del fichero de lectura.
            lector_fichero.close();

        }
        catch (IOException e) {
            System.out.println("No ha sido posible leer el fichero:\n"+ruta_fichero);
            //e.printStackTrace();
        }
    }
}

