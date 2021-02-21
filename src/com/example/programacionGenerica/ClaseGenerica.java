package com.example.programacionGenerica;

/* Para el elemento genérico se suelen usar las letras T, U ó K,
* pero es una convención. Se puede usar cualqueir otra cosa. */
public class ClaseGenerica<T> {

    private T objeto;

    public ClaseGenerica(){
        objeto = null;
    }

    public void setObjecto(T nuevoValor){
        objeto = nuevoValor;
    }

    public T getObjeto(){
        return objeto;
    }

}
