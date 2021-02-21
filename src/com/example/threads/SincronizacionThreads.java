package com.example.threads;

public class SincronizacionThreads {

    public static void main(String[] args) {

        CreaHilos hilo1 = new CreaHilos();
        CreaHilos hilo2 = new CreaHilos();

        hilo1.start();

        /* Mediante el método "join()" de la clase "Thread" indicamos
        * al programa que mientras el hilo sobre el que invocamos el
        * método no muera, no ejecute otro. */
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hilo2.start();

        /* Creamos una instancia con la clase que fuerza la ejecución*/
        SincronizaHilos hilo3 = new SincronizaHilos(hilo2);

        hilo3.start();

        /* Realmente esta aplicación tiene 3 hilos. El hilo1, el hilo2
        * y el hilo del main. Al ejecutar esto realmente veremos que
        * la instrucción del "println" no se ejecuta tras finalizar el
        * hilo2, se ejecuta antes o intercalado con hilo2.
        * Para forzar la ejecución del hilo2 antes de la del hilo del
        * main, sería necesario usar también el método "join()" sobre
        * hilo2.  */
        System.out.println("Última instrucción del hilo del main.");
    }
}
/* Otra forma de crear hilos es crear una clase que directamente herede
* de la clase "Thread", que ya implementa la interfaz "Runnable". La
* forma de hacerlo dependerá del caso. */
class CreaHilos extends Thread {

    public void run(){

        for (int i=0;i<20;i++) {
            try {
                sleep(100);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Ejecutando thread "+this.getName()+" vuelta "+i);
        }
    }
}


class SincronizaHilos extends Thread {

    private Thread hilo;

    public SincronizaHilos(Thread hilo) {
        this.hilo=hilo;
    }

    public void run(){

        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i=0;i<20;i++) {
            try {
                sleep(100);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Ejecutando thread "+this.getName()+" vuelta "+i);
        }
    }
}