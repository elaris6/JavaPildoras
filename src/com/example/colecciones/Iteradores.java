package com.example.colecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Iteradores {

    /* ITERADORES
    *
    * Nos permiten manejar colecciones (como por ejemplo ArrayList), pero no se
    * limitan a colecciones ordenadas con un índice como puede ser un ArrayList.
    *
    * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collection.html
    *
    * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html
    *
    * Métodos básicos: hasNext(), next() y remove()
    * */

    public static void main(String[] args) {

        /* Creamos un ArrayList */
        ArrayList<Libro> listaLibros = new ArrayList<>();

        listaLibros.add(new Libro("Autor 1","Título 1",1));
        listaLibros.add(new Libro("Autor 2","Título 2",2));
        listaLibros.add(new Libro("Autor 3","Título 3",3));
        listaLibros.add(new Libro("Autor 4","Título 4",4));

        /* Construimos un iterador, sobre objetos de tipo "Libro" en este caso.
        * Por convención se suele llamar al objeto iterador "it". */
        Iterator<Libro> iterador = listaLibros.iterator();

        /* Recorremos el elemento iterable con el interador.
         * CADA VEZ que usamos el método "next()", el iterador salta un elemento de la
         * colección, y solo entonces poderá gestionar ese elemento, por lo que al
         * invocar métodos sobre un objeto usando el "next()" realmente no estamos
         * analizando el siguiente elemento, sino el que acabamos de saltar al haber
         * usado el "next()".
         *
         * No se pueden gestionar elementos aún no saltados.
         * */
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }

        /* Creamos una coleccion de tipo HashSet y un iterador sobre esta colección. */
        Cliente cliente1 = new Cliente("Cliente 1","0001",20000);
        Cliente cliente2 = new Cliente("Cliente 2","0002",15000);
        Cliente cliente3 = new Cliente("Cliente 3","0003",20000);
        Cliente cliente4 = new Cliente("Cliente 4","0004",20);
        Cliente cliente5 = new Cliente("Cliente 5","0005",17000);
        Cliente cliente6 = new Cliente("Cliente 6","0006",6000);

        Set<Cliente> clientesBanco = new HashSet<>();

        clientesBanco.add(cliente1);
        clientesBanco.add(cliente2);
        clientesBanco.add(cliente3);
        clientesBanco.add(cliente4);
        clientesBanco.add(cliente5);
        clientesBanco.add(cliente6);

        /* No se permite eliminar un objecto de una colección mientras lo recorres
        * con un bucle, pues salta una excepción de tipo "ConcurrentModification Exception".
        * En estos casos debemos acudir a los iteradores. */
        Iterator<Cliente> it = clientesBanco.iterator();

        while (it.hasNext()) {
            Cliente cliTemp = (Cliente) it.next();
            if (cliTemp.getNombre().equals("Cliente 3")) it.remove();
            else System.out.println(cliTemp);
        }

    }
}
