package com.example.interfacesGraficasJavaFX;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

/*  Es necesario implementar la clase abstracta "Application", que nos obliga a
*   implementar a su vez el método "start", llamado desde el main con el método
*   estático "launch".
*   https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html
*   https://docs.oracle.com/javafx/2/get_started/hello_world.htm
*   https://docs.oracle.com/javase/8/javafx/api/toc.htm
*
*   Se construye una estructura del tipo:
*   - escenario(stage) https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html
*   - escena(scene) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html
*   - panel(StackPane) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/StackPane.html
*   y dentro del objeto StackPane se ubican los componentes.
*
* */
public class EstructuraJavaFX extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    /* El método start obliga a la gestión de excepciones y recibe como argumento
    *   un objeto de tipo escenario (stage). */
    @Override
    public void start(Stage escenario) throws Exception {

        /* Construimos un botón y le asignamos una acción. */
        Button boton = new Button("Click aquí");

        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ButtonBase.html#setOnAction-javafx.event.EventHandler-
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Heeeyyyyyy!!!");
            }
        });

        /* Costruimos el StackPane */
        StackPane root = new StackPane();
        // Añadimos el botón al StackPane. Para ello necesitamos el método
        // getChildren() de la clase StackPane
        root.getChildren().add(boton);
        // Contrsuimos la escena. Tiene sobrecarga de constructores, usamos el que nos pide
        // informar de que contendor es padre la escena, y sus dimensiones.
        Scene escena = new Scene(root, 320,240);
        // Asociamos la escena al escenario con método setScene(Scene scene)
        escenario.setScene(escena);
        // Hacemos visible el escenario
        escenario.show();
    }
}
