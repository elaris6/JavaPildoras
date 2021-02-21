package com.example.colecciones;


import java.util.Comparator;
import java.util.TreeSet;

/* SET - TREE SET
*
* Como parte de las colecciones de tipo SET, cuenta con las siguientes ventajas y desventajas:
*
* - No permiten elementos duplicados
* - Uso sencillo del método add, que además asegura que no se permitan duplicados si se
* customiiza el método "hashCode".
*
* - No tiene acceso aleatorio, hay que recorrer los elementos para llegar a uno concreto
* - Poca eficiencia para ordenar elementos (y no siempre se puede)
*
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Set.html
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/TreeSet.html
* */
public class ArbolTreeSet {

    public static void main(String[] args) {

        /* Los elementos de un TreeSet se ordenan ellos solos en función del resultado
        * del método "compareTo()". Por ejemplo si almacenamos String, se ordenarán
        * alfabéticamente. Si almacenamos una clase custom, deberemos sobreescribir
        * el método "compareTo()" para que la ordenación sea funcionalmente correcta
        * (y hacer que implemente la interfaz "Comparable").
        *
        * IMPORTANTE: La interfaz "Comparable" nos ayudará a ordenar los elementos
        * siempre de forma natural. Es decir, numéricos o alfabéticos en un sentido
        * deseado. Para realizar ordenaciones "no naturales", deberemos hacer uso de
        * la interfaz "Comparator".
        * Como son interfaces, se podrían implementar ambas en la misma clase sin
        * problemas.
        * Al implementar cualquiera de las dos interfaces, se considera una buena
        * práctica sobreescribir el método equals, para hacerlo coherente. */
        System.out.println("TreeSet con ordenación por defecto.");
        TreeSet<String> ordenaNombres = new TreeSet<>();

        ordenaNombres.add("Isra");
        ordenaNombres.add("Mari");
        ordenaNombres.add("Alicia");
        ordenaNombres.add("Natalia");

        for(String p:ordenaNombres) {
            System.out.println(p);
        }

        /* Ejemplo de TreeSet con clase custom "Productos", en la que se ha
        * implementado la interfaz "Comparable" y el método "compareTo()"
        * permitiendo realmente ordenar los productos al TreeSet de forma
        * esperada (por numProducto de menor a mayor en este caso).  */
        System.out.println("TreeSet con ordenación natural custom.");
        TreeSet<Productos> arbolProductos = new TreeSet<>();

        arbolProductos.add(new Productos(7,"producto 7"));
        arbolProductos.add(new Productos(2,"producto 2"));
        arbolProductos.add(new Productos(4,"producto 4"));
        arbolProductos.add(new Productos(0,"producto 0"));

        for(Productos p:arbolProductos) {
            System.out.println(p.getDescripcion());
        }

        /* Ejemplo de TreeSet con clase custom "Persona", en la que se ha
        * implementado la interfaz "Comparator" y el método "compare", con
        * el fin de realizar una ordenación funcional no natural (longitud
        * de caracteres del nombre + edad). */
        System.out.println("TreeSet con ordenación no natural.");
        Comparator<Persona> comparador = new Persona();
        TreeSet<Persona> arbolPersonas = new TreeSet<>(comparador);

        arbolPersonas.add(new Persona("Isra",41));
        arbolPersonas.add(new Persona("Mari",40));
        arbolPersonas.add(new Persona("Alicia",9));
        arbolPersonas.add(new Persona("Natalia",6));

        for(Persona p:arbolPersonas) {
            System.out.println(p.getNombre());
        }
    }
}

/* Clase Prodcutos que implementa interfaz "Comparable" para hacer ordenación
* natural. Se debe indicar la clase sobre la que aplicaremos la ordenación,
* en el argumento del parámetro genérico.
*
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Comparable.html
*  */
class Productos implements Comparable <Productos> {

    private int numProducto;
    private String descripcion;

    public Productos(int numProducto, String descripcion) {
        this.numProducto = numProducto;
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    /* Debe devolver un número negativo si el objeto con el que se compara es mayor,
    * cero si son iguales, y un número positivo si el objeto con el que se compara
    * es menor.
    * Se debe indicar la clase sobre la que haremos la comparación en el argumento
    * del método. */
    @Override
    public int compareTo(Productos p) {
        if (this.numProducto > p.numProducto) return 1;
        else if (this.numProducto < p.numProducto) return -1;
        else return 0;
    }
}

/* Clase Persona que implementa la interfaz "Comparator", para implementar una
* ordenación "no natural" mediante el método "compare".
* La ordenación no natural es una ordenación funcional inventada en base a los
* requerimientos del programa.
*
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Comparator.html
* */
class Persona implements Comparator<Persona> {

    private String nombre;
    private int edad;

    public Persona(){}

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getEdad(){
        return this.edad;
    }

    @Override
    public int compare(Persona p1, Persona p2) {

        if (p1.getNombre().length()+p1.edad > p2.getNombre().length()+p2.edad) return 1;
        else if (p1.getNombre().length()+p1.edad < p2.getNombre().length()+p2.edad) return -1;
        else return 0;
    }
}