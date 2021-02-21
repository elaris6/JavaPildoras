package com.example.accesoFicherosExternos;

import java.io.File;

public class ManipulacionFicherosExternos {

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

        /* Existen métodos para crear, eliminar, ver atributos... etc */

        /* Para crear por ejemplo un directorio nuevo, crearíamos una instancia de "File" ya con
        * la ruta nueva incluyendo el nombre del nuevo directorio. */

        String ruta = "C:/Users/elaris6/Downloads/temp";
        File nuevoDir = new File(ruta);
        if(nuevoDir.mkdir()) System.out.println("Directorio creado: "+ruta);
        else System.out.println("Directorio NO creado: "+ruta);

        /* De forma similar podemos eliminar un directorio o fichero. En el ejemplo no se
        * elimina al ser un directorio y no estar vacío. */

        ruta = "C:/Users/elaris6/Downloads/Debug Console Enabler 1.32 Steam";
        nuevoDir = new File(ruta);
        if (nuevoDir.delete()) System.out.println("Directorio borrado: "+ruta);
        else System.out.println("Directorio NO borrado: "+ruta);



    }
}
