package fr.uvsq.iutvelizy.proj2.javafxproj2.view;

import fr.uvsq.iutvelizy.proj2.javafxproj2.model.DateCalendar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VboxRoot extends Application {
    public void start(Stage stage){
        VBox root = new VBox();
        Scene scene = new Scene(root, 300, 80);

        DateCalendar date = new DateCalendar();


        Label labelTodayDate = new Label(date.toString());
        root.getChildren().add(labelTodayDate);
        Label labelTomorowDate = new Label(date.tomorrowDate().toString());
        root.getChildren().add(labelTomorowDate);


        stage.setScene(scene);
        stage.setTitle("Hello Java FX");
        stage.show();
    }
}
