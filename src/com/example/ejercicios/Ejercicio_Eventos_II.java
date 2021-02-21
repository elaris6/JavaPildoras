package com.example.ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/* En este ejercicio resuelto del curso, el comportamiento base es correcto,
* pero el pintado de componentes no es bueno, parece que por meter la creación
* de los mismos dentro del método "paintComponent" del JPanel. */

public class Ejercicio_Eventos_II {

    public static void main(String[] args) {
        VentanaEventos vEventos=new VentanaEventos();
        vEventos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class VentanaEventos extends JFrame {
    public VentanaEventos(){
        setBounds(500,300,400,250);
        add(new Lamina_Marco_Eventos());
        setVisible(true);
    }
}
class Lamina_Marco_Eventos extends JPanel {
    private class EventosDeFoco implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {}
        @Override
        public void focusLost(FocusEvent e) {
            if(e.getSource()==campoTexto1) {
                if(campoTexto1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"El usuario no puede quedar vacío");
                    campoTexto1.requestFocus();
                }
            }
            if(e.getSource()==campoTexto2) {
                if(campoTexto2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"La contraseña no puede quedar vacía");
                    campoTexto2.requestFocus();
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        campoTexto1 = new JTextField();
        campoTexto2 = new JTextField();
        campoTexto3 = new JTextField();
        etiq1 = new JLabel("Usuario");
        etiq2 = new JLabel("Contraseña");
        etiq3 = new JLabel("Email");
        campoTexto1.setBounds(120,10,150,20);
        campoTexto2.setBounds(120,50,150,20);
        campoTexto3.setBounds(120,90,150,20);
        etiq1.setBounds(70,10,150,20);
        etiq2.setBounds(70,50,150,20);
        etiq3.setBounds(70,90,150,20);
        add(campoTexto1);
        add(campoTexto2);
        add(campoTexto3);
        add(etiq1);
        add(etiq2);
        add(etiq3);
        EventosDeFoco foco = new EventosDeFoco();
        campoTexto1.addFocusListener(foco);
        campoTexto2.addFocusListener(foco);

    }
    private JTextField campoTexto1,campoTexto2,campoTexto3;
    private JLabel etiq1,etiq2,etiq3;
}
