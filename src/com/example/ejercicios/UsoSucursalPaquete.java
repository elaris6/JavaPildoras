package com.example.ejercicios;

import java.util.Scanner;

public class UsoSucursalPaquete {

    public static void main(String[] args) {

        // Solicitamos datos sucursal
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce los datos de la sucursal:");
        System.out.print("Número de sucursal: ");
        int numSucursal = entrada.nextInt();
        System.out.print("Dirección de sucursal: ");
        entrada.nextLine();
        String direcc = entrada.nextLine();
        System.out.print("Ciudad de sucursal: ");
        String city = entrada.nextLine();
        System.out.print("Coste envío sucursal: ");
        double costeEnvio = entrada.nextDouble();

        // Instanciamos sucursal

        Sucursal sucursal1 = new Sucursal(numSucursal,direcc,city,costeEnvio);

        // Creamos N paquetes solicitando datos

        System.out.print("\nIntroduce número de paquetes a enviar: ");
        Paquete paquetes[] = new Paquete[entrada.nextInt()];
        System.out.println();
        for(int i=0;i<paquetes.length;i++) {
            System.out.print("Introduce referencia: ");
            int ref = entrada.nextInt();
            System.out.print("Introduce DNI remitente: ");
            entrada.nextLine();
            String dni = entrada.nextLine();
            System.out.print("Introduce peso: ");
            double peso = entrada.nextDouble();
            System.out.print("Introduce prioridad [0/1/2]: ");
            byte prioridad = entrada.nextByte();
            Paquete paquete = new Paquete(ref,peso,dni,prioridad);
            paquetes[i] = paquete;
        }

        // Imprimimos resultados

        System.out.println("\nDATOS SUCURSAL");
        System.out.println("Num: "+sucursal1.getNumSucursal()+"\nDir: "+sucursal1.getDireccion()+"\nCiu: "+sucursal1.getCiudad());

        System.out.println("\nDATOS PAQUETES");
        for(int i=0;i<paquetes.length;i++) {
            System.out.println("\nDatos paquete "+(i+1));
            costeEnvio = (double) Math.round(sucursal1.calculaPrecio(paquetes[i])*100) / 100;
            System.out.println("Ref: "+paquetes[i].getRef()+"\nPeso: "+paquetes[i].getPeso()+"\nPri: "+paquetes[i].getPrioridad()+"\nCoste: "+costeEnvio+" €");
        }
    }
}
