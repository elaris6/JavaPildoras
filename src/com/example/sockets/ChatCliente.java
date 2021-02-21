package com.example.sockets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class ChatCliente {

    public static void main(String[] args) {

        VentanaChat chat = new VentanaChat();
        chat.setVisible(true);
    }
}

class VentanaChat extends JFrame {

    public VentanaChat(){

        setBounds(100,100,480,320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cliente Chat");

        add(new PanelChat());
    }

}

class PanelChat extends JPanel implements ActionListener, KeyListener, Runnable {

    private JTextArea textArea;
    private JTextField entradaTexto,nick;
    private JComboBox ipDestino;
    private JButton botonEnviar;
    private String ipServidor;
    private HashMap<String, String> listaClientes;

    public PanelChat(){

        /* Asignamos la disposición del panel principal y creamos dos paneles
        * auxiliares para la zona superior e inferior. */
        setLayout(new BorderLayout());
        JPanel panelSup = new JPanel();
        JPanel panelInf = new JPanel();

        /* Inicializamos los componentes del panel */
        JLabel cabecera = new JLabel("-- CHAT --");
        JLabel nickLabel = new JLabel("Tu nick");
        JLabel ipLabel = new JLabel("Enviar a:");
        textArea = new JTextArea();
        textArea.setBackground(new Color(220,220,220));
        textArea.setDisabledTextColor(Color.BLACK);
        textArea.setEnabled(false);
        entradaTexto = new JTextField(30);
        nick = new JTextField(10);
        nick.setBackground(new Color(220,220,220));
        nick.setDisabledTextColor(Color.BLACK);
        nick.setEnabled(false);
        botonEnviar = new JButton("ENVIAR");
        ipDestino = new JComboBox();
        ipDestino.setMinimumSize(new Dimension(10,2));

        /* Agregamos elementos al combo de las ip's cliente
        ipDestino.addItem("192.168.6.115");
        ipDestino.addItem("192.168.6.116");
        ipDestino.addItem("192.168.6.117");
        ipDestino.addItem("192.168.6.118");*/

        /* Asignamos acción al botón. */
        botonEnviar.addActionListener(this);
        entradaTexto.addKeyListener(this);

        /* Agregamos elementos a los panales y los paneles al panel
        * principal. */
        panelSup.setLayout(new BorderLayout());
        panelSup.add(nick,BorderLayout.WEST);
        panelSup.add(ipDestino,BorderLayout.EAST);

        JPanel panelSupCen = new JPanel();
        SpringLayout dispoMuelle = new SpringLayout();
        panelSupCen.setLayout(dispoMuelle);

        Spring muelle1 = Spring.constant(0,10,200);

        panelSupCen.add(nickLabel);
        panelSupCen.add(cabecera);
        panelSupCen.add(ipLabel);

        /* Fijamos el muelle entre los elementos deseados. Los argumentos del método son:
         * - Punto de anclaje del destino
         * - Componente destino
         * - Muelle a fijar
         * - Punto de anclaje del origen
         * - Componente origen
         * En este ejemplo, fijamos un muelle entre el lado izquierdo (WEST) del panel (this) y el
         * lado izquierdo (WEST) del componente boton1. */
        dispoMuelle.putConstraint(SpringLayout.WEST,nickLabel,5,SpringLayout.WEST,panelSupCen);
        dispoMuelle.putConstraint(SpringLayout.WEST,cabecera,muelle1,SpringLayout.EAST,nickLabel);
        dispoMuelle.putConstraint(SpringLayout.WEST,ipLabel,muelle1,SpringLayout.EAST,cabecera);
        dispoMuelle.putConstraint(SpringLayout.EAST,panelSupCen,5,SpringLayout.EAST,ipLabel);

        panelSup.add(panelSupCen,BorderLayout.CENTER);

        add(panelSup,BorderLayout.NORTH);

        add(textArea,BorderLayout.CENTER);

        panelInf.setLayout(new BorderLayout());
        panelInf.add(entradaTexto,BorderLayout.CENTER);
        panelInf.add(botonEnviar,BorderLayout.EAST);

        add(panelInf,BorderLayout.SOUTH);

        nick.setText(JOptionPane.showInputDialog("Introduce tu apodo para el chat"));
        ipServidor=JOptionPane.showInputDialog("Introduce la dirección IP del servidor");

        /* Hacemos la llamada al método que establece la conexión. */
        estableceConexion(ipServidor);

        /* Lanzamos un hilo paralelo para que corra la escucha de mensajes. */
        Thread hiloEscucha = new Thread(this);
        hiloEscucha.start();

    }

    public void estableceConexion (String ipServidor){

        try{
            Socket socket = new Socket(ipServidor,9999);
            EnvioPaqueteDatos datos = new EnvioPaqueteDatos(nick.getText(), "","online");
            ObjectOutputStream flujoSalida = new ObjectOutputStream(socket.getOutputStream());
            flujoSalida.writeObject(datos);
            flujoSalida.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        enviarTexto();
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            enviarTexto();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}

    public void enviarTexto() {
        String texto = entradaTexto.getText();

        if (!texto.equals("")){
            entradaTexto.setText("");

            try {
                /* Creamos un objecto de tipo "Socket", con un constructor que requiere un
                 * objeto "InetAddress", que no es más qeu una IP, y un int para un puerto.
                 * Este será nuestro camino para las comunicaciones.
                 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/net/Socket.html */
                Socket conexion = new Socket(ipServidor,9999);

                String ipCli="";
                for(Map.Entry<String, String> cliente:listaClientes.entrySet()) {
                    if (cliente.getValue().equals(ipDestino.getSelectedItem())){
                        ipCli= cliente.getKey();
                    }

                }


                /* Creamos una instancia del objeto que usaremos como paquete de datos. */
                EnvioPaqueteDatos datos = new EnvioPaqueteDatos(nick.getText(), ipCli,texto);

                /* Como lo que vamos a enviar no es simplemente texto, no nos vale la
                * clase "DataOutputStream". Vamos a enviar un objeto serializado, y para
                * ello usaremos la clase "ObjectOutputStream".
                * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/ObjectOutputStream.html*/
                ObjectOutputStream flujoSalida = new ObjectOutputStream(conexion.getOutputStream());

                flujoSalida.writeObject(datos);

                textArea.append("--> "+datos.getIp()+": "+texto+"\n");

                // Cerramos el flujo para que no quede abierto innecesariamente.
                flujoSalida.close();

                conexion.close();


            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

        /* Creamos toda la estructura necesaria para recibir objetos serializados,
        * de manera muy similar al lado del servidor. */
        try {

            ObjectInputStream flujoEntrada;
            EnvioPaqueteDatos paqueteDatos;
            ServerSocket escuchaCliente = new ServerSocket(9999);

            while (true) {
                Socket conexionEntrada = escuchaCliente.accept();

                flujoEntrada = new ObjectInputStream(conexionEntrada.getInputStream());

                paqueteDatos = (EnvioPaqueteDatos) flujoEntrada.readObject();

                if (paqueteDatos.getIp().equals("") && paqueteDatos.getTexto().equals("online")) {

                    listaClientes= paqueteDatos.getListaIPClientes();
                    InetAddress ipLocal = conexionEntrada.getLocalAddress();
                    String ipLoc = ipLocal.getHostAddress();
                    ipDestino.removeAllItems();

                    for(Map.Entry<String, String> cliente:paqueteDatos.getListaIPClientes().entrySet()) {
                        if (!cliente.getKey().equals(ipLoc)){
                            ipDestino.addItem(cliente.getValue());
                        }

                    }
                    //textArea.append("Clientes conectados: "+paqueteDatos.getListaIPClientes()+"\n");


                }
                else {
                    textArea.append("<-- "+paqueteDatos.getNick()+" ("+paqueteDatos.getIp()+") : "+paqueteDatos.getTexto()+"\n");
                }




                flujoEntrada.close();
            }



        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}

/* Implementamos la interfaz "Serializable" para permitir que esta clase pueda
* ser enviada como objeto. */
class EnvioPaqueteDatos implements Serializable {

    private String nick,ip,texto;
    /* Necesitamos crear un objeto ArrayList para gestionar la lista de clientes
    * conectados. Con este objeto podremos recibir la lista del servidor y
    * enviarla desde el servidor a los clientes. */
    private HashMap<String,String> listaIPClientes;

    public EnvioPaqueteDatos(String nick, String ip, String texto) {
        this.nick = nick;
        this.ip = ip;
        this.texto = texto;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public HashMap<String,String> getListaIPClientes() {
        return listaIPClientes;
    }

    public void setListaIPClientes(HashMap<String,String> listaIPClientes) {
        this.listaIPClientes = listaIPClientes;
    }




}
