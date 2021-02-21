package com.example.sockets;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {

    public static void main(String[] args) {

        VentanaServidor ventana = new VentanaServidor();
        ventana.setVisible(true);
    }
}

class VentanaServidor extends JFrame {

    public VentanaServidor(){

        setBounds(700,100,480,320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Servidor");

        add(new PanelServidor());
    }
}

class PanelServidor extends JPanel implements Runnable {

    private JTextArea textArea;

    public PanelServidor(){

        JLabel tituloPanel=new JLabel("SERVIDOR");
        textArea=new JTextArea();

        setLayout(new BorderLayout());
        JPanel panelTitulo = new JPanel();
        panelTitulo.add(tituloPanel);

        add(panelTitulo,BorderLayout.NORTH);
        add(textArea,BorderLayout.CENTER);

        Thread hilo = new Thread(this);
        hilo.start();


    }

    @Override
    public void run() {
        System.out.println("Ejecutando tarea");
        try {
            /* Creamos un objeto "ServerSocket" que será el encargado de levantar la escucha
             * en el puerto que se indique.
             *
             * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/net/ServerSocket.html
             * */

            ServerSocket srvr = new ServerSocket(9999);

            while (true) {
                /* Creamos un "Socket" para aceptar las conexiones escuchadas por el objeto
                 * "ServerSocket". */
                Socket skt = srvr.accept();

                // Creamos flujo de entrada de datos
                DataInputStream flujoEntrada = new DataInputStream(skt.getInputStream());

                String texto = flujoEntrada.readUTF();
                System.out.println(texto);

                if (textArea.getText().equals("")) textArea.append(texto);
                else textArea.append("\n"+texto);

                skt.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


