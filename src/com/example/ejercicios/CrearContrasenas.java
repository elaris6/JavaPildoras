package com.example.ejercicios;

import javax.swing.*;

public class CrearContrasenas {

    public static void main(String[] args) {

        // Pedimos datos de entrada
        JOptionPane.showMessageDialog(null,"Bienvenido al programa de generación de contraseñas.");
        int longPwd = Integer.parseInt(JOptionPane.showInputDialog("Introduce la longitud de las contraseñas a generar"));
        int numPwd = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de contraseñas a generar"));

        // Creamos array de contraseñas
        Contrasena listaPwd[] = new Contrasena[numPwd];

        // Rellenamos el array con objetos de clase Contrasena y mostramos los atributos solicitados
        for (int i=0;i<numPwd;i++) {
            listaPwd[i]= new Contrasena(longPwd);
            System.out.println("Contraseña generada: "+listaPwd[i].getPassword()+" | Longitud: "+listaPwd[i].getPassLen()+" | Segura: "+listaPwd[i].strongPass());
        }

    }
}

class Contrasena {

    private int len;
    private String password;
    private String capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String minusc = "abcdefghijklmnopqrstuvwxyz";
    private String numbers = "1234567890";

    public Contrasena(int len) {
        this.len = len;
        this.password = this.buildPassword(this.len);
    }

    private String buildPassword(int len) {

        String allchar = numbers+capital+minusc;
        String password = "";
        int posic;

        for (int i=0;i<len;i++) {
            posic = (int) (Math.random()*(allchar.length() - 1));
            //System.out.print(posic+" ");
            password += allchar.charAt(posic);
        }
        return password;
    }

    public int getPassLen() {
        return this.len;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean strongPass() {

        /*
            Para buscar si un caracter está en una cadena podemos usar String.indexOf('a'), que devolverá
            el índice si existe o -1 si no.

            También podemos usar String.contains(CharSequence), pero en este caso, necesitaríamos
            convertir el caracter a String de la siguiente forma String.contains(Character.toString('a')).
            El método contains devolverá true o false.
         */
        int may = 0, min = 0, num = 0;

        if (this.password.length()<8) return false;
        else {
            for (int i=0;i<this.len;i++) {
                if (capital.indexOf(password.charAt(i)) != -1 ) may++;
                if (minusc.indexOf(password.charAt(i)) != -1 ) min++;
                if (numbers.indexOf(password.charAt(i)) != -1 ) num++;
            }
            if (may > 2 && min > 1 && num > 0) return true;
            else return false;
        }
    }
}
