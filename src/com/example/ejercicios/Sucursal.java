package com.example.ejercicios;

public class Sucursal {

    // Propiedades
    private int numSucursal;
    private String direccion;
    private String ciudad;
    private double costeEnvio;

    public Sucursal(int numSucursal,String direccion, String ciudad, double costeEnvio) {

        this.numSucursal = numSucursal;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.costeEnvio = costeEnvio;
    }

    // Getters

    public int getNumSucursal() { return this.numSucursal; }

    public String getDireccion() { return this.direccion; }

    public String getCiudad() { return this.ciudad; }

    // Método calcula precio

    public double calculaPrecio(Paquete paquete) {

        switch (paquete.getPrioridad()) {

            case 0:
                return paquete.getPeso() * this.costeEnvio;
            case 1:
                return (paquete.getPeso() * this.costeEnvio) + 10;
            case 2:
                return (paquete.getPeso() * this.costeEnvio) + 20;
            default:
                System.out.println("Prioridad incorrecta");
                return 0;
        }
    }
}
