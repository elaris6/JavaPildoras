package com.example.accesoFicherosExternos;

import java.io.File;

public class AccesoFicherosExternos {

    /* ACCESO FICHEROS Y CARPETAS EXTERNAS
    *
    * Para la gestión de ficheros y carpetas externas usaremos la clase "File", que tiene muchos
    * métodos para la gestión de ficheros o carpetas como: ver si ,existe, navegar por paths, tamaños...
    *
    * Existen dos paquetes estándar para ello, el legacy "java.io.file":
    * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/File.html
    *
    * Y uno más reciente "java.nio.file", que gestiona algunas cuestiones de manera diferente
    * y posiblemente más eficiente en según que situaciones:
    * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/package-summary.html
    *
    * Documentación externa interesante usando ambos paquetes:
    * https://mkyong.com/tutorials/java-io-tutorials/
    *
    * Para asegurar la compatibilidad entre sistemas, evitando problemas de separador de path,
    * revisar: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/File.html#separator
    *
    * Habría que construir la ruta como: "C:"+File.separator+"carpeta1"+File.separator+"carpeta2"...
    * */

    public static void main(String[] args) {

        /* Si no se especifica una ruta al crear el objeto de tipo File, se tomará la ruta
        * del espacio de trabajo del programa desde el que se instancia. */

        File fichero = new File("C:/Users/elaris6/Downloads/screenshot.png");

        System.out.println("Absolute path: "+fichero.getAbsolutePath());

        /* El método "exists()" devolverá true o false dependeindo de si el objeto existe
        * realmente en la ubicación. */
        System.out.println("El fichero/carpeta existe: "+fichero.exists());

        System.out.println("Ruta: "+fichero.getPath());
        System.out.println("Ruta parent: "+fichero.getParent());

        System.out.println("\n\n");

        File carpeta = new File("C:/Users/elaris6/Downloads/");

        System.out.println("Absolute path: "+carpeta.getAbsolutePath());

        System.out.println("El fichero/carpeta existe: "+carpeta.exists());

        System.out.println("Ruta: "+carpeta.getPath());

        /* Si el objeto es una carpeta, podemos listar su contenido con el método "list()",
        * que devolverá simplemente un array de String. también podemos usar un método más
        * completo como "listFiles()", que ya devuelve un array de objetos File. */
        String [] elementos = carpeta.list();
        for (String elemento:elementos) {
            System.out.println(elemento);

            /* Creamos un objeto File de cada elemento encontrado y usamos el método
            * "isDirectory()" para saber si es una carpeta. En tal caso, listamos el
            * contenido.
            * Para ello usamos el constructor de "File" que espera una ruta padre y un
            * nombre de elemento final.
            *
            * Esto no es recursivo si hay más subcarpetas. Habría que
            * hacerlo de otra forma. */
            File elem = new File(carpeta.getAbsolutePath(),elemento);
            if(elem.isDirectory()) {
                String [] subelementos = elem.list();
                for(String subelem:subelementos){
                    System.out.println(subelem);
                }
            }
        }
    }
}