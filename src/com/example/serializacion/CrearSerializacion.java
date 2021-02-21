package com.example.serializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CrearSerializacion {

    /* SERIALIZACION
     *
     *  Serializar es convertir objetos lógicos de un programa en bytes para almacenarlo.
     * Para ello es imprescindible que el objeto a serializar implemente la interfaz
     * "Serializable".
     *  https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
     *
     * Además necesitaremos las clases "ObjectInputStream" y "ObjectOutputStream" con sus
     * correspondientes métodos "readObject" y "writeObject()", para serializar un objeto y
     * para recuperar/leer un objeto serializado.
     * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/ObjectInputStream.html
     * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/ObjectOutputStream.html
     *
     * */

    public static void main(String[] args) {

        /* Creamos un array de objetos de la clase de ejemplo y lo rellenamos de datos. */
        Cliente[] clientes = new Cliente[5];
        clientes[0] = new Cliente("Cliente1","666777881","cliente1@email.com");
        clientes[1] = new Cliente("Cliente2","666777882","cliente2@email.com");
        clientes[2] = new Cliente("Cliente3","666777883","cliente3@email.com");
        clientes[3] = new Cliente("Cliente4","666777884","cliente4@email.com");
        clientes[4] = new Cliente("Cliente5","666777885","cliente5@email.com");

        try {
            /* Creamos una instancia de "ObjectOutputStream" usando un objeto de tipo
            "FileOutputStream", con la ruta del fichero serializado a crear. */
            ObjectOutputStream ficheroClientes = new ObjectOutputStream(new FileOutputStream("C:/CODE/Java/JavaLearn/src/com/example/serializacion/ficheroAlmacenamiento"));

            /* Podemos serializar directamente el objeto array con todos los clientes,
            * o serializar instancia a instancia. */
            //ficheroClientes.writeObject(clientes);

            for(Cliente cliente:clientes) {
                ficheroClientes.writeObject(cliente);
            }

            ficheroClientes.close();

        }
        catch (IOException e) {
            System.out.println("No se puede generar fichero");
        }

    }
}

/* Clase ejemplo con algunos atributos y métodos. */
class Cliente implements Serializable {

    private static int ID = 1;
    private final String nombre;
    private final int id;
    private String movil;
    private String email;

    Cliente(String nombre,String movil, String email) {

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






