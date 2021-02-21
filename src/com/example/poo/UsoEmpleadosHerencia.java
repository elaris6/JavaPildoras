package com.example.poo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class UsoEmpleadosHerencia {

    public static void main(String[] args) {

        Empleado emp1 = new Empleado("Juan",1800,2010,1,30);
        Jefe jefe1 = new Jefe("Ana",2200,2006,9,18);

        //System.out.println(jefe1.getFechaAltaFormat());
        //System.out.println(jefe1.getSueldo());
        jefe1.setIncentivo(310.66);
        //System.out.println(jefe1.getSueldo());


        Empleado losEmpleados[] = new Empleado[6];
        losEmpleados[0] = new Empleado("Antonio",2100.5,2005,7,5);
        losEmpleados[1] = new Empleado("Juan",2100.10,2005,3,18);
        losEmpleados[2] = new Empleado("Maria",2200.8,2003,4,11);
        losEmpleados[3] = new Empleado("Susana",2300.9,2011,8,29);
        // Podemos meter un objeto de tipo Jefe en un array de tipo Empleado,
        // por el el principio de sustitución ya que un objeto de tipo Jefe, también es
        // un objeto de tipo Empleado, al ser una subclase. Esto se llama "upcasting" ó casting implícito
        losEmpleados[4] = jefe1;
        losEmpleados[5] = new Jefe("Susana",2500,2014,12,17);

        // Aplicando el principio de sustitución se puede hacer tabmién un "downcasting" o
        // casting explícito, si almacenamos una subclase en una superclase y luego forzamos
        // la conversión indicando el casting "(subclase)" al hacer la asignación
        Empleado persona1 = new Jefe("Personita",1800,2020,9,13);
        Jefe persona2 = (Jefe) persona1;


        // Por el principio de polmorfismo (o enlazado dinámico), el método getSueldo usado
        // será el que corresponda. Se usará el de la clase Empleado, o el de la clase Jefe,
        // según sea la clase del objeto al que aplique.
        for (Empleado empleado:losEmpleados) {
            System.out.println(empleado.getDatosEmpleado()+" Sueldo: "+empleado.getSueldo());
        }
        // Sin embargo, no podemos acceder directamente a un método propio solo de la clase Jefe
        // si lo hacemos desde un objeto definido como si fuese una clase Empleado
        // losEmpleados[5].setIncentivo(275); --> esto es KO
        // jefe1.setIncentivo(350.50); --> esto es OK al ser un objeto de clase Jefe "nativo"
        // Para resolver esto, tendríamos que hacer un downcasting o casting explícito
        Jefe temporal = (Jefe) losEmpleados[5];
        temporal.setIncentivo(220);


    }
}

// Definimos la clase Empleado en el mismo fichero/módulo que la clase main
class Empleado {

    //Propiedades
    //Asignamos el atributo "final" a las propiedades que no deben modificarse,
    //para convertirlas en constantes dentro de la instancia.
    //El atributo "final" también se puede aplicar a clases y métodos.
    private static int ID = 1;
    private final int id;
    private final String NOMBRE;
    private double sueldo;
    private GregorianCalendar fechaAlta;


    //Constructor
    public Empleado(String nombre, double sueldo, int anno, int mes, int dia){
        //Usamos una variable de clase static,
        //para crear un secuencial para el id de empleado
        this.id = ID;
        ID++;
        this.NOMBRE = nombre;
        this.sueldo = sueldo;
        this.fechaAlta = new GregorianCalendar(anno,mes,dia);
    }

    //Setters

    public void setSubeSueldo(double subida){
        this.sueldo += this.sueldo*subida/100;
    }

    //Getters
    public String getDatosEmpleado(){

        //Alternativa a la concatenación normal, con método StringBuilder.append
        return (new StringBuilder().append("\nID Empleado: ").append(this.id).append(" Nombre Empleado: ").append(this.NOMBRE).toString());
    }

    public double getSueldo(){
        return this.sueldo;
    }

    // En este método mantenemos la clase GregorianCalendar, para poder operar con fechas
    public GregorianCalendar getFechaAlta() { return this.fechaAlta; }

    public String getFechaAltaFormat() {
        String date = this.fechaAlta.get(Calendar.DAY_OF_MONTH)+"/"+fechaAlta.get(Calendar.MONTH)+"/"+this.fechaAlta.get(Calendar.YEAR);
        return date;
    }

    public static String getSiguienteId(){
        return "El Id del siguiente empleado será: "+ID;
    }
}

// Esta clase hereda de Emepleado
class Jefe extends Empleado {

    // Propiedad exclusiva de la clase Jefe
    private double incentivo;

    // Constructor heredado de la superclase
    public Jefe(String nombre, double sueldo, int anno, int mes, int dia) {
        super(nombre, sueldo, anno, mes, dia);
    }

    // Setter exclusivo de la clase Jefe
    public void setIncentivo(double importe) {
        this.incentivo = importe;
    }

    // Getter

    // Sobreescritura de métodos y uso del própio método heredado
    // con la palabra reservada "super"
    public double getSueldo () {
        return super.getSueldo() + this.incentivo;
    }
}

// Esta clase hereda de Jefe, pero también de Empleado
// Al agregar el modificador "final", bloqueamos la posibilidad de que sea heredada
final class Director extends Jefe {

    // Atributos específicos de clase
    private boolean cocheEmpresa;
    private boolean casaEmpresa;

    public Director(String nombre, double sueldo, int anno, int mes, int dia) {
        super(nombre, sueldo, anno, mes, dia);
    }

    // Setters
    public void setCocheEmpresa(boolean coche) { this.cocheEmpresa = coche; }

    public void setCasaEmpresa(boolean casa) { this.casaEmpresa = casa; }

    // Getters
    public boolean getCocheEmpresa() { return this.cocheEmpresa; }

    public boolean getCasaEmpresa() { return this.casaEmpresa; }


}

