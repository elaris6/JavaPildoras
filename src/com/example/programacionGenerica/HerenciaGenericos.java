package com.example.programacionGenerica;

public class HerenciaGenericos {

    public static void main(String[] args) {

        Empleado empleado1;
        Jefe jefe1 = new Jefe("Pepe",2000.0,2016,10,3);

        /* Podemos hacer esta asignación por el principio de sustitución "es un",
        * ya que la clase "Jefe" hereda de "Empleado" y por ello un jefe siempre
        * es un empleado. */
        empleado1=jefe1;

        VariosTipos<Empleado> empleado2;
        VariosTipos<Jefe> jefe2 = new VariosTipos<>();

        /* Con las cláses genéricas el principio de sustitución "es un", no
        * funciona. La siguiente instrucción da error, aunque teóricamente
        * debería aplicar el mismo principio que usando clases normales. */
        //empleado2=jefe2;

        VariosTipos<Empleado> empleado3 = new VariosTipos<>();
        VariosTipos<Jefe> jefe3 = new VariosTipos<>();

        VariosTipos.imprimirTrabajador(empleado3);
        /* Esta sentencia funciona al usar los parámetros comodín en el
        * método "imprimirTrabajadores" */
        VariosTipos.imprimirTrabajador(jefe3);

    }
}

class VariosTipos<T> {

    private T objeto;

    public VariosTipos(){
        objeto = null;
    }

    public void setObjecto(T nuevoValor){
        objeto = nuevoValor;
    }

    public T getObjeto(){
        return objeto;
    }

    /* Creamos un método que trabajará con objetos de tipo "Empleado", pero
    * que como hemos visto antes, si no hacemos nada, en programación genérica
    * no aplica el principio de sustitución.
    *
    * Para solucionarlo, existen los llamads parámetros comodín. En este caso,
    * indicamos con la sintaxis "? extends Emepleado", que el objeto aceptado
    * será de tipo "Empleado" o de cualquier clase que herede de él, haciendo
    * que el método funcione y pueda aplicar el principio de sustitución. */
    public static void imprimirTrabajador(VariosTipos<? extends Empleado> e) {

        System.out.println(e.getObjeto());

    }

}
