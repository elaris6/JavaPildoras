package com.example.ejercicios;

public class Paquete {

    // Propiedades

    private int referencia;
    private double peso;
    private String dni;
    private byte prioridad;

    public Paquete(int referencia, double peso, String dni, byte prioridad) {
        this.referencia = referencia;
        this.peso = peso;
        this.dni = dni;
        this.prioridad = prioridad;
    }

    // Getters

    public int getRef() { return this.referencia; }

    public double getPeso() { return this.peso; }

    public byte getPrioridad() { return prioridad; }

    // Setters

    public void setPeso(double peso) { this.peso = peso; }

    public void setPrioridad(byte prioridad) { this.prioridad = prioridad; }
}
