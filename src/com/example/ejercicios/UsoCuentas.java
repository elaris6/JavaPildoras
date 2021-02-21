package com.example.ejercicios;

import java.util.Random;

public class UsoCuentas {

    public static void main(String[] args) {

        // Uso de la clase CuentaCorriente

        CuentaCorriente cuenta1 = new CuentaCorriente("Alicia Balboa",0);
        CuentaCorriente cuenta2 = new CuentaCorriente("Natalia Balboa",0);
        CuentaCorriente.setIngreso(cuenta1,347.55);
        CuentaCorriente.setReintegro(cuenta2,50);
        CuentaCorriente.setTransfer(cuenta1,cuenta2,200);
        System.out.println(cuenta1.getDatosCuenta());
        System.out.println(cuenta2.getDatosCuenta());
        CuentaCorriente.setIngreso(cuenta2,166.89);
        cuenta2.setIngreso(450);
        cuenta1.setReintegro(150);
        System.out.println(cuenta2.getSaldo());
    }
}


