package com.example.colecciones;

import java.util.HashSet;
import java.util.Set;

public class ClientesBancarios {

    public static void main(String[] args) {

        // Instanciamos varias veces la clase "Cliente"
        Cliente cliente1 = new Cliente("Cliente 1","0001",20000);
        Cliente cliente2 = new Cliente("Cliente 2","0002",15000);
        Cliente cliente3 = new Cliente("Cliente 3","0003",20000);
        Cliente cliente4 = new Cliente("Cliente 4","0004",20);

        /* Creamos una colección de tipo "Set" porque no queremos elementos repetidos
        * ni en principio queremos, modificarlos ni eliminarlos para este ejemplo.
        *
        * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Set.html
        *
        * En base a lo que queremos hacer en el ejemplo seleccionamos la clase "HashSet"
        * para almacenar los clientes.
        *
        * *https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashSet.html
        * */
        Set <Cliente> clientesBanco = new HashSet<>();

        // Agregamos los elementos a la colección con el método "add(E e)"
        clientesBanco.add(cliente1);
        clientesBanco.add(cliente2);
        clientesBanco.add(cliente3);
        clientesBanco.add(cliente4);

        /* Recorremos y listamos los elementos del HashSet. Nótese que los elementos
        * no están ordenados pues no es una característica de este tipo de colección.
        *
        * Imprimimos también el valor del "hashCode" de cada objeto, que es la
        * referencia en la memoria "Heap" a la que se apunta desde la entrada básica
        * de la memoria "Stack".
        * */
        for(Cliente cliente:clientesBanco){
            System.out.println(cliente+" - hashCode: "+cliente.hashCode());
        }

        /* Si igualamos dos instancias, lo que hacemos es que el hashCode de la
        * primera apunte al de la segunda, siendo literalmente el mismo objeto
        * y no una copia de él. */

        Cliente cliente5 = new Cliente("Cliente 5","0005",17000);
        Cliente cliente6 = new Cliente("Cliente 6","0006",6000);

        cliente5=cliente6;

        System.out.println();
        System.out.println(cliente5+" - hashCode: "+cliente5.hashCode());
        System.out.println(cliente6+" - hashCode: "+cliente6.hashCode());

        /* Si añadimos dos objetos antes de igualarlos a una colección, ésta
        * seguirá manteniendo su referencia previa para el primero de ellos,
        * no se actualiza dinámicamente.
        * En cambio, si añadimos dichos objetos, tras igualar las instancias,
        * la colección detectará que realmente son el mismo objeto y solo
        * añadirá uno de ellos (el que se ha mantenido inalterado), al ser
        * una colección que no permite duplicados.
        *
        * Esto mismo ocurre si sobreescribimos el método hashCode, para que
        * se genere un mismo código si a nivel funcional debemos considerar
        * dos objetos como repetidos. */

        clientesBanco.add(cliente5);
        clientesBanco.add(cliente6);

        System.out.println();
        for(Cliente cliente:clientesBanco){
            System.out.println(cliente+" - hashCode: "+cliente.hashCode());
        }


    }
}

class Cliente {

    private String nombre;
    private String numCuenta;
    private double saldo;

    public Cliente(String nombre, String numCuenta, double saldo) {
        this.nombre = nombre;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString(){
        return "Cliente: "+this.getNombre()+" Cuenta: "+this.getNumCuenta()+" Saldo: "+this.getSaldo();
    }

    // Métodos "equals" y "hasCode" autogenerados por el IDE

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return numCuenta.equals(cliente.numCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numCuenta);
    }*/
}