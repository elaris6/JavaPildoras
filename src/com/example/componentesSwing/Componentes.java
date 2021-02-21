package com.example.componentesSwing;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*  COMPONENTES SWING

    JCheckBox - casillas de verificación. Métodos importantes: isSelected(), setSelected(boolean)
    https://docs.oracle.com/javase/7/docs/api/javax/swing/JCheckBox.html

    JRadioButton - botones radio.
    https://docs.oracle.com/javase/7/docs/api/javax/swing/JRadioButton.html

    JTextField - cuadro de texto. Hereda de JTextComponent. Métodos importantes setText(), getText()
    https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextField.html

    JTextField hereda de JComponent el método getDocument().
    Tenemos la interfaz Document con el método addDocumentListener() que escucha eventos de tipo DocumentEvent.
    https://docs.oracle.com/javase/7/docs/api/javax/swing/text/Document.html

    Por otro lado tenemos la interfaz DocumentListener para el objeto receptor del evento, que tiene como
    métodos: removeUpdate(), insertUpdate(), changedUpdate(), para capturar cada una de esas acciones.
    https://docs.oracle.com/javase/7/docs/api/javax/swing/event/DocumentListener.html

* */
public class Componentes {

    public static void main(String[] args) {

        VentanaComponentes ventana = new VentanaComponentes();
    }
}

class VentanaComponentes extends JFrame {

    public VentanaComponentes (){

        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Componentes Swing");

        PanelComponentes panel = new PanelComponentes();
        add(panel);

        setVisible(true);
    }
}

class PanelComponentes extends JPanel implements ActionListener {

    JLabel texto;
    JCheckBox negrita, cursiva;
    JRadioButton opcion1, opcion2, opcion3;
    JTextField cuadro1, cuadro2;

    public PanelComponentes() {

        /*Creamos varios sub-panles dentro del panel principal para ubicar los componentes.*/

        setLayout(new GridLayout(4,1));
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);

        /* Creamos un texto sobre el que aplicar estilos como prueba de acción. */

        texto = new JLabel("Texto a formatear");
        texto.setFont(new Font("Courier",Font.PLAIN,18));
        panel1.add(texto);

        /* Creamos los checkbox y los ubicamos en el sub-panel inferior. */

        negrita = new JCheckBox("Negrita");
        cursiva = new JCheckBox("Cursiva");
        panel2.add(negrita);
        panel2.add(cursiva);

        negrita.addActionListener(this);
        cursiva.addActionListener(this);

        /* Creamos un grupo de botones */

        ButtonGroup grupoBotones = new ButtonGroup();

        /* Creamos los radio button y los ubicamos en el panel central. */
        opcion1 = new JRadioButton("Opción 1");
        opcion2 = new JRadioButton("Opción 2");
        opcion3 = new JRadioButton("Opción 3");

        grupoBotones.add(opcion1);
        grupoBotones.add(opcion2);
        grupoBotones.add(opcion3);

        panel3.add(opcion1);
        panel3.add(opcion2);
        panel3.add(opcion3);

        /* Creamos dos cuadros de texto y los ubicamos en su sub-panel */

        cuadro1 = new JTextField(15); // Podemos usar un constructor que admite el número de caracteres de ancho
        cuadro2 = new JTextField(15);

        /* Creamos dos objetos de tipo Document para capturar el documento del interior del cuadro de texto */
        Document doc1 = cuadro1.getDocument();
        Document doc2 = cuadro2.getDocument();

        /* Ponemos a la escucha el objeto Document */
        doc1.addDocumentListener(new EscuchaTexto());
        doc2.addDocumentListener(new EscuchaTexto());

        panel4.add(cuadro1);
        panel4.add(cuadro2);

    }

    private class EscuchaTexto implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("Has introducido texto");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            System.out.println("Has borrado texto");
        }

        /* Este método no aplica a la modiciación del texto del documento, sino a sus propiedades:
        * negrita, fuente, tamaño... */
        @Override
        public void changedUpdate(DocumentEvent e) {
            System.out.println("Has modificado las propiedades del texto");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (negrita.isSelected() && cursiva.isSelected()) texto.setFont(texto.getFont().deriveFont(3));
        else if (!negrita.isSelected() && !cursiva.isSelected()) texto.setFont(texto.getFont().deriveFont(0));
        else if (!negrita.isSelected() && cursiva.isSelected()) texto.setFont(texto.getFont().deriveFont(2));
        else if (negrita.isSelected() && !cursiva.isSelected()) texto.setFont(texto.getFont().deriveFont(1));

        /* Solución del profe
        * int negrita_cursiva = Font.PLAIN; //Font.PLAIN tiene valor 0
        * if () negrita_cursiva+=Font.BOLD; //Font.BOLD tiene valor 1
        * if () negrita_cursiva+=Font.ITALIC; //Font.ITALIC tiene valor 2
        * texto.setFont(texto.getFont().deriveFont(negrita_cursiva));
        */
    }


}

