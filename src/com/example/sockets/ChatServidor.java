package com.example.sockets;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ChatServidor {

    public static void main(String[] args) {

        VentanaChatServidor servidor = new VentanaChatServidor();
        servidor.setVisible(true);
    }
}

class VentanaChatServidor extends JFrame {

    public VentanaChatServidor(){

        setBounds(700,100,480,320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Servidor");

        add(new PanelChatServidor());
    }
}

class PanelChatServidor extends JPanel implements Runnable {

    private JTextArea textArea;
    private HashMap<String,String> listaIPClientes = new HashMap<>();

    public PanelChatServidor(){

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
            /* Creamos la variable que nos permitirá recoger los datos recibidos.*/
            EnvioPaqueteDatos paqueteRecibido;

            /* Creamos un objeto "ServerSocket" que será el encargado de levantar la escucha
             * en el puerto que se indique.
             * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/net/ServerSocket.html
             * */
            ServerSocket srvr = new ServerSocket(9999);

            while (true) {
                /* Creamos un "Socket" para aceptar las conexiones escuchadas por el objeto
                 * "ServerSocket". */
                Socket conexion = srvr.accept();

                /* Como lo que vamos a recibir no es simplemente texto, no nos vale la
                 * clase "DataInputStream". Vamos a recibir un objeto serializado, y para
                 * ello usaremos la clase "ObjectInputStream".
                 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/ObjectInputStream.html*/

                ObjectInputStream flujoEntrada = new ObjectInputStream(conexion.getInputStream());

                /* Es necesario hacer un casting, porque el método "readObject()" devuelve
                * un "Object". Además hay que capturar la excepción "ClassNotFoundException". */
                paqueteRecibido = (EnvioPaqueteDatos) flujoEntrada.readObject();
                //System.out.println(paqueteRecibido.getTexto());

                flujoEntrada.close();

                if (paqueteRecibido.getIp().equals("") && paqueteRecibido.getTexto().equals("online")) {

                    /* Capturamos la IP remota dela conexión. */
                    InetAddress ipCliente = conexion.getInetAddress();
                    String ipClienteS = ipCliente.getHostAddress();
                    listaIPClientes.put(ipClienteS, paqueteRecibido.getNick());

                    /* Agregamos el ArrayList actualizado al objeto del paquete de datos */
                    paqueteRecibido.setListaIPClientes(listaIPClientes);

                    /* Cada vez que se conecta un cliente, recorremos la lista de clientes conectados
                    * y enviamos la lista a cada cliente. */
                    for(String ipCli:listaIPClientes.keySet()){
                        /* Creamos una instancia de "Socket", para establecer la conexión con el
                         * cliente destino final de la comucicación. */
                        Socket conexionSalida = new Socket(ipCli,9999);

                        /* Creamos también un "ObjectOutputStream" para generar un flujo de datos
                         * serializados para el envío. */
                        ObjectOutputStream flujoSalida = new ObjectOutputStream(conexionSalida.getOutputStream());

                        /* Escribimos el objeto recibido en el flujo de salida. */
                        flujoSalida.writeObject(paqueteRecibido);

                        /* Cerramos el stream de datos y el socket. */
                        flujoSalida.close();
                        conexionSalida.close();

                    }

                    if (textArea.getText().equals("")){
                        textArea.append("Cliente conectado: "+ipClienteS);
                    }
                    else {
                        textArea.append("\nCliente conectado: "+ipClienteS);
                    }

                }
                else  {

                    if (textArea.getText().equals("")){
                        textArea.append("De: "+paqueteRecibido.getNick()+" --> "+paqueteRecibido.getIp()+" | Mensaje: "+paqueteRecibido.getTexto());
                    }
                    else {
                        textArea.append("\n"+"De: "+paqueteRecibido.getNick()+" --> "+paqueteRecibido.getIp()+" | Mensaje: "+paqueteRecibido.getTexto());
                    }

                    /* Creamos una instancia de "Socket", para establecer la conexión con el
                     * cliente destino final de la comucicación. */
                    Socket conexionSalida = new Socket(paqueteRecibido.getIp(),9999);

                    /* Creamos también un "ObjectOutputStream" para generar un flujo de datos
                     * serializados para el envío. */
                    ObjectOutputStream flujoSalida = new ObjectOutputStream(conexionSalida.getOutputStream());

                    /* Escribimos el objeto recibido en el flujo de salida. */
                    flujoSalida.writeObject(paqueteRecibido);
                }


                /* Cerramos la conexión tras cada lectura en cada vuelta del while */
                conexion.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

