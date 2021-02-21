package com.example.ejercicios;

public class UsoColegio {

    public static void main(String[] args) {

        Colegio BueroVallejo = new Colegio("Buero Vallejo",200);
        Colegio VCentenario = new Colegio("V Centenario",300);

        VCentenario.nuevoAlumno("Alicia",9.0);
        VCentenario.nuevoAlumno("Natalia",8.5);
        BueroVallejo.nuevoAlumno("Israel",5.7);
        VCentenario.nuevoAlumno("Jorge",8.7);
        VCentenario.nuevoAlumno("Diego",8.8);
        BueroVallejo.nuevoAlumno("Ruben",5.9);


        BueroVallejo.expulsaAlumno("Israel");

        VCentenario.setNotaMedia("Natalia",9.8);
        //VCentenario.getDatosAlumno("Natalia");
        //VCentenario.getDatosAlumno("Alicia");
        VCentenario.getTodosAlumnos();
        VCentenario.getDatosAlumno("Natalia");
        BueroVallejo.getTodosAlumnos();
        BueroVallejo.getDatosAlumno("Israel");

    }
}
