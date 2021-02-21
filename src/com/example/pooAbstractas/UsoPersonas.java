package com.example.pooAbstractas;

import java.util.Arrays;
import java.util.Date;

public class UsoPersonas {

    public static void main(String[] args) {

        /*
            No se pueden crear instancias de una clase abstracta,
            pero si variables de esa clase

            Personas per0 = new Personas("persona"); // ERROR
         */
        Personas per0; //OK

        // Ambos heredan el método getDescripcion de Personas
        Jefes per1 = new Jefes("Ana",2500.5,new Date(917239813451L));
        per1.setCargo("Jefe contabilidad");
        Alumnos per2 = new Alumnos("Maria","Mates, Naturales", "3A");

        System.out.println(per1.getDescripcion()+per1.getCargo());
        System.out.println(per2.getDescripcion());

        Empleados losEmpleados[] = new Empleados[5];

        losEmpleados[0] = new Empleados("Pepe",1550, new Date(12345677890L));
        losEmpleados[1] = new Empleados("Juan",1690, new Date(12345677890L));
        losEmpleados[2] = new Empleados("Antonio",1900, new Date(12345677890L));
        losEmpleados[3] = new Empleados("Paco",1400, new Date(12345677890L));
        losEmpleados[4] = new Empleados("Roberto",1750, new Date(12345677890L));

        // El uso del método "sort" de Arrays nos obliga a implementar la interfaz "Comparable"
        // y su método "compareTo" en la clase Empleados.
        Arrays.sort(losEmpleados);

        for (Empleados empleado:losEmpleados) {
            System.out.println(empleado.getDescripcion());
        }

        Jefes per3 = new Jefes("Manuel", 2700, new Date(234567890L));
        Empleados per4 = new Empleados("Carlos",1800,new Date(3432423444L));

        // Aquí podemos ver el resultado de los distintos métodos "setBonus"
        // para Empleados y Jefes, que han sido heredados de la interfaz "ParaTrabajadores"
        System.out.println("El trabajador "+per3.getNombre()+" tiene un bonus de "+per3.setBonus(600));
        System.out.println("El trabajador "+per4.getNombre()+" tiene un bonus de "+per4.setBonus(600));
    }
}
