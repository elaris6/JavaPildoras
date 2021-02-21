package com.example.programacionGenerica;

public class MetodosGenericos {

    public static void main(String[] args) {

        /* Probamos el método genérico pasando un array de Strings */
        String nombres[] = {"Alicia", "Natalia", "Mari"};
        System.out.println(ExaminaArray.getElementos(nombres));

        /* Probamos el método genérico pasando un array de objetos "Persona" */
        Persona personas [] = {new Persona("Natalia",6),new Persona("Alicia",9),new Persona("Maria",40),new Persona("Israel",41)};
        System.out.println(ExaminaArray.getElementos(personas));

        /* Probamos el método getMenor con el array de Strings, que son
        * objetos comparables.
        * Podríamos hacerlo con personas, si la clase "Persona" implementa
        *  la interfaz "Comparable". (hecho) */
        System.out.println(ExaminaArray.getMenor(nombres));

        System.out.println(ExaminaArray.getMenor(personas));

    }
}

class ExaminaArray {

    /* Creamos un método genérico que recibe un array de un tipo genérico y
    * devuelve un String con el número de elementos de dicho array.
    *
    * Los métodos genéricos se pueden crear en clases genéricas o en clases
    * normales no genéricas. */
    public static <T> String getElementos(T[] arrayEntrada){

        return "El array tiene "+arrayEntrada.length+" elementos.";
    }

    /* Creamos un método genérico que emplea a su vez el método "compareTo()"
    * de la interfaz "Comparable", para ir comparando los elementos de un array
    * de objetos genéricos y devolver el menor de ellos.
    *
    * Sólo se puede usar el método "compareTo()" con clases que implementen la
    * interfaz "Comparable" y como nuestro objeto genérico no sabemos de que clase
    * es, debemos indicar que será de una clase que la implementará.
    * Usamos "extends" y no "implements" a pesar de ser una interfaz, porque la
    * clase del objeto genérico ya implementará "Comparable" de por si, y lo que
    * nosotros indicamos es que nuestro objeto genérico de cualquier forma hereda
    * de esta interfaz.
    *  */
    public static <T extends Comparable> T getMenor(T[] arrayEntrada) {

        T objetoMenor = arrayEntrada[0];

        for (int i=1;i<arrayEntrada.length;i++) {
            /* "compareTo()" devuelve 0 si los objetos comparados son iguales,
            * devuelve un valor negativo si el objeto principal es menor, y
            * devuelve un valor positivo si el objeto principal es mayor. */
            if(objetoMenor.compareTo(arrayEntrada[i])>0) {

                objetoMenor=arrayEntrada[i];
            }

        }
        return objetoMenor;

    }
}
