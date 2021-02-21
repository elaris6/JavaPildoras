package com.example.ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreaCarpetasFicheros {

    public static void main(String[] args) {

        /* Ejemplo de como usar un JFileChooser para seleccionar solo directorios
         * Copiado de: https://www.rgagnon.com/javadetails/java-0370.html */
        JFrame frame = new JFrame("");
        DemoJFileChooser panel = new DemoJFileChooser();
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        frame.getContentPane().add(panel,"Center");
        frame.setSize(panel.getPreferredSize());
        frame.setVisible(true);

        /*
        // Creación de ventanas de input para la ruta, nombre de carpeta, fichero y contenido.
        CrearElemento elemento = new CrearElemento();
        String rutaCarpeta = JOptionPane.showInputDialog("Introduce la ruta donde crear la carpeta");
        //Probar con JFileChooser
        String nombreCarpeta = JOptionPane.showInputDialog("Introduce el nombre de la carpeta a crear");
        if(elemento.crearCarpeta(rutaCarpeta,nombreCarpeta)) {
            String nombreFichero = JOptionPane.showInputDialog("Introduce el nombre del fichero a crear");
            if(elemento.crearFichero(rutaCarpeta+"/"+nombreCarpeta,nombreFichero)){
                String contenidoFichero = JOptionPane.showInputDialog("Introduce el contenido del fichero");
                if (elemento.escrbirFichero(rutaCarpeta+"/"+nombreCarpeta+"/"+nombreFichero,contenidoFichero)) {
                    JOptionPane.showMessageDialog(null,"Proceso completado correctamente");
                }
                else JOptionPane.showMessageDialog(null,"Algo ha ido mal");
            }
            else JOptionPane.showMessageDialog(null,"Algo ha ido mal");
        }
        else JOptionPane.showMessageDialog(null,"Algo ha ido mal");*/
    }
}

class CrearElemento {

    public boolean crearCarpeta(String ruta, String nombre) {

        ruta = ruta.replace("\\","/");
        File elemento = new File(ruta+"/"+nombre);
        if (elemento.exists()){
            JOptionPane.showMessageDialog(null,"El elemento ya existe");
            return false;
        }
        else {
            return elemento.mkdir();
        }
    }

    public boolean crearFichero(String ruta, String nombre) {

        ruta = ruta.replace("\\","/");
        File elemento = new File(ruta+"/"+nombre);
        if (elemento.exists()){
            JOptionPane.showMessageDialog(null,"El elemento ya existe");
            return false;
        }
        else {
            try {
                return elemento.createNewFile();
            } catch (IOException exception) {
                //exception.printStackTrace();
                return false;
            }
        }
    }

    public boolean escrbirFichero(String ruta, String contenido) {

        ruta = ruta.replace("\\","/");
        File elemento = new File(ruta);
        if (!elemento.exists()){
            JOptionPane.showMessageDialog(null,"El elemento NO existe");
            return false;
        }
        else {
            try {
                FileOutputStream escritor = new FileOutputStream(elemento);

                for(char c:contenido.toCharArray()){
                    escritor.write(c);
                }
                escritor.close();
                return true;

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"No se puede abrir el elmento para escritura");
                return false;
            }
        }
    }
}

class Marco extends JFrame {

    public void Marco (){

        setBounds(100,100,320,240);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Selector de carpeta");

        add(new DemoJFileChooser());

    }
}
/* Ejemplo de como usar un JFileChooser para seleccionar solo directorios
* Copiado de: https://www.rgagnon.com/javadetails/java-0370.html */
class DemoJFileChooser extends JPanel implements ActionListener {
    JButton go;

    JFileChooser chooser;
    String choosertitle;

    public DemoJFileChooser() {
        go = new JButton("Do it");
        go.addActionListener(this);
        add(go);
    }

    public void actionPerformed(ActionEvent e) {
        int result;

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        // Este método es la clave
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // disable the "All files" option.
        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    +  chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    +  chooser.getSelectedFile());
        }
        else {
            System.out.println("No Selection ");
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(320, 240);
    }
}
