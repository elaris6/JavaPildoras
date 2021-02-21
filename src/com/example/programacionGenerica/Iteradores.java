package com.example.programacionGenerica;

import java.util.ArrayList;
import java.util.Iterator;

public class Iteradores {

    /* ITERADORES
    *
    * Nos permiten manejar colecciones (como por ejemplo ArrayList), pero no se
    * limitan a colecciones ordenadas con un índice como puede ser un ArrayList.
    *
    * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html
    *
    * Métodos básicos: hasNext(), next() y remove()
    *
    * Cada vez que usamos el método "next()", el iterador salta un elemento de la
    * colección, y solo entonces poderá gestionar ese elemento. No se pueden gestionar
    * elementos siguientes.
    * */
    public static void main(String[] args) {

        /* Creamos un ArrayList */
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        listaEmpleados.add(new Empleado("Antonio",2100.5,2005,7,5));
        listaEmpleados.add(new Empleado("Juan",2100.10,2005,3,18));
        listaEmpleados.add(new Empleado("Maria",2200.8,2003,4,11));
        listaEmpleados.add(new Empleado("Susana",2300.9,2011,8,29));

        /* Construimos un iterador, sobre objetos de tipo "Empleado" en este caso */
        Iterator<Empleado> iterador = listaEmpleados.iterator();

        /* Recorremos el elemento iterable con el interador */
        while (iterador.hasNext()) System.out.println(iterador.next().getDatosEmpleado());


    }
}
