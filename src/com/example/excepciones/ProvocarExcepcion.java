package com.example.excepciones;

import javax.swing.*;

public class ProvocarExcepcion {

    public static void main(String[] args) {

        String email= JOptionPane.showInputDialog("ntroduce una dirección de email");

        /* Controlamos la excepción que provocamos en nuestro método mediante
        * un bloque try catch. */
        try {
            examinarMail(email);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Longitud email insuficiente.");
        }

    }

    /* Definimos un método que puede lanzar una excepción, en este caso una
    * excepción de tipo genérico "Exception". */
    static void examinarMail(String email) throws Exception {

        int arroba = 0;
        boolean punto = false;

        /* Con la sentenci "throw" podemos forzar el lanzamiento de una excepción
        * en cualquier punto del programa. Para ello deberemos instanciar un objeto
        * de ese tipo de excepción. */
        if (email.length() < 7) {
            Exception excepcion = new Exception();
            throw excepcion;
        }

        for (int i=0;i<email.length();i++) {

            if (email.charAt(i) == '@') {
                arroba++;
            }
            else if (email.charAt(i) == '.') {
                punto = true;

            }
        }
        if (punto && arroba == 1) JOptionPane.showMessageDialog(null, "Comprobaciones OK");
        else JOptionPane.showMessageDialog(null, "Comprobaciones KO");
    }
}
