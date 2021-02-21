package com.example.sockets;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;


public class AppCliente {

    public static void main(String[] args) {

        VentanaCliente ventana = new VentanaCliente();
        ventana.setVisible(true);

    }
}

class VentanaCliente extends JFrame {

    public VentanaCliente(){

        setBounds(100,100,480,320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cliente");

        add(new PanelCliente());
    }
}

class PanelCliente extends JPanel implements ActionListener {

    private JLabel tituloPanel;
    private JTextField entradaTexto;
    private JButton enviar;

    public PanelCliente(){

        tituloPanel=new JLabel("CLIENTE");
        entradaTexto = new JTextField(30);
        enviar = new JButton("ENVIAR");

        enviar.addActionListener(this);

        JPanel panelTitulo = new JPanel();
        panelTitulo.add(tituloPanel);
        JPanel panelTexto = new JPanel();
        panelTexto.add(entradaTexto);
        JPanel panelBoton = new JPanel();
        panelBoton.add(enviar);

        Box caja = Box.createVerticalBox();

        caja.add(panelTitulo);
        caja.add(Box.createVerticalStrut(20));
        caja.add(panelTexto);
        caja.add(Box.createVerticalStrut(20));
        caja.add(panelBoton);

        add(caja);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(enviar)) {
            String texto = entradaTexto.getText();
            entradaTexto.setText("");
            //JOptionPane.showMessageDialog(null,texto);

            try {
                /* Creamos un objecto de tipo "Socket", con un constructor que requiere un
                * objeto "InetAddress", que no es más qeu una IP, y un int para un puerto.
                * Este será nuestro camino para las comunicaciones.
                *
                * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/net/Socket.html
                * */
                Socket unSocket = new Socket(InetAddress.getLocalHost(),9999);

                /* Debemos crear un flujo de datos para que viaje por el camino. Para esto
                * necesitamos un objeto de tipo "DataOutputStream", que representa los
                * paquetes que enviaremos por el camino/Socket.
                * La clase "Socket" tiene el método "getOutputStream" que nos podrá devolver
                * ya el objeto que necesitamos como argumento para el constructor.
                *
                * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/DataOutputStream.html
                * */
                DataOutputStream flujoSalida = new DataOutputStream(unSocket.getOutputStream());

                /* De entre los métodos de escritura de la clase "DataOutputStream", elegimos
                * "writeUTF(String s)", para independizar la codificación de caracteres de la
                * máquina cliente en la que nos estemos ejecutando.*/
                flujoSalida.writeUTF(texto);

                // Cerramos el flujo para que no quede abierto innecesariamente.
                flujoSalida.close();


            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
