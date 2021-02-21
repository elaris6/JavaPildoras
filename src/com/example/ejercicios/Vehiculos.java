package com.example.ejercicios;

import javax.swing.*;

public class Vehiculos implements InterfazVehiculos {

    protected int plazas;
    private int velocidadActual;

    @Override
    public int getPlazas() {
        return this.plazas;
    }

    @Override
    public void setAcelerar(int velocidad) {
        this.velocidadActual += velocidad;
        System.out.println("Acelerando! --> Velocidad actual: "+this.velocidadActual);
        if (this.velocidadActual > InterfazVehiculos.VELOCIDAD_MAXIMA) {
            System.out.println("Se ha rebasado la velocidad máxima permitida!");
        }
    }

    @Override
    public void setFrenar(int velocidad) {
        int velocidadPrevia = this.velocidadActual;
        this.velocidadActual -= velocidad;
        System.out.println("Frenando! --> Velocidad actual: "+this.velocidadActual);
        if (velocidadPrevia > InterfazVehiculos.VELOCIDAD_MAXIMA && this.velocidadActual <= InterfazVehiculos.VELOCIDAD_MAXIMA) {
            System.out.println("Se ha recuperado una velocidad permitida.");
        }
        else if (velocidadPrevia > InterfazVehiculos.VELOCIDAD_MAXIMA && this.velocidadActual > InterfazVehiculos.VELOCIDAD_MAXIMA) {
            System.out.println("La velocidad sigue siendo superior a la permitida!");
        }
    }

    public int getVelocidadActual(){
        return this.velocidadActual;
    }
}

class Coche extends Vehiculos {

    public Coche() {
        this.plazas = 5;
    }
}

class Moto extends Vehiculos {

    public Moto() {
        this.plazas = 2;
    }
}