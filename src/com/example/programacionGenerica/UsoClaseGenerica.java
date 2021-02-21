package com.example.programacionGenerica;

public class UsoClaseGenerica {

    public static void main(String[] args) {

        /* Instanciamos la clase genérica con un objeto de tipo String,
        * le damos un valor con una cadena de texto y solicitamos que
        * se nos devuelva dicho objeto. */
        ClaseGenerica<String> instancia1 = new ClaseGenerica<>();
        instancia1.setObjecto("cadena texto");
        System.out.println(instancia1.getObjeto());

        /* La misma clase genérica puede usarse para instanciar un objeto
        * de la clase custom "Persona", para darle un valor creando a su
        * vez un nuevo objeto de esa clase "Persona" y solicitando que se
        * devuelva el objeto e incluso invocando métodos de esta clase en
        * sobre ese objeto devuelto. */
        ClaseGenerica<Persona> instancia2 = new ClaseGenerica<>();
        instancia2.setObjecto(new Persona("Maria",40));
        System.out.println(instancia2.getObjeto());
        System.out.println(instancia2.getObjeto().getEdad());


    }
}

class Persona implements Comparable{

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /* Sobreescribimos el método "toString()" de la clase cósmica "Object"
    * para que en lugar de imprimir el objeto, se imprima un String custom.*/
    public String toString(){
        return "Persona: "+this.nombre+" con "+this.edad+" años de edad";
    }

    public int getEdad(){
        return this.edad;
    }

    /* Implementamos la interfaz "Comparable" y el método "compareTo()"
    * para el ejemplo de los métodos genéricos. */
    @Override
    public int compareTo(Object o) {
        Persona persona = (Persona) o;
        if (this.edad < persona.edad) {
            return -1;
        }
        else if (this.edad > persona.edad) {
            return 1;
        }
        else return 0;
    }
}