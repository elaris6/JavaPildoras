package com.example.programacionGenerica;

import java.util.ArrayList;

public class ArrayList2 {

    /* ARRAYLIST
     *
     * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html
     *
     * Un "arraylist" puede almacenar diferentes tipos de objetos (mezclados incluso si se
     * indica un tipo de objeto que comprenda todos los tipos posibles esperados), puede crecer
     * dinámicamente, pero no puede contener de forma directa tipos de datos primitivos
     * como int, char, string... etc. Para esto se usará lo que se conoce como clase
     * envoltorio. */

    public static void main(String[] args) {

        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        listaEmpleados.add(new Empleado("Antonio",2100.5,2005,7,5));
        listaEmpleados.add(new Empleado("Juan",2100.10,2005,3,18));
        listaEmpleados.add(new Empleado("Maria",2200.8,2003,4,11));
        listaEmpleados.add(new Empleado("Susana",2300.9,2011,8,29));

        for (Empleado empleado:listaEmpleados) {
            System.out.println(empleado.getDatosEmpleado() + " Sueldo: " + empleado.getSueldo());
        }

        /* Metodos importantes para el manejo habitual de ArrayList:
        *
        * - size(). Obtenemos el número de elementos del arraylist (no su tamaño real, pues
        * podría tener más espacio reservado en memoria).
        * - get(int index). Obtener el elemento de una posición concreta, que puede ser de
        * de cualquier clase.
        * - set(int index, E element). Sobreescribir una posición concreta con un nuevo elemento.
        * - remove(int index). Eliminar el elemento de una posición concreta.
        * - ensureCapacity(int cap), que otorgará una nueva capcidad en memoria al arraylist,
        * para evitar la operación de creación y copiado si se conoce de antemano el tamaño
        * nuevo necesario.
        * - trimToSize(), que elimina las posiciones de memoria no usadas en un arraylist.
        * - toArray(), copia los elemenos de un arraylist en un array convencional. */

        System.out.println(listaEmpleados.size());

        System.out.println(listaEmpleados.get(1).getDatosEmpleado());
        /* Al borrar un elemento del arraylist, los índices se ajustan para seguir
         * siendo correlativos. */
        listaEmpleados.remove(1);
        System.out.println(listaEmpleados.get(1).getDatosEmpleado());

        /* Tras borrar un elemento, el tamaño del arraylist pasa a ser 3
         automáticamente, aunque en memoria se habrá quedado el hueco libre. */
        System.out.println(listaEmpleados.size());

        /* Si sabemos que no vamos a necesitar el hueco de memoria libre que se
        * ha liberado, usaremos el método "trimToSize()" */
        listaEmpleados.trimToSize();

        /* El método "set" sobreescribe tal cual la posición indicada del arraylist con
        * el nuevo elemento. */
        listaEmpleados.set(1,new Empleado("Israel",1999.9,2011,4,1));

        /* Recorrer un arraylist con un bucle for convencional */
        for (int i=0;i<listaEmpleados.size();i++) {
            System.out.println(listaEmpleados.get(i).getDatosEmpleado()+ " Sueldo: " + listaEmpleados.get(i).getSueldo());
        }

        /* Convertir arrylist en un array ordinario */
        Empleado arrayEmpleados[] = new Empleado[listaEmpleados.size()];
        arrayEmpleados = (Empleado[]) listaEmpleados.toArray();
    }
}
