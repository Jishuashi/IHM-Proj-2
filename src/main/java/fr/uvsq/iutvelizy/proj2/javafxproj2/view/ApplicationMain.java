package fr.uvsq.iutvelizy.proj2.javafxproj2.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class ApplicationMain extends Application {
    public void start(Stage stage){
        VboxRoot vBoxMain = new VboxRoot();
        Scene scene = new Scene(vBoxMain, 250, 150);
        File css = new File("css" + File.separator + "styles.css");
        scene.getStylesheets().add(css.toURI().toString());


        stage.setTitle("Planning 2022");
        stage.setWidth(600);
        stage.setHeight(260);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
