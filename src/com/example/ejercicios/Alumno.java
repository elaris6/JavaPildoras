package com.example.ejercicios;

public class Alumno {

    //Propiedades
    private String colegio;
    private String nombre;
    private double nota;
    private int id;
    public static int id_alumnos = 0;
    private boolean expulsado;
    public static Alumno alumnos[] = new Alumno [1000];

    public Alumno (String colegio,String nombre,double nota){
        this.id = Alumno.id_alumnos;
        this.nombre = nombre;
        this.nota = nota;
        this.colegio = colegio;
        alumnos[id_alumnos] = this;
        id_alumnos++;
    }

    //Getters

    public int getId() {
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }
    public double getNota(){
        return this.nota;
    }
    public String getColegio(){
        return this.colegio;
    }
    public boolean getExpulsado(){
        return this.expulsado;
    }


    //Setters
    public void setExpulsado(boolean expulsado){
        this.expulsado=expulsado;
    }
    public void setNota(double nota) {
        this.nota=nota;
    }


}
