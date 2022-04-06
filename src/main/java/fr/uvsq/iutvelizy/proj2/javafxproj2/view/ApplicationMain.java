package fr.uvsq.iutvelizy.proj2.javafxproj2.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class ApplicationMain extends Application {
    public void start(Stage stage){
        VboxRoot vBoxMain = new VboxRoot();
        Scene scene = new Scene(vBoxMain, 800, 600);
        File css = new File("css" + File.separator + "styles.css");
        scene.getStylesheets().add(css.toURI().toString());

        stage.setTitle("Hello JavaFX");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
