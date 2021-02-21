package com.example.ejercicios;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class EditorTextoSimple {

    public static void main(String[] args) {

        VentanaPrincipal ventana = new VentanaPrincipal();
    }
}
class VentanaPrincipal extends JFrame {

    public VentanaPrincipal (){

        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Editor texto simple");

        PanelPrincipal panel = new PanelPrincipal();
        add(panel);

        setVisible(true);
    }
}

class PanelPrincipal extends JPanel implements ActionListener {

    JMenuItem abrir, guardarComo, salir;
    JMenuItem arial, monospaced, sansSerif;
    JMenuItem negrita, cursiva, subraya;
    JMenuItem negro, rojo, verde, azul;
    JMenuItem ocho, doce, dieciseis, veinte;
    //JMenuItem[] arrayTam = {ocho,doce,dieciseis,veinte};
    JMenuItem[] arrayTam = new JMenuItem[4];
    JEditorPane textPane;
    StyledEditorKit editorKit;

    public PanelPrincipal (){

        /* Creamos la barra principal del menú.  */
        JMenuBar barraMenu = new JMenuBar();

        /* Creamos las opciones de menú, para la barra principal del menú. */

        JMenu opcionArc = new JMenu("Archivo");
        JMenu opcionEdi = new JMenu("Edición Texto");

        /* Asociamos las opciones a la barra principal de menú. */

        barraMenu.add(opcionArc);
        barraMenu.add(opcionEdi);

        /* Creamos items de las opciones principales del menú y los agregamos a su opción de menú. */

        // Archivo
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem guardarComo = new JMenuItem("Guardar como");
        salir = new JMenuItem("Salir");

        opcionArc.add(abrir);
        opcionArc.add(guardarComo);
        opcionArc.addSeparator(); // Agregar un separador de menú
        opcionArc.add(salir);
        salir.addActionListener(this);

        // Edición Texto
        JMenu famFuente = new JMenu("Fuente");
        arial = new JMenuItem("Arial");
        monospaced = new JMenuItem("Monospaced");
        sansSerif = new JMenuItem("Sans Serif");
        famFuente.add(arial);
        famFuente.add(monospaced);
        famFuente.add(sansSerif);
        arial.addActionListener(this);
        monospaced.addActionListener(this);
        sansSerif.addActionListener(this);

        JMenu estFuente = new JMenu("Estilo");
        negrita = new JMenuItem("Negrita");
        cursiva = new JMenuItem("Cursiva");
        subraya = new JMenuItem("Subrayado");
        estFuente.add(negrita);
        estFuente.add(cursiva);
        estFuente.add(subraya);
        negrita.addActionListener(this);
        cursiva.addActionListener(this);
        subraya.addActionListener(this);


        JMenu colFuente = new JMenu("Color");
        negro = new JMenuItem("Negro");
        rojo = new JMenuItem("Rojo");
        verde = new JMenuItem("Verde");
        azul = new JMenuItem("Azul");
        colFuente.add(negro);
        colFuente.add(rojo);
        colFuente.add(verde);
        colFuente.add(azul);
        negro.addActionListener(this);
        rojo.addActionListener(this);
        verde.addActionListener(this);
        azul.addActionListener(this);

        JMenu tamFuente = new JMenu("Tamaño");
        ocho = new JMenuItem("8");
        doce = new JMenuItem("12");
        dieciseis = new JMenuItem("16");
        veinte = new JMenuItem("20");
        arrayTam[0] = ocho;
        arrayTam[1] = doce;
        arrayTam[2] = dieciseis;
        arrayTam[3] = veinte;
        tamFuente.add(ocho);
        tamFuente.add(doce);
        tamFuente.add(dieciseis);
        tamFuente.add(veinte);
        ocho.addActionListener(this);
        doce.addActionListener(this);
        dieciseis.addActionListener(this);
        veinte.addActionListener(this);

        opcionEdi.add(famFuente);
        opcionEdi.add(estFuente);
        opcionEdi.add(colFuente);
        opcionEdi.add(tamFuente);

        /* IMPORTANTE: No se debe agregar la barra al panel, hasta que esté completa. */
        /* Creamos dos paneles para ubicar la barra de menú y el área de texto. */
        setLayout(new BorderLayout());

        JPanel panelSup = new JPanel();
        panelSup.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelSup.add(barraMenu);

        add(panelSup,BorderLayout.NORTH);

        /* Buscar como se usa StyleEditorKit
        https://www.javatips.net/api/javax.swing.text.stylededitorkit */

        textPane = new JEditorPane();
        JScrollPane scrollPane = new JScrollPane(textPane,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        editorKit = new StyledEditorKit();
        textPane.setEditorKit(editorKit);
        textPane.setPreferredSize(new Dimension(600,400));

        JPanel panelCen = new JPanel();
        add(panelCen,BorderLayout.CENTER);

        panelCen.add(scrollPane);

        JPopupMenu barraPop = new JPopupMenu();
        barraPop.add(negrita);
        barraPop.add(cursiva);
        barraPop.add(subraya);
        /* Añadimos el Popup menú al JEditorPane para que sea accesible desde este elemento.
        * De otra forma, solo sería usable en los espacios del panel padre. */
        textPane.setComponentPopupMenu(barraPop);

        JToolBar barra = new JToolBar("barraLateral");
        barra.add(this.incluyeBarra(negro.getAction(),new ImageIcon("src/com/example/componentesSwing/bola_negra.gif")));
        barra.add(this.incluyeBarra(rojo.getAction(),new ImageIcon("src/com/example/componentesSwing/bola_roja.gif")));
        barra.add(this.incluyeBarra(verde.getAction(),new ImageIcon("src/com/example/componentesSwing/bola_verde.gif")));
        barra.add(this.incluyeBarra(azul.getAction(),new ImageIcon("src/com/example/componentesSwing/bola_azul.gif")));

        add(barra,BorderLayout.WEST);

    }

    private Action incluyeBarra (Action a, Icon icon) {

        a.putValue(Action.SMALL_ICON, icon);
        return a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == salir) System.exit(0);
        // Opciones estilo
        if (e.getSource() == negrita) new StyledEditorKit.BoldAction().actionPerformed(e);
        if (e.getSource() == cursiva) new StyledEditorKit.ItalicAction().actionPerformed(e);
        if (e.getSource() == subraya) new StyledEditorKit.UnderlineAction().actionPerformed(e);
        // Opciones tamaño
        if (Arrays.asList(arrayTam).contains((JMenuItem) e.getSource())) {
            JMenuItem tam = (JMenuItem) e.getSource();
            new StyledEditorKit.FontSizeAction("cambioTam",Integer.parseInt(tam.getText())).actionPerformed(e);
        }
        // Opciones color
        if (e.getSource() == negro) new StyledEditorKit.ForegroundAction("cambioCol", Color.BLACK).actionPerformed(e);
        if (e.getSource() == rojo) new StyledEditorKit.ForegroundAction("cambioCol",Color.RED).actionPerformed(e);
        if (e.getSource() == verde) new StyledEditorKit.ForegroundAction("cambioCol",Color.GREEN).actionPerformed(e);
        if (e.getSource() == azul) new StyledEditorKit.ForegroundAction("cambioCol",Color.BLUE).actionPerformed(e);
        // Opciones familia fuente
        if (e.getSource() == arial) new StyledEditorKit.FontFamilyAction("cambioFue", "Arial").actionPerformed(e);
        if (e.getSource() == monospaced) new StyledEditorKit.FontFamilyAction("cambioFue", "Monospaced").actionPerformed(e);
        if (e.getSource() == sansSerif) new StyledEditorKit.FontFamilyAction("cambioFue", "Serif").actionPerformed(e);
    }
}
