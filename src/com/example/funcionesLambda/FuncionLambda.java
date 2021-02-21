package com.example.funcionesLambda;


import java.util.ArrayList;

/* Son funciones/métodos anónimos. También se les denomina
* "cierres" o "clousures".
* Implementan un método definido en una interfaz funcional
* (interfaz con un único método).
* Sirven para simplificar el código a la hora de usar expresiones
* comunes.
* Sintaxis: (parámetros) -> {cuerpo-lambda}
* Si hay uno o ningún parámetro los paréntesis son opcionales, y
* si en el cuerpo solo hay una línea, se pueden omitir las llaves.
* */
public class FuncionLambda {

    public static void main(String[] args) {

        ArrayList<Empleados> listaEmpleados = new ArrayList<>();

        listaEmpleados.add(new Empleados("Empq1",1200));
        listaEmpleados.add(new Empleados("Empq2",2700));
        listaEmpleados.add(new Empleados("Empq3",1800));
        listaEmpleados.add(new Empleados("Empq4",1100));
        listaEmpleados.add(new Empleados("Empq5",2000));

        /* Ordenamos la lista, gracias a haber implementado la interfaz Comparable. */
        //Collections.sort(listaEmpleados);

        /* Realizamos la comparación con el método sort, pero con la variante que
        * permite informar como parámetro un comparador, y en ese comparador es donde
        * construimos la función lambda.
        * Como el método "compareTo" solo puede comparar objetos, hacemos que el getter
        * "getSalario()" nos devuelva un objeto de tipo "Double" en lugar de un
        * primitivo "double".
        * */
        //Collections.sort(listaEmpleados,(Empleados e1,Empleados e2) -> e1.getSalario().compareTo(e2.getSalario()));

        //for(Empleados emp:listaEmpleados) System.out.println("Nombre: "+emp.getNombre()+" Salario: "+emp.getSalario());

        /* La clase "ArrayList" implementa la interfaz "Collection", que tiene un método
        * llamado "stram()" que devuelve un objeto "Stream" de la colección sobre la que
        * se invoca.
        * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collection.html
        *
        * A partir de Java 8, usando la interfaz "Stream" podemos concatenar operaciones
        * y aplicar varias funciones consecutivas sobre la lista de objetos.
        * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html
        * */
        listaEmpleados
                .stream()
                .sorted((e1,e2)->e1.getSalario().compareTo(e2.getSalario()))
                .filter((Empleados e)->e.getSalario()>1900)
                .forEach((Empleados)->System.out.println(Empleados.getNombre()+" "+Empleados.getSalario()));

        /* Un ejemplo más sencillo.
        * Usando funciones lambda podemos también aplicar una función sobre cada uno
        * de los objetos de la lista con el método "forEach". */
        listaEmpleados.forEach((Empleados e)-> e.setSalario(e.getSalario()*2));
        listaEmpleados.forEach((Empleados e)-> System.out.println(e.getNombre()+" "+e.getSalario()));

    }
}

class Empleados {
    String nombre;
    double salario;

    public Empleados (String nombre, double salario){
        this.nombre=nombre;
        this.salario=salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* Como el método "compareTo" solo puede comparar objetos, hacemos que el getter
     * "getSalario()" nos devuelva un objeto de tipo "Double" en lugar de un
     * primitivo "double". */
    public Double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    /*
    // Sustituimos el método "compareTo" que construiríamos a mano, por una función lambda
    @Override
    public int compareTo(Object o) {
        Empleados empTemp = (Empleados) o;
        if(this.salario > empTemp.getSalario()) {
            return 1;
        }
        else if (this.salario < empTemp.getSalario()) {
            return -1;
        }
        else return 0;
    }*/
}
