package com.example.serializacion;

import java.io.Serializable;

public class SerialVersionUID {

    public static void main(String[] args) {

    }
}


/* Clase ejemplo con algunos atributos y métodos. */
class Empleado implements Serializable {

    /* "serialVersionUID" es un atributo de las clases serializables, que indica
    * la versión de esa clase, de forma que al serializarse se graba la versión
    * con la que se ha serializado, y al leerse, la versión de lectura debe
    * coincidir, o el sistema arrojará un error por este motivo.
    *
    * El compilador genera un "serialVersionUID" automáticamente si no lo hacemos
    * de forma manual. Puede hacerse de forma manual, y usarlo exactamente como
    * un control de versión de clase.
    *
    * Al modificar una clase de cualquier manera, deberemos considerar si se debe
    * modificar la versión de dicha clase y caso afirmativo, tener en cuenta que
    * será necesario actualizar el programa con los cambios en caso de que la
    * des-serialización se haga en otra ubicación o sistema. */

    // serialVersionUID auto-generado:
    private static final long serialVersionUID = -2504175345513999252L;

    // serialVersionUID custom:
    //private static final long serialVersionUID = 1L;

    private static int ID = 1;
    private final String nombre;
    private final int id;
    private String movil;
    private String email;

    Empleado(String nombre,String movil, String email) {

        this.id = ID;
        ID++;
        this.nombre = nombre;
        this.movil = movil;
        this.email = email;
    }

    public void getDatosCliente() {
        System.out.println("Id: "+this.id+" Nombre: "+this.nombre+" Móvil: "+this.movil+" Email: "+this.email);
    }

    public void setMovil(String movil){
        this.movil=movil;
    }

    public void setEmail(String email){
        this.email=email;
    }

}