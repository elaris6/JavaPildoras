package com.example.ejercicios;

public class Colegio {

    //Propiedades
    private final String nombre;
    private int maxAlumnos;

    //Constructor
    public Colegio (String nombre,int maxAlumnos){
        this.nombre = nombre;
        this.maxAlumnos = maxAlumnos;
    }

    //Métodos

    public void nuevoAlumno(String nombreAlumno, double nota){
        int numAlumnos = 0;
        for (int i=0;i<Alumno.id_alumnos;i++){
            if(Alumno.alumnos[i].getColegio().equals(this.nombre)) numAlumnos++;
        }
        Alumno alumno;
        if (numAlumnos < this.maxAlumnos)
            alumno = new Alumno(this.nombre,nombreAlumno,nota);
        else System.out.println("Error: El colegio está lleno.");

    }

    public void setNotaMedia (String nombre,double nota){
        for (int i=0;i<Alumno.id_alumnos;i++){
            if(Alumno.alumnos[i].getColegio().equals(this.nombre) && Alumno.alumnos[i].getNombre().equals(nombre)) {
                Alumno.alumnos[i].setNota(nota);
                break;
            }
        }
    }

    public void expulsaAlumno (String nombre){
        for (int i=0;i<Alumno.id_alumnos;i++){
            if(Alumno.alumnos[i].getColegio().equals(this.nombre) && Alumno.alumnos[i].getNombre().equals(nombre)) {
                Alumno.alumnos[i].setExpulsado(true);
                break;
            }
        }
    }
    /*
    public void getDatosAlumno (String nombre) {
        for (int i=0;i<Alumno.id_alumnos;i++){
            if(this.nombre.equals(Alumno.alumnos[i].getColegio()) && Alumno.alumnos[i].getNombre().equals(nombre)) {
                System.out.println("\nId: "+i+"\nColegio: "+Alumno.alumnos[i].getColegio()+"\nNombre: "+nombre
                        +"\nNota: "+Alumno.alumnos[i].getNota()+"\nExpulsado: "+Alumno.alumnos[i].getExpulsado());
                break;
            }
        }
    }

    public void getTodosAlumnos(){
        // Lista todos los alumnos de un colegio exceptuando los expulsados
        for (int i=0;i<Alumno.id_alumnos;i++){
            if(Alumno.alumnos[i].getColegio().equals(this.nombre) && !Alumno.alumnos[i].getExpulsado()) {
                System.out.println("\nId: "+i+" Colegio: "+Alumno.alumnos[i].getColegio()+" Nombre: "+Alumno.alumnos[i].getNombre()
                        +" Nota: "+Alumno.alumnos[i].getNota()+" Expulsado: "+Alumno.alumnos[i].getExpulsado());
            }
        }
    }*/
    /*
    public void setNotaMedia (String nombre,double nota){
        for (Alumno alumno:alumnos){
            if(alumno.getNombre().equals(nombre)) {
                alumno.setNota(nota);
                break;
            }
        }
    }

    public void expulsaAlumno (String nombre){
        for (Alumno alumno:alumnos){
            if(alumno.getNombre().equals(nombre)) {
                alumno.setExpulsado(true);
                break;
            }
        }
    }
    */
    public void getDatosAlumno (String nombre) {
        for (Alumno alumno:Alumno.alumnos){
            if(alumno.getNombre().equals(nombre)) {
                System.out.println("\nId: "+alumno.getId()+"\nColegio: "+alumno.getColegio()+"\nNombre: "+nombre
                        +"\nNota: "+alumno.getNota()+"\nExpulsado: "+alumno.getExpulsado());
                break;
            }
        }
    }

    public void getTodosAlumnos(){
        for (Alumno alumno:Alumno.alumnos){
            if (alumno != null){
                if(alumno.getColegio().equals(this.nombre) && !alumno.getExpulsado()) {
                    System.out.println("\nId: "+alumno.getId()+" Colegio: "+alumno.getColegio()+" Nombre: "+nombre
                            +" Nota: "+alumno.getNota()+" Expulsado: "+alumno.getExpulsado());
                }
            }
        }
    }
}
