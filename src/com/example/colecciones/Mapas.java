package com.example.colecciones;

import java.util.HashMap;
import java.util.Map;

/* MAP
* La interfaz de la colección "Map" es implementada por múltiples clases.
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html
*
* La principal característica de estas colecciones es que trabajan con una asociación
* "clave : valor". Dicha clave será única para cada elemento, no se pueden repetir, pero
* pueden estar vacías.
* Como inconveniente tenemos un uso mayor de recursos que otras colecciones.
*
* Vamos a ver un ejemplo de la clase "HashMap". Ésta no permite ordenación, pero es más
* eficiente que otras clases que implementan la interfaz "Map".
* Métodos principales: "put(K,V)", "V get(Object key)", "remove(Object key)",
* "Set<Map.Entry<K,V>entrySet()".
*
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html
*
* */
public class Mapas {

    public static void main(String[] args) {

        /* Creamos y poblamos el HashMap. No hay orden en este caso. */
        HashMap<String, Empleado> mapaHash = new HashMap<>();

        mapaHash.put("100",new Empleado("Emp0"));
        mapaHash.put("102",new Empleado("Emp2"));
        mapaHash.put("107",new Empleado("Emp7"));
        mapaHash.put("113",new Empleado("Emp13"));
        mapaHash.put("101",new Empleado("Emp1"));

        System.out.println(mapaHash);

        /* Recorrer los elementos del HashMap con un bucle for each, usando
        * el método "entrySet()", que devuelve una interfaz interna de tipo
        * Set "Map.Entry<K,V>", con la que podremos recorrer claves y valores
        * del HashSet. */
        for(Map.Entry<String, Empleado> empleado:mapaHash.entrySet()){
            String key=empleado.getKey();
            Empleado valor= empleado.getValue();
            System.out.println("Clave:"+key+" Valor:"+valor);
        }

        /* Recorrer los valores del HashMap con un bucle for each, usando el
         * método "values()" que devuevle una colección sencilla SOLO con los
         * valores del HashMap. */
        for (Empleado emp:mapaHash.values()){
            System.out.println(emp);
        }

        /* Eliminar un elemento con el método "remove(Object key)". */
        mapaHash.remove("102");

        /* Para sobreescribir un elemento basta con invocar el método "set(K,V)"
        * con la misma key. */
        mapaHash.put("113",new Empleado("EmpTest"));

        System.out.println(mapaHash);




    }
}

class Empleado {

    private String nombre;
    private double salario ;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.salario = 2000.0;
    }

    public String toString() {
        return "Nombre:"+this.nombre+" Salario:"+this.salario;
    }

}
