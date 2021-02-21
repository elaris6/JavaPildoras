package com.example.ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Calculadora {

    public static void main(String[] args) {

        CalculadoraVentana ventanaCalc = new CalculadoraVentana();
    }
}

class CalculadoraVentana extends JFrame {

    public CalculadoraPanelPrincipal panel;

    public CalculadoraVentana(){

        setSize(260,360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calculadora");

        panel = new CalculadoraPanelPrincipal();
        add(panel);

        setVisible(true);
    }
}

class CalculadoraPanelPrincipal extends JPanel implements ActionListener {

    private JButton visor = new JButton("0");
    private JButton visorSec = new JButton("0");

    private JButton botonCancel = new JButton("C");

    private String[] operaciones = {"+","-","*","/","="};

    private CalculadoraProcesos calculadora;

    /* Creamos este panel fuera del constructor, para poder llamarlo
    * desde el método de agregar botón. */
    private JPanel teclado;

    public CalculadoraPanelPrincipal(){

        setLayout(new BorderLayout());

        JPanel panelVisor = new JPanel();
        add(panelVisor,BorderLayout.NORTH);
        panelVisor.setLayout(new BorderLayout());
        panelVisor.add(visor,BorderLayout.NORTH);
        panelVisor.add(visorSec,BorderLayout.SOUTH);

        visor.setEnabled(false);
        visorSec.setEnabled(false);

        teclado = new JPanel();
        add(teclado,BorderLayout.CENTER);
        teclado.setLayout(new GridLayout(4,4));

        JPanel cancelPanel = new JPanel();
        cancelPanel.setLayout(new BorderLayout());
        add(cancelPanel,BorderLayout.SOUTH);
        cancelPanel.add(botonCancel,BorderLayout.CENTER);

        calculadora = new CalculadoraProcesos();
        botonCancel.addActionListener(this);

        agregaBoton("7");
        agregaBoton("8");
        agregaBoton("9");
        agregaBoton("*");
        agregaBoton("4");
        agregaBoton("5");
        agregaBoton("6");
        agregaBoton("-");
        agregaBoton("1");
        agregaBoton("2");
        agregaBoton("3");
        agregaBoton("+");
        agregaBoton("0");
        agregaBoton(",");
        agregaBoton("=");
        agregaBoton("/");

    }
    /* Sustituimos todas las inicializaciones por un método que
    cree el botón, lo añada al panel de teclado y active el listener. */
    private void agregaBoton(String textoBoton) {

        JButton boton = new JButton(textoBoton);
        teclado.add(boton);
        boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton botonPulsado = (JButton) e.getSource();

        if (botonPulsado == botonCancel) {
            System.out.println(botonPulsado.getText());
            calculadora.setCancel();
        }
        else if (Arrays.asList(operaciones).contains(botonPulsado.getText())){
            System.out.println(botonPulsado.getText());
            calculadora.setOperacion(botonPulsado.getText());
        }
        else {
            System.out.println(botonPulsado.getText());
            if (visor.getText().equals("0")) {
                if (botonPulsado.getText().equals(",")) {
                    visor.setText("0.");
                }
                else {
                    visor.setText(botonPulsado.getText());
                }
            }
            else if (botonPulsado.getText().equals(",")){
                if (visor.getText().indexOf(".") == -1){
                    visor.setText(visor.getText()+".");
                }
            }
            else {
                Double visorTemp = Double.parseDouble(visor.getText());
                if (visorTemp % 1 == 0) {
                    visor.setText(String.valueOf((visorTemp * 10) + Double.parseDouble(botonPulsado.getText())));
                }
                else {
                    visor.setText(visor.getText()+botonPulsado.getText());
                }
            }
        }
    }

    class CalculadoraProcesos {

        private double resultado;
        private String operacion;

        public CalculadoraProcesos(){
            resultado = 0;
            operacion = "";
        }

        public void setCancel(){
            this.operacion = "";
            this.resultado = 0;
            visor.setText("0");
            visorSec.setText("0");
        }

        public void setOperacion(String oper) {
            if (this.operacion.equals("")) {
                if (oper.equals("=")){
                    this.resultado = Double.parseDouble(visor.getText());
                }
                else {
                    this.operacion = oper;
                    this.resultado = Double.parseDouble(visor.getText());
                    visorSec.setText(visor.getText());
                    visor.setText("0");
                }
            }
            else {
                switch(this.operacion){
                    case ("+"):
                        this.resultado += Double.parseDouble(visor.getText());
                        break;
                    case("-"):
                        this.resultado -= Double.parseDouble(visor.getText());
                        break;
                    case("*"):
                        this.resultado *= Double.parseDouble(visor.getText());
                        break;
                    case("/"):
                        if (!visor.getText().equals("0")){
                            this.resultado /= Double.parseDouble(visor.getText());
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"No se puede dividir por 0, animal!!!");
                        }
                        break;
                }
                visor.setText(String.valueOf(this.resultado));
                if (!oper.equals("=")) {
                    this.operacion = oper;
                    visorSec.setText(visor.getText());
                    visor.setText("0");
                }
                else {
                    visorSec.setText("0");
                    this.operacion = "";
                }
            }
        }
    }
}
