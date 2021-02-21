package com.example.colecciones;

public class ComparacionEquals {

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

class Libro {

    private String autor;
    private String titulo;
    private int isbn;

    public Libro(String autor, String titulo, int isbn) {
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String toString(){
        return "Título: "+this.titulo+" Autor: "+this.autor+" ISBN: "+this.isbn;
    }

    /* Para comparar dos objetos cualesquiera por un criterio específico, se
     * debe sobreescribir el método "equals(Object obj)" de la clase Object.
     * Para que esto funcione, es imprescindible que el método reciba un
     * objeto de tipo Object en la entrada y por tanto deberemos hacer un
     * casting para gestionarlo.  */
    public boolean equals(Object o) {

        /* Es una buena práctica incluir la revisión sobre si el objeto es una
        instancia del objeto que queremos comparar. */
        if (o instanceof Libro){
            Libro l=(Libro)o;
            if (this.isbn == l.isbn) return true;
            else return false;
        }
        else return false;
    }
}
