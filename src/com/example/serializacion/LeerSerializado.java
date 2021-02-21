package com.example.serializacion;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerSerializado {

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

        Cliente cliente;
        Cliente[] clientes;
        Cliente[] clientes2 = new Cliente[10];
        int contador = 0;

        try {
            /* Creamos una instancia de "ObjectInputStream" usando un objeto de tipo
            "FileInputStream", con la ruta del fichero serializado a leer. */
            ObjectInputStream ficheroClientes = new ObjectInputStream(new FileInputStream("C:/CODE/Java/JavaLearn/src/com/example/serializacion/ficheroAlmacenamiento"));

            /* Tenemos que saber de antemano el tipo de objeto que contendrá el fichero
            * serielizado, ya que será necesario almacenarlo en un objeto del mismo
            * tipo.
            *
            * En este caso del ejemplo tenemos las variantes de leer un objeto serializado
            * de tipo array de Clientes, o varios objetos Cliente serializados por
            * separado. */

            /*
            // Lectura de un objeto array de Cliente
            clientes=(Cliente[]) ficheroClientes.readObject();

            ficheroClientes.close();

            for (Cliente cliente:clientes) {
                cliente.getDatosCliente();
            }
            System.out.println("Número de clientes: "+clientes.length);*/

            // Lectura de objetos Cliente independientes. Como nos sabemos cuantos
            // hay, los almacenamos en un array sobredimensionado para el ejemplo.
            clientes2[contador] = (Cliente) ficheroClientes.readObject();
            while (clientes2[contador] != null){
                //clientes2[contador].getDatosCliente();
                contador++;
                try {
                    clientes2[contador] = (Cliente) ficheroClientes.readObject();
                }
                catch (EOFException e) {
                    break;
                }

            }
            System.out.println("Número de clientes: "+clientes2.length);

        }
        catch (IOException e) {
            System.out.println("No se puede leer el fichero.");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("La clase a importar no está soportada.");
        }

    }
}
