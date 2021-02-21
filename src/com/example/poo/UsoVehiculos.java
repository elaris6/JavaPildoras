package com.example.poo;

public class UsoVehiculos {

    public static void main(String[] args) {

        Vehiculos coche1 = new Vehiculos(4,250,170,1200,"");
        System.out.println(coche1.getDatosVehiculo());
        coche1.setColor("rojo");
        System.out.println(coche1.getColor());
        coche1.setExtra(true);
        System.out.println(coche1.getExtra());
        coche1.setExtra(false,true,true);
        System.out.println(coche1.getExtra());

        //Usamos otro constructor
        Vehiculos coche2 = new Vehiculos("blanco");
        System.out.println(coche2.getDatosVehiculo()+"\n"+coche2.getExtra());
    }
}
