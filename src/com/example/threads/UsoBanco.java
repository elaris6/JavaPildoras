package com.example.threads;

/* Solución del profesor al ejercicio planteado en el video
 166. Threads VI. Ejercicio guiado sincronización de threads

 Solución realizada por mi en el paquete com.example.ejercicios,
  en la clase TransferenciasConcurrentes. El enfoque funcional es
  diferente :D
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UsoBanco {

    public static void main(String[] args) {

        Banco b = new Banco();

        for (int i=0;i<100;i++){

            EjecutandoTransferencias r = new EjecutandoTransferencias(b,i,2000);

            Thread t = new Thread(r);
            t.start();
        }
    }
}

class Banco {

    private final double [] cuentas;

    // Instancia de la clase "ReentrantLock", para gestionar el bloqueo de código
    private ReentrantLock locker = new ReentrantLock();

    /* Instancia de la clase "Condition" para gestionar condiciones en el bloqueo de
    * código.
    * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/locks/Condition.html
    *  */
    private Condition saldoSuficiente;

    public Banco (){

        cuentas = new double[100];
        for (int i=0;i<100;i++){
            cuentas[i]=2000;
        }
        saldoSuficiente = locker.newCondition();
    }

    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {

        /* En lugar de usar em método "join()" de la clase "Thread", para
        * sincronizar los hilos y que no haya ejecuciones cuncurrentes de
        * bloques de código que pudieran causar problemas en ese caso, se
        * puede usar la interfaz "Lock", implementada por la clase
        * "ReentrantLock", y los métodos "lock()" y "unlock()" al principio
        * y al final del bloque de código a bloquear.
        *
        * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/locks/ReentrantLock.html
        *
        * Una buena práctica en este caso es meter el desbloqueo dentro de
        * una cláusula "finally" de un try - finally, para que pase lo que
        * pase en el código bloqueado, este se desbloquee. */

        locker.lock();

        try{
            //if (cuentas[cuentaOrigen] < cantidad){
                /* En un método void se puede incluir un "return" para salirse sin
                 * hacer nada. */
                //return;
            //}

            /* Mediante el uso de los métodos "await()" y "signalAll()", ppodemos dormir
             * o despertertar los hilos en base a condiciones, para no perder su flujo de
             * ejecución, como ocurría con el condicional comentado arriba.
             * Optar por una solución u otra dependerá de la funcionalidad a implementar. */
            while (cuentas[cuentaOrigen] < cantidad){
                saldoSuficiente.await();
            }
            System.out.println(Thread.currentThread());
            cuentas[cuentaOrigen]-=cantidad;
            System.out.printf("%10.2f € de cuenta %d a cuenta %d",cantidad,cuentaOrigen,cuentaDestino);
            cuentas[cuentaDestino]+=cantidad;
            //System.out.println(cantidad + " € de cuenta "+cuentaOrigen+" a cuenta "+cuentaDestino);
            /* Ejemplo de uso del "printf" */
            //System.out.printf("%10.2f € de cuenta %d a cuenta %d",cantidad,cuentaOrigen,cuentaDestino);

            System.out.printf("\nSaldo total: %10.2f%n",getSaldoTotal());

            /* Los hilos que están en espera despiertan y realizan de nuevo su comprobación
            * de la condición del blucle while. */
            saldoSuficiente.signalAll();
        }
        finally {
            locker.unlock();
        }

    }

    public double getSaldoTotal(){

        double sumaSaldoBanco=0;
        for(double a:cuentas){
            sumaSaldoBanco+=a;
        }
        return sumaSaldoBanco;
    }
}

class EjecutandoTransferencias implements Runnable {

    private Banco banco;
    private int cuentaOrigen;
    private double cantidadMaxima = 2000;

    public EjecutandoTransferencias(Banco banco, int cuentaOrigen, double cantidadMaxima) {
        this.banco = banco;
        this.cuentaOrigen = cuentaOrigen;
        this.cantidadMaxima = cantidadMaxima;

    }

    @Override
    public void run() {

        while(true) {

            int cuentaDestino = (int) (Math.random()*100);
            double cantidadATransferir = Math.random()*cantidadMaxima;

            /* Al incluir el bloqueo de código con condiciones y usar el método
            * "await()", necesitamos controlar la excepción en el método invocador.*/
            try {

                banco.transferencia(this.cuentaOrigen,cuentaDestino,cantidadATransferir);
                Thread.sleep(30);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}