package fr.uvsq.iutvelizy.proj2.javafxproj2.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class ApplicationMain extends Application {
    public void start(Stage stage){
        stage.setTitle("Hello JavaFX");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
