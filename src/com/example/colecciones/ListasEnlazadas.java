package com.example.colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

/* LINKED LIST
*
* Usadas con iteradores son un tipo de colección muy potente como solución general,
* debido a sus ventajas:
* - acceso aleatorio
* - están ordenadas (collecion.sort())
* - se permite añadir/eliminar sin restricción en el lugar que se desee
* - ListIterator modifica en cualquier dirección
* - Sintaxis similar a arrays
*
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ListIterator.html
* */
public class ListasEnlazadas {

    public static void main(String[] args) {

        // Creamos una lista enlazada de objetos de tipo String
        LinkedList<String> nombres = new LinkedList<>();

        nombres.add("Pepe");
        nombres.add("Juan");
        nombres.add("Jorge");
        nombres.add("Paco");
        nombres.add("Manuel");
        nombres.add("Daniel");

        System.out.println("Número de objetos de la lista enlazada: "+nombres.size());

        // Creamos un iterador de tipo "ListIterator"
        ListIterator it = nombres.listIterator();

        /* Agregamos un nuevo nombre en una posición en concreto. Para ello usaremos
        * el método "add()" del objeto "ListIterator", y no el del objeto "LinkedList",
        * pues si no lo añadiríamos siempre al final. */
        it.next();
        it.add("Rubén");

        /* También podemos agregar un elemento en una posición específica con el
        * constructor adicional del método "add()" de la "LinkedList". */
        nombres.add(4,"Jesús");

        for(String nombre:nombres){
            System.out.println(nombre);
        }


    }
}


