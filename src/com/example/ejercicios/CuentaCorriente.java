package com.example.ejercicios;

import java.util.Random;

public class CuentaCorriente {

    // Propiedades. Recomendable declararlas como private
    private long numeroCuenta;
    private String titular;
    private double saldo;

    // Constructor
    public CuentaCorriente(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;

        // Num Cuenta con Random
        Random num = new Random();
        this.numeroCuenta = (long) Math.floor(num.nextDouble()*9999999999L);

        //Num Cuenta con Math.random()
        this.numeroCuenta = (long) (Math.random()*99999999999L);
    }

    // Métodos setter para hacer ingresos y reintegros

    public void setIngreso (double importe) { this.saldo += importe; }
    public void setReintegro (double importe) { this.saldo -= importe; }

    // Métodos static equivalentes

    public static void setIngreso (com.example.ejercicios.CuentaCorriente cuenta, double importe) {
        cuenta.saldo += importe;
    }
    public static void setReintegro (com.example.ejercicios.CuentaCorriente cuenta, double importe) {
        cuenta.saldo -= importe;
    }

    // Métodos getter para obtener saldo y todos los datos de la cuenta

    public double getSaldo() { return this.saldo; }
    public String getDatosCuenta() {
        return ("Número de cuenta: "+this.numeroCuenta+"\nTitular: "+this.titular+"\nSaldo: "+this.saldo);
    }

    // Método static para realizar transferencias entre cuentas

    public static void setTransfer(com.example.ejercicios.CuentaCorriente cuentaOrigen, com.example.ejercicios.CuentaCorriente cuentaDestino, double importe) {
        cuentaOrigen.saldo -= importe;
        cuentaDestino.saldo += importe;
    }
}
