package com.example.ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaLoginFake {

    public static void main(String[] args) {

        VentanaLogin1 ventana = new VentanaLogin1();

    }
}

class VentanaLogin1 extends JFrame {

    public VentanaLogin1 () {

        setBounds(100,100,400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); //para que no se pueda redimensionar
        setTitle("Login");

        add(new PanelLogin1());

        setVisible(true);
    }
}

class PanelLogin1 extends JPanel implements ActionListener {

    private JButton boton_login;
    private JLabel label_usuario, label_password, label_email;
    private JTextField texto_usuario, texto_password, texto_email;

    public PanelLogin1() {

        /* Creamos e inicializamos los componentes en el constructor,
        * pues si lo hacemos dentro del método "paintComponent" como
        * en el ejercicio resuelto, se generan comportamientos anómalos
        * en cada refresco. */
        boton_login = new JButton("Login");

        boton_login.addActionListener(this);

        label_usuario = new JLabel("Usuario");
        label_password = new JLabel("Contraseña");
        label_email = new JLabel("Email");

        texto_usuario = new JTextField();
        texto_password = new JTextField();
        texto_email = new JTextField();

        /* Parece que no importa si creamos un "FocusListener" para cada
        * componente o usamos el mismo. */
        //EventosFoco foco = new EventosFoco();

        texto_usuario.addFocusListener(new EventosFoco());
        texto_password.addFocusListener(new EventosFoco());

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        boton_login.setBounds(135,190,120,30);

        add(boton_login);

        label_usuario.setBounds(50,50,100,20);
        label_password.setBounds(50,90,100,20);
        label_email.setBounds(50,130,100,20);

        add(label_usuario);
        add(label_password);
        add(label_email);

        texto_usuario.setBounds(125,50,200,20);
        texto_password.setBounds(125,90,200,20);
        texto_email.setBounds(125,130,200,20);

        add(texto_usuario);
        add(texto_password);
        add(texto_email);

        texto_usuario.requestFocusInWindow();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton_login) {

            boolean login_ok = true;

            if (texto_usuario.getText().length() < 5) {
                JOptionPane.showMessageDialog(null,"Error: Longitud usuario insuficiente");
                login_ok = false;
            }
            if (texto_password.getText().length() < 5) {
                JOptionPane.showMessageDialog(null,"Error: Longitud contraseña insuficiente");
                login_ok = false;
            }

            if (!new ValidaEmailLoginFake().isValid(texto_email.getText())) {
                JOptionPane.showMessageDialog(null,"Error: La dirección de email no es válida");
                login_ok = false;
            }

            if (login_ok) { JOptionPane.showMessageDialog(null,"Acción de login!"); }
        }
    }

    class EventosFoco implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {}

        @Override
        public void focusLost(FocusEvent e) {

            /* Validamos cada vez que hay una pérdida de foco si se puede habilitar el botón de Login*/
            if (texto_usuario.getText().equals("") && texto_password.getText().equals("") && texto_email.getText().equals("")){
                boton_login.setEnabled(false);
            }
            else boton_login.setEnabled(true);

            /* Las condiciones que hemos puesto hacen que al cargar la ventana, no se muestre
            * ninguna alerta al perder el foco hasta que no escribamos en Usuario o Contraseña */
            if (e.getSource() == texto_usuario && !texto_password.getText().equals("")) {
                if (texto_usuario.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campo Usuario obligatorio");
                    texto_usuario.requestFocusInWindow();
                }

            } else if (e.getSource() == texto_password && !texto_usuario.getText().equals("")) {
                if (texto_password.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campo Contraseña obligatorio");
                    texto_password.requestFocusInWindow();
                }
            }
        }
    }
}
/* Clase creada solo para validar el email de forma simple */
class ValidaEmailLoginFake {

    private int arrobas = 0,puntos = 0;
    private int lenght_email;

    public boolean isValid(String email){
        lenght_email = email.length();
        if (lenght_email > 3) {
            for (int i=0;i<lenght_email;i++) {
                if (email.charAt(i) == '@') arrobas++;
                if (email.charAt(i) == '.') puntos++;
            } // fin for lenght
        } // fin if
        if (arrobas != 1 || puntos == 0) {
            return false;
        }
        else return true;
    }
}

