package com.example.programacionGenerica;

import java.io.File;

public class EjemploProgramacionGenerica {

    public static void main(String[] args) {

        /* Uso de nuestra clase simulando un ArrayList custom*/
        MiArrayList listaElementos = new MiArrayList(6);

        // Agregamos varios elementos de tipo String
        listaElementos.addObject("String 0");
        listaElementos.addObject("String 1");
        listaElementos.addObject("String 2");
        listaElementos.addObject("String 3");
        listaElementos.addObject("String 4");
        /* Agregamso un elemento de tipo File, y esto se permite, pero
         no podemos incrementar de forma dinámica el array. Tendríamos
        que hacer nosostros manualmente la tarea de detectar la excepción,
        copiar el array y demás, que es complejo. */
        listaElementos.addObject(new File("fichero.txt"));

        /* La gestion requiere de anticipar que tipo de objeto será
        * devuelto y gestionarlo mediante casting contínuamente. */
        String s = (String) listaElementos.getObject(2);
        System.out.println(s);

        File fichero = (File)listaElementos.getObject(5);
        System.out.println(fichero);

    }
}

/* Vamos a crear una clase imaginando que no existe la clase ArrayList, para
* crear nuestra propia implementación de la misma sin programación genérica. */
class MiArrayList {

    private Object[] listaObjetos;

    private int i=0;

    // Constructor para crear el array de la dimensión deseada
    public MiArrayList(int size){

       listaObjetos = new Object[size];
    }

    // Devuelve el elemento alamacenado en el índice index
    public Object getObject(int index){

        return this.listaObjetos[index];
    }

    public void addObject(Object o){
        listaObjetos[i]=o;
        i++;
    }
}
