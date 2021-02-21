package com.example.ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracticaComponentesSwing {

    public static void main(String[] args) {

        VentanaComponentes ventana = new VentanaComponentes();
    }
}

class VentanaComponentes extends JFrame {

    public VentanaComponentes (){
        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Jugando con componentes Swing");

        MarcoComponentes marco = new MarcoComponentes();
        add(marco);

        setVisible(true);
    }
}

class MarcoComponentes extends JPanel implements ActionListener {

    String usuario = "";
    JTextField nombre, apellidos;
    JTextArea areaTexto;
    JButton boton1, boton2;
    JCheckBox casilla1, casilla2;
    JRadioButton radio1, radio2;

    public MarcoComponentes(){

        setLayout(new BorderLayout());
        JPanel panelSup = new JPanel();
        JPanel panelMed = new JPanel();
        JPanel panelInf = new JPanel();

        add(panelSup,BorderLayout.NORTH);
        add(panelMed,BorderLayout.CENTER);
        add(panelInf,BorderLayout.SOUTH);

        JLabel nombreLabel = new JLabel("Nombre");
        JLabel apellidosLabel = new JLabel("Apellidos");
        nombre = new JTextField(20);
        apellidos = new JTextField(20);
        areaTexto = new JTextArea(20,30);
        areaTexto.setLineWrap(true);
        areaTexto.setEnabled(false);
        areaTexto.setText("Entradas log:");
        JScrollPane scroll = new JScrollPane(areaTexto);
        boton1 = new JButton("Botón 1");
        boton2 = new JButton("Botón 2");
        casilla1 = new JCheckBox("Casilla 1");
        casilla2 = new JCheckBox("Casilla 2");
        radio1 = new JRadioButton("Radio 1");
        radio2 = new JRadioButton("Radio 2");
        ButtonGroup grupoRadio = new ButtonGroup();
        grupoRadio.add(radio1);
        grupoRadio.add(radio2);

        panelSup.add(nombreLabel);
        panelSup.add(nombre);
        panelSup.add(apellidosLabel);
        panelSup.add(apellidos);
        panelMed.add(scroll);
        panelInf.add(boton1);
        panelInf.add(boton2);
        panelInf.add(casilla1);
        panelInf.add(casilla2);
        panelInf.add(radio1);
        panelInf.add(radio2);

        boton1.addActionListener(this);
        boton2.addActionListener(this);
        casilla1.addActionListener(this);
        casilla2.addActionListener(this);
        radio1.addActionListener(this);
        radio2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String usuarioTexto = nombre.getText()+" "+apellidos.getText();
        if (!usuarioTexto.equals(usuario) && (!usuarioTexto.trim().equals(""))) {
            usuario = usuarioTexto;
            areaTexto.setText(areaTexto.getText()+"\n\nAcciones de "+usuario);
        }
        if (usuarioTexto.trim().equals("")) {
            JOptionPane.showMessageDialog(null,"Nombre y Apellidos no pueden estar vacíos.");
        }
        else if (e.getSource() == boton1) {
            areaTexto.setText(areaTexto.getText()+"\nPulsa botón 1");
        }
        else if (e.getSource() == boton2) {
            areaTexto.setText(areaTexto.getText()+"\nPulsa botón 2");
        }
        else if (e.getSource() == casilla1) {
            if (casilla1.isSelected()){
                areaTexto.setText(areaTexto.getText()+"\nActiva casilla 1");
            }
            else areaTexto.setText(areaTexto.getText()+"\nDesactiva casilla 1");
        }
        else if (e.getSource() == casilla2) {
            if (casilla2.isSelected()){
                areaTexto.setText(areaTexto.getText()+"\nActiva casilla 2");
            }
            else areaTexto.setText(areaTexto.getText()+"\nDesactiva casilla 2");
        }
        else if (e.getSource() == radio1) {
            areaTexto.setText(areaTexto.getText()+"\nSelecciona radio 1");
        }
        else if (e.getSource() == radio2) {
            areaTexto.setText(areaTexto.getText()+"\nSelecciona radio 2");
        }

    }
}
