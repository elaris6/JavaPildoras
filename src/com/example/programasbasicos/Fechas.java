package com.example.programasbasicos;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fechas {

    public static void main(String[] args) {


        GregorianCalendar fecha = new GregorianCalendar(2020,10,27);

        System.out.println("Fecha en formato GregorianCalendar: "+fecha);
        String fecha_format = "Fecha formateada con métodos de la clase GregorianCalendar: "+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.YEAR);
        System.out.println(fecha_format);

    }
}
