package com.example.depuracion;

import javax.swing.*;

public class MatrizAleatorios {

    public static void main(String[] args) {

        int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de elementos aleatorios"));

        int listaElementos[] = new int [elementos];

        for (int i=0;i<listaElementos.length;i++) {
            /* Con el debugger en esta línea vemos que aquí solo se almancenan ceros
            * Centrados aquí deberíamos llegar a la conclusión del problema.
            *
            * Se pueden crear puntos de control condicionales. Por ejemplo, cuando
            * i==4 en un bucle for.
            *
            * Es muy útil también por ejemplo la opción "Evaluate expression, para
            * validar expresiones usando objetos del programa."
            *
            * Al ir ejecutando un programa en modo debug, la opción "step into" nos
            * permite enlazar con el origen de la función en la que estamos, por
            * ejemplo en caso de un programa dividido en múltiples ficheros.*/
            listaElementos[i]=(int)Math.random()*100;

        }
        for (int elem:listaElementos){
            System.out.println(elem);
        }
    }
}
