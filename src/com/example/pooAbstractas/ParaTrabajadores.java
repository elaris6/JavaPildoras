package com.example.pooAbstractas;

// Esto es una interfaz
// Existen interfaces implemtnadas de serie en el API de Java
public interface ParaTrabajadores {

    // Para las constantes se pueden omitir los modificadores "public final static"
    // pues se dan por hechos al ser una interfaz, que solo pueden admitir esto.
    double BONUS = 500;

    // En los métodos de interfaces podemos obviar los modificadores
    // "public abstract" porque igualmente se sobreentienden al ser una interfaz
    double setBonus(double gratificacion);
}
