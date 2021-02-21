package com.example.excepciones;

import javax.swing.*;
import java.io.IOException;

public class ProvocarExcepcionCustom {

    public static void main(String[] args) {

        String email= JOptionPane.showInputDialog("ntroduce una dirección de email");

        /* Controlamos la excepción personalizada que provocamos en nuestro método
        mediante un bloque try catch. */
        try {
            examinarMail(email);
        }
        catch (Exception e) {
            // Al imprimir la traza de la excepción se imprimrá el mensaje personalizado
            // si hemos usado el constructor que informa de un mensaje.
            e.printStackTrace();
        }
        System.out.println("Programa finalizado.");
    }

    /* Definimos un método que puede lanzar una excepción, en este caso una
     * excepción de tipo genérico "Exception". */
    static void examinarMail(String email) throws ErrorLongitudEmail {

        int arroba = 0;
        boolean punto = false;

        /* Con la sentenci "throw" podemos forzar el lanzamiento de una excepción
         * en cualquier punto del programa. Para ello deberemos instanciar un objeto
         * de ese tipo de excepción. */
        if (email.length() < 7) {
            ErrorLongitudEmail excepcion = new ErrorLongitudEmail("Longitud email insuficiente.");
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

/* Creamos una clase que heredará de IOException o de RuntimeExcepcion, en función
* de si queremos que sea de control obligado o no.
* Lo habitual si se crea un error personalizado es que deseemos que se controle y
* por tanto haremos que herede de IOException. */
class ErrorLongitudEmail extends IOException {

    /* Es recomendable construir al menos dos constructores, uno sin parámetros
    * para que la excepción pueda ser usada sin información adicional. */
    public ErrorLongitudEmail() {

    }
    /* Creamos un constructor que reciba un mensaje y pasamos este mensaje al
    * constructor del padre (en este caso "IOException") para conseguir que dicho
    * mensaje se devuelva junto con el error, informando del motivo del mismo siempre
    * que sea posible. */
    public ErrorLongitudEmail (String mensajeError) {
        super(mensajeError);
    }
}
