package com.example.colecciones;

public class UsoLibros {

    public static void main(String[] args) {

        Libro libro1 = new Libro("Autor1","Título libro 1",1000);
        Libro libro2 = new Libro("Autor2","Título libro 2",1000);

        /* Se ha sobreescrito el método "equals" en la clase "Libro", para poder
        * hacer una comparación customizada de los objetos. En caso contratrio,
        * la comparación se haría directamente por el "hashCode". */
        if (libro1.equals(libro2)) System.out.println("Los libros son iguales");
        else System.out.println("Los libros NO son iguales");
    }
}

