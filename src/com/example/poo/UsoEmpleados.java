package com.example.poo;

public class UsoEmpleados {

    public static void main(String[] args) {

        Empleados empleado1 = new Empleados("Pepe Pérez");
        Empleados empleado2 = new Empleados("Ana López");
        Empleados empleado3 = new Empleados("María Sánchez");

        System.out.println(empleado1.getDatosEmpleado());
        empleado1.setSeccion("SALES");
        System.out.println(empleado1.getDatosEmpleado());

        System.out.println(empleado2.getDatosEmpleado());

        System.out.println(empleado3.getDatosEmpleado());

        System.out.println(Empleados.getSiguienteId());

        Empleados.setSeccion(empleado3,"BO");

        System.out.println(empleado3.getDatosEmpleado());
    }
}
// Definimos la clase Empleados en el mismo fichero/módulo que la clase main
class Empleados {

    //Propiedades
    //Asignamos el atributo "final" a las propiedades que no deben modificarse,
    //para convertirlas en constantes dentro de la instancia.
    //El atributo "final" también se puede aplicar a clases y métodos.
    private static int ID = 1;
    private final int id;
    private final String NOMBRE;
    private String seccion;

    //Constructor
    public Empleados(String nombre){
        //Usamos una variable de clase static,
        //para crear un secuencial para el id de empleado
        this.id = ID;
        ID++;
        this.NOMBRE = nombre;
        this.seccion = "ADMIN";
    }

    //Setters

    public void setSeccion(String seccion){
        this.seccion = seccion;
    }

    public static void setSeccion(Empleados empleado,String seccion){
        empleado.seccion = seccion;
    }

    //Getters
    public String getDatosEmpleado(){

        //Alternativa a la concatenación normal, con método StringBuilder.append
        return (new StringBuilder().append("ID Empleado: ").append(this.id).append("\nNombre Empleado: ").append(this.NOMBRE).append("\nSección Empleado: ").append(this.seccion).toString());
    }

    public static String getSiguienteId(){
        return "El Id del siguiente empleado será: "+ID;
    }
}
