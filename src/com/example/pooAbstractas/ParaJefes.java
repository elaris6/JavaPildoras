package com.example.pooAbstractas;

// Esto es una interfaz
// Existen interfaces implemtnadas de serie en el API de Java

// En este caso además, la interfaz hereda de otra interfaz, como podría hacerlo una clase
public interface ParaJefes extends ParaTrabajadores{

    public abstract void setCargo(String cargo);

    public abstract String getCargo();
}
