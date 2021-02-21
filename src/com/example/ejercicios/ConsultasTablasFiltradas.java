package com.example.ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ConsultasTablasFiltradas {

    public static void main(String[] args) {

        VentanaConsultas ventana = new VentanaConsultas();
        ventana.setVisible(true);

    }
}

class VentanaConsultas extends JFrame {

    public VentanaConsultas(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,640,480);
        setTitle("Consultas a ClassicModels");

        add(new PanelConsultas());
    }
}

class PanelConsultas extends JPanel implements ActionListener {

    JLabel labelVendor,labelLine;
    JComboBox comboVendor, comboLine;
    JButton botonConsulta;
    JTextArea areaTexto;

    public PanelConsultas (){

        labelLine = new JLabel("Línea de productos");
        labelVendor = new JLabel("Vendedores");
        areaTexto = new JTextArea();
        areaTexto.setEnabled(false);
        areaTexto.setBackground(Color.LIGHT_GRAY);
        areaTexto.setDisabledTextColor(Color.BLACK);
        botonConsulta = new JButton("Consulta");
        botonConsulta.addActionListener(this);

        /* Inicializamos combos con consulta a la BBDD */
        comboLine = new JComboBox();
        iniciaCombo(comboLine,"productline");
        comboVendor = new JComboBox();
        iniciaCombo(comboVendor,"productvendor");

        setLayout(new BorderLayout());
        JPanel panelSup = new JPanel();
        panelSup.add(labelLine);
        panelSup.add(comboLine);
        panelSup.add(labelVendor);
        panelSup.add(comboVendor);

        add(panelSup,BorderLayout.NORTH);
        add(areaTexto,BorderLayout.CENTER);
        add(botonConsulta,BorderLayout.SOUTH);
    }

    private void iniciaCombo(JComboBox combo, String column){

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","NatAli_1411");

            /* En este caso no se puede usar un "PreparedStatement" porque las variables son solo para los
            * valores de columnas en DML o cláusulas WHERE, y aquí necesitamos un campo variable en los
            * campos de salida seleccionados. */
            String queryString = "SELECT DISTINCT "+column+" FROM PRODUCTS";
            Statement query = conexion.createStatement();


            ResultSet resultados = query.executeQuery(queryString);
            combo.addItem("all");

            while (resultados.next()) {
                //System.out.println(resultados.getString(1));
                combo.addItem(resultados.getString(1));
            }

            resultados.close();
            conexion.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nEjecutar consulta!\n");
        areaTexto.setText("");

        String queryFinal="SELECT * FROM PRODUCTS";
        String linea = (String) comboLine.getSelectedItem();
        String vendor = (String) comboVendor.getSelectedItem();

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","NatAli_1411");

            PreparedStatement query;
            if (!linea.equals("all") && !vendor.equals("all")) {

                queryFinal = queryFinal+" WHERE PRODUCTLINE = ? AND PRODUCTVENDOR = ?";
                query = conexion.prepareStatement(queryFinal);
                query.setString(1,linea);
                query.setString(2,vendor);
            }
            else if (!linea.equals("all") && vendor.equals("all")) {
                queryFinal = queryFinal+" WHERE PRODUCTLINE = ?";
                query = conexion.prepareStatement(queryFinal);
                query.setString(1,linea);
            }
            else if (linea.equals("all") && !vendor.equals("all")) {
                queryFinal = queryFinal+" WHERE PRODUCTVENDOR = ?";
                query = conexion.prepareStatement(queryFinal);
                query.setString(1,vendor);
            }
            else {
                query = conexion.prepareStatement(queryFinal);
            }

            ResultSet resultados = query.executeQuery();

            int counter = 0;
            while (resultados.next()) {
                counter++;
                String registro = resultados.getString(1)+" | "+resultados.getString(2)+" | "+resultados.getString(3)+" | "+resultados.getString(4)+" | "+resultados.getString(5)+" | "+resultados.getString(7)+" | "+resultados.getString(8)+" | "+resultados.getString(9);
                areaTexto.append(registro+"\n");
            }
            if (counter==0){
                areaTexto.setText("No hay resultados para la búsqueda.");
            }

            resultados.close();
            conexion.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}

