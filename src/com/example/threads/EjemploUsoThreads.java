package com.example.threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/* THREADS
*
* Para crear una aplicación que se capaz de ejecutar varios hilos de ejecución
* concurrentes, es necesario realizar varios pasos (imagen en doc de curso):
* - Crear clase que implemente la interfaz "Runnable" (método "run()")
* - Escribir el código de la tarea dentro del método "run()"
* - Instanciar la clase creada y almacenar la instancia en una vlbe de tipo
* "Runnable".
* - Crear instancia de la clase "Thread" pasando como parámetro al constructor
* el objecto "Runnable" instanciado en el paso previo.
* - Poner en marcha el hilo de ejecución con el método "start()" de la clase
* "Thread".
*
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Thread.html
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Runnable.html
*  */

public class EjemploUsoThreads {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame marco=new MarcoRebote();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.setVisible(true);

    }

}

//Movimiento de la pelota-----------------------------------------------------------------------------------------
class Pelota{

    // Mueve la pelota invirtiendo posición si choca con límites
    public void mueve_pelota(Rectangle2D limites){

        x+=dx;

        y+=dy;

        if(x<limites.getMinX()){

            x=limites.getMinX();

            dx=-dx;
        }

        if(x + TAMX>=limites.getMaxX()){

            x=limites.getMaxX() - TAMX;

            dx=-dx;
        }

        if(y<limites.getMinY()){

            y=limites.getMinY();

            dy=-dy;
        }

        if(y + TAMY>=limites.getMaxY()){

            y=limites.getMaxY()-TAMY;

            dy=-dy;

        }

    }

    //Forma de la pelota en su posición inicial
    public Ellipse2D getShape(){

        return new Ellipse2D.Double(x,y,TAMX,TAMY);

    }

    //Método para devolver el color de la pelota
    public Color getColor(){
        return this.color;
    }

    private static final int TAMX=15;

    private static final int TAMY=15;

    /* Ponemos números random en las coordenadas de inicio, para que la pelota
    se cree en un punto aleatorio cada vez. */
    private double x=Math.random()*350;

    private double y=Math.random()*300;

    private double dx=1;

    private double dy=1;

    private Color color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));


}

// Lámina que dibuja las pelotas----------------------------------------------------------------------
class LaminaPelota extends JPanel{

    //Añadimos pelota a la lámina

    public void add(Pelota b){

        pelotas.add(b);
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;

        for(Pelota b: pelotas){

            g2.setPaint(b.getColor());

            g2.fill(b.getShape());

        }

    }

    private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con lámina y botones------------------------------------------------------------------------------
class MarcoRebote extends JFrame{

    public MarcoRebote(){

        setBounds(600,300,400,350);

        setTitle ("Rebotes");

        lamina=new LaminaPelota();

        add(lamina, BorderLayout.CENTER);

        JPanel laminaBotones=new JPanel();

        ponerBoton(laminaBotones, "Lanzar!", new ActionListener(){

            public void actionPerformed(ActionEvent evento){
                comienza_el_juego();
            }
        });


        ponerBoton(laminaBotones, "Parar", new ActionListener(){

            public void actionPerformed(ActionEvent evento){
                parar();

            }
        });

        ponerBoton(laminaBotones, "Salir", new ActionListener(){

            public void actionPerformed(ActionEvent evento){
                System.exit(0);
            }
        });

        add(laminaBotones, BorderLayout.SOUTH);
    }


    //Ponemos botones
    public void ponerBoton(Container c, String titulo, ActionListener oyente){

        JButton boton=new JButton(titulo);

        c.add(boton);

        boton.addActionListener(oyente);

    }

    //Añade pelota y la bota 3000 veces
    public void comienza_el_juego (){

        Pelota pelota=new Pelota();
        lamina.add(pelota);

        /* Comentamos el bucle for, que será el código que se requiere implementar
        dentro del método "run()", de la clase que implementa "Runnable" */

        /*for (int i=1; i<=3000; i++){

            pelota.mueve_pelota(lamina.getBounds());

            lamina.paint(lamina.getGraphics());

            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }*/

        /* Sustituimos el bucle for del código en el que la aplicación es monohilo,
        * por el bloque en el que damos los pasos necesarios, descritos en la
        * cabecera:
        * - Instanciar la clase creada y almacenar la instancia en una vlbe de tipo
        * "Runnable".
        * - Crear instancia de la clase "Thread" pasando como parámetro al constructor
        * el objecto "Runnable" instanciado en el paso previo.
        * - Poner en marcha el hilo de ejecución con el método "start()" de la clase
        * "Thread".
        * */

        /* Por convención al objeto "Runnable" se le llama "r" y al objeto "Thread"
        * se le llama "t". */
        Runnable r = new PelotaThreads(pelota,lamina);
        t = new Thread(r);
        t.start();

    }

    /* Creamos un método que detendrá el último hilo de ejecución creado. */
    public void parar() {

        /* El método "stop()" funciona perfectamente, pero esté deprecado
        * por problemas bajo ciertas circunstancias. */
        //t.stop();

        /* Como no se puede/debe usar 2l método "stop()", se debe realizar con
        el método "interrupt()".
         Este método es incompatible con un hilo sobre el que se haya ejecutado
         el método "sleep()". */
        t.interrupt();

    }

    private Thread t;

    private LaminaPelota lamina;
}

/* Clase que implamentará la interfaz "Runnable" */
class PelotaThreads implements Runnable {

    /* Creamos las variables privadas necesarias para la gestión del código. */
    private Pelota pelota;
    private Component lamina;

    public PelotaThreads (Pelota pelota, Component lamina) {
        this.pelota=pelota;
        this.lamina=lamina;
    }

    @Override
    public void run() {

        /* Tenemos que modificar el código del "run()", porque la instrucción
        "interrupt()" no puede ejecutarse sobre un hilo dormido (lanza excepción).
        Debemos por tanto sustituir el for por un while para que se ejecute
         indefinidamente hasta que lo interrumpamos. */
        //for (int i=1; i<=3000; i++){

        /* El while se puede controlar de dos formas con los métodos "interrupted()"
        * ó "isInterrupted()". */
        //while (!Thread.interrupted()) {
        while (!Thread.currentThread().isInterrupted()){

            pelota.mueve_pelota(lamina.getBounds());

            lamina.paint(lamina.getGraphics());

            /*try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}