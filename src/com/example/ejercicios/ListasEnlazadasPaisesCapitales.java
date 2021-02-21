package com.example.ejercicios;

import java.util.LinkedList;
import java.util.ListIterator;

/* Se deben crear dos listas enlazadas, una con países y otra con sus capitales.
*
* El ejercicio consiste en agregar los elementos de las captitales a continuación
* de su país en la lista enlazada de países.
* Además, deberemos eliminar las posiciones pares de la lista de capitales. */
public class ListasEnlazadasPaisesCapitales {

    public static void main(String[] args) {

        LinkedList<String> paises = new LinkedList<>();

        paises.add("España");
        paises.add("Francia");
        paises.add("Portugal");
        paises.add("Italia");
        paises.add("Alemania");
        paises.add("Bélgica");

        LinkedList<String> capitales = new LinkedList<>();

        capitales.add("Madrid");
        capitales.add("París");
        capitales.add("Lisboa");
        capitales.add("Roma");
        capitales.add("Berlin");
        capitales.add("Bruselas");

        /* Intercalar paises con sus capitales */
        System.out.println("Parte 1 de la práctica.\n");
        ListIterator itPaises = paises.listIterator();
        ListIterator itCapitales = capitales.listIterator();

        while (itPaises.hasNext()){
            itPaises.next();
            /* Al realizar la inserción con el método "add", además el iterador
            * se posiciona tras el nuevo elemento insertado. */
            itPaises.add(itCapitales.next());

        }

        System.out.println(paises);

        /* Eliminación de las posiciones pares de la lista enlazada de capitales. */
        System.out.println("\nParte 2 de la práctica.\n");
        // Inicializamos de nuevo el iterador, para que vuelva al inicio de la lista
        itCapitales = capitales.listIterator();

        // Mi solución funciona, pero es más enrevesada
        /*int eliminados=0;
        while (itCapitales.hasNext()){

            if ((itCapitales.nextIndex()+1+eliminados)%2 == 0) {
                itCapitales.next();
                itCapitales.remove();
                eliminados++;
            }
            else itCapitales.next();
        }*/

        // Solución del curso. Salta dos elementos cada vez, y borra:
        while (itCapitales.hasNext()){
            itCapitales.next();
            if (itCapitales.hasNext()){
                itCapitales.next();
                itCapitales.remove();
            }
        }

        System.out.println(capitales);
    }
}
