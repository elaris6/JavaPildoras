package com.example.streamsdatos;

import java.io.FileWriter;
import java.io.IOException;

public class EscrituraFicheroTexto {

    public static void main(String[] args) {

        String contenido = "Línea 1\nLínea 2\nLínea 3";
        String ruta_fichero = "C:\\CODE\\Java\\JavaLearn\\src\\com\\example\\streamsdatos\\fichero_escritura.txt";
        EscribirFichero fichero = new EscribirFichero();
        // Para la ruta podemos usar doble barra invertida o barra normal
        fichero.escribirDatos(ruta_fichero,contenido);
    }
}

/* ESCRIBIR FICHERO DE TEXTO
*
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Writer.html
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/OutputStreamWriter.html
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/FileWriter.html
*
* Tenemos las clases Writer, OutputStremWriter y FileWriter, que son las más importantes para
* este tipo de operación.
*
*  */
class EscribirFichero {

    public void escribirDatos(String fichero, String contenido) {

        /* Inicializamos a null el objeto de tipo FileWriter, para poder manejarlo en
        * la cláusula "finally" */
        FileWriter escritor = null;

        try {
            /* Al instanciar el objeto FileWriter, si el fichero no existe, lo crea.
            *
            * Si es el fichero ya existe, hay un constructor que permite informar un
            * parámetro boolean "append", que debe informarse a true, si queremos
            * comenzar a escribir al final del fichero, en lugar de sobreescribirlo.   */
            escritor = new FileWriter(fichero,true);
            //escritor = new FileWriter(fichero);

            for(char caracter:contenido.toCharArray()){
                /* El método "write()" ya puede escribir caracteres, no
                * es necesario informar el código unicode con valor int  */
                escritor.write(caracter);
            }
        }
        catch (IOException e) {
            System.out.println("No ha sido posible acceder al fichero");
            e.printStackTrace();
        }
        /* Usamos la cláusula "finally" y dentro de ella un nuevo try catch,
        * para comprobar si el fichero ha podido abrirse y en tal caso, cerrarlo. */
        finally {
            try {
                if (escritor != null) {
                    escritor.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
