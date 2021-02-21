package com.example.ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class LecturaEscrituraFichero {


    public static void main(String[] args) {

        Cuadro miCuadro = new Cuadro();

    }
}


class Cuadro extends JFrame {

    public Cuadro() {

        setBounds(500, 500, 500, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new Lamina());

        setVisible(true);

    }

}


class Lamina extends JPanel {

    JButton escribir, borrar, leer;

    JTextArea miArea;

    File fichero = new File("C:/CODE/Java/JavaLearn/src/com/example/ejercicios/fichero_lectura.txt");


    public Lamina() {

        setLayout(new BorderLayout());


        JPanel superior = new JPanel();


        miArea = new JTextArea();


        add(miArea);


        escribir = new JButton("Escribir");

        borrar = new JButton("Borrar");

        leer = new JButton("Leer");


        escribir.addActionListener(new Evento());

        borrar.addActionListener(new Evento());

        leer.addActionListener(new Evento());


        superior.add(escribir);

        superior.add(borrar);

        superior.add(leer);


        add(superior, BorderLayout.SOUTH);


    }


    private class Evento implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == escribir) {

                try {

                    FileWriter entrada = new FileWriter(fichero, true);

                    String texto = miArea.getText();

                    entrada.write(texto);


                    entrada.close();


                } catch (IOException e1) {

                    JOptionPane.showMessageDialog(null, "La ruta está mal");
                }
            }

            else if (e.getSource() == borrar) {
                miArea.setText("");
            }

            else if (e.getSource() == leer) {

                try {

                    FileReader entrada = new FileReader(fichero);

                    BufferedReader miBuffer = new BufferedReader(entrada);


                    String texto = "";


                    while (texto != null) {

                        texto = miBuffer.readLine();

                        if (texto != null)

                            miArea.append(texto+"\n");

                    }

                    entrada.close();


                } catch (IOException e1) {

                    JOptionPane.showMessageDialog(null, "El fichero no existe");
                }
            }
        }
    }
}
