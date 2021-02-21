package com.example.pooAbstractas;

import java.util.Date;
import java.util.EnumMap;

// Siempre que haya al menos un método abstracto en la clase,
// la clase debe ser también abstracta
public abstract class Personas {

    private String nombre;

    public Personas (String nombre) {
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    // Siempre que haya al menos un método abstracto en la clase,
    // la clase debe ser también abstracta
    public abstract String getDescripcion();
}

// Las clases que heredan de una clase abstracta están obligados
// están OBLIGADAS a implementar los métodos abstractos heredados
class Empleados extends Personas implements Comparable, ParaTrabajadores {

    private double sueldo;
    private Date fechaAlta;

    public Empleados(String nombre, double sueldo, Date fechaAlta) {
        super(nombre);
        this.sueldo=sueldo;
        this.fechaAlta=fechaAlta;
    }

    @Override // Esto solo es informativo (se puede borrar) para remarcar que es un método sobreescrito
    public String getDescripcion() {
        return "Nombre: "+this.getNombre()+" Fecha Alta: "+this.fechaAlta+" Sueldo: "+this.sueldo+" €";
    }

    // Incluimos el método "compareTo" de la interfaz "Comparable" que se ha implementado
    // para permitir la comparación entre objetos de clase Empleados por el método "sort" de la
    // clase Arrays.
    @Override
    public int compareTo(Object empleado) {
        Empleados otroEmpleado = (Empleados) empleado;

        // El orden de "sort" siempre es de menor a mayor, pero al final usa el método "compareTo"
        // Podemos cambiar la ordenación devolviendo el negativo para las comparaciones en las que queremos
        // que el objeto a comparar quede primero.
        if (this.sueldo < otroEmpleado.sueldo) return -1;
        else if (this.sueldo > otroEmpleado.sueldo) return 1;
        else return 0;
    }

    @Override
    public double setBonus(double gratificacion) {

        return gratificacion + ParaTrabajadores.BONUS;
    }
}

class Jefes extends Empleados implements ParaJefes{

    private double incentivo;
    private String cargo;

    public Jefes(String nombre, double sueldo, Date fechaAlta) {
        super(nombre, sueldo, fechaAlta);
    }

    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }

    // En este caso la sobreescritura del método ya no es obligatoria,
    // al no heredar un método abstracto
    @Override
    public String getDescripcion() {
        return super.getDescripcion()+ " Incentivo: "+this.incentivo;
    }

    // Al implementar la interfaz "ParaJefes", es obligatorio implementar los métodos heredados
    // setCargo y getCargo
    @Override
    public void setCargo(String cargo) {
        this.cargo=cargo;
    }

    @Override
    public String getCargo() {
        return " Cargo: "+cargo;
    }

    @Override // Sobreescribimos el método heredado de la interfaz "ParaTrabajadores"
    public double setBonus(double gratificacion) {

        double prima = 2000;
        return prima + gratificacion + ParaTrabajadores.BONUS;
    }

}

class Alumnos extends Personas {

    private String a_optativas;
    private String curso;

    public Alumnos(String nombre, String optativas, String curso) {
        super(nombre);
        a_optativas = optativas; // El this no es obligatorio al tener nombres distintos
        this.curso = curso;
    }

    // Estamos obligados a implementar el metodo abstracto heredado
    @Override
    public String getDescripcion() {
        return "Nombre: "+this.getNombre()+" Curso: "+this.curso + " Asig Optativas: "+a_optativas;
    }
}