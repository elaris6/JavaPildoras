package com.example.ejercicios;

public class TransferenciasConcurrentes {

    public static CuentaBancaria[] cuentas = new CuentaBancaria[100];

    public static void main(String[] args) {

        for(int i=0;i<100;i++) {
            cuentas[i] = new CuentaBancaria();
        }

        /* Si lanzamos 10 hilos y cada hilo hace mil transferencias, las posibilidades
        * de que cojan simultáneamente las mismas cuentas y por tanto se hagan
        * movimientos de saldo incorrectos son elevadas. */

        //ThreadGroup grupoHilos = new ThreadGroup("grupoHilos");

        Thread hilos[] = new Thread[100];
        hilos[0] = new CreaHilos(hilos[0]);
        for(int i=1;i< hilos.length;i++){

            hilos[i] = new CreaHilos(hilos[i-1]);
            hilos[i].start();
        }

        try {
            hilos[hilos.length-1].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double saldoTotal = 0;
        for (CuentaBancaria cuenta:cuentas) {
            System.out.println(cuenta);
            saldoTotal+=cuenta.getSaldo();
        }
        System.out.println("El saldo total es: "+saldoTotal);

    }


    static class CreaHilos extends Thread {

        Thread hiloPrev;

        public CreaHilos(Thread hilo) {
            this.hiloPrev=hilo;
        }

        public void run(){

            //System.out.println("Creando un nuevo hilo: "+this.getName());

            try {
                hiloPrev.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i=0;i<10000;i++){
                int cuentaOrig = (int) (Math.random()*100);
                int cuentaDest = (int) (Math.random()*100);
                double importe = Math.random()*2000;

                CuentaBancaria.transferencia(cuentas[cuentaOrig],cuentas[cuentaDest],importe);
            }
            //System.out.println("Ejecución del hilo "+ this.getName()+" finalizada.");

        }
    }
}

class CuentaBancaria {

    private double saldo;
    private static int NUM_CUENTA = 1;
    private int numCuenta;

    public CuentaBancaria (){
        this.saldo=2000.0;
        this.numCuenta = NUM_CUENTA;
        NUM_CUENTA++;
    }

    public int getNumCuenta() {
        return this.numCuenta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void addSaldo(double importe) {
        this.saldo+=importe;
    }

    public void restaSaldo(double importe) {
        this.saldo-=importe;
    }

    public String toString() {
        return "Número de cuenta "+this.getNumCuenta()+" Saldo: "+this.getSaldo();
    }

    public static void transferencia (CuentaBancaria cuentaOrig, CuentaBancaria cuentaDest, double importe) {
        if (cuentaOrig.getSaldo()>= importe) {
            cuentaOrig.restaSaldo(importe);
            cuentaDest.addSaldo(importe);
        }
    }
}







