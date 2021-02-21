package com.example.ejercicios;

public class usoVehiculos {

    public static void main(String[] args) {

        Vehiculos listaVehic [] = new Vehiculos[2];

        listaVehic[0] = new Coche();
        listaVehic[1] = new Moto();

        System.out.println("El número de plazas es: "+listaVehic[0].getPlazas());
        listaVehic[0].setAcelerar(110);
        listaVehic[0].setAcelerar(30);
        listaVehic[0].setFrenar(15);
        listaVehic[0].setFrenar(5);

        System.out.println();

        System.out.println("El número de plazas es: "+listaVehic[1].getPlazas());
        listaVehic[1].setAcelerar(140);
        listaVehic[1].setAcelerar(30);
        listaVehic[1].setFrenar(70);
        listaVehic[1].setAcelerar(90);

    }
}
