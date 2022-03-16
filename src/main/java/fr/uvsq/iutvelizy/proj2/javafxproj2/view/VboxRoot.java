package fr.uvsq.iutvelizy.proj2.javafxproj2.view;

import fr.uvsq.iutvelizy.proj2.javafxproj2.model.DateCalendar;
import fr.uvsq.iutvelizy.proj2.javafxproj2.model.DateCalendarMonth;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class VboxRoot extends Application {
    public void start(Stage stage){
        VBox root = new VBox();
        Scene scene = new Scene(root, 800, 600);
        File css = new File("src/main/css"+File.separator+"styles.css");
        scene.getStylesheets().add(css.toURI().toString());

        DateCalendar date = new DateCalendar();
        DateCalendarMonth dateMonth = new DateCalendarMonth(3, 2022);
        DateCalendarMonth dateMonth2 = new DateCalendarMonth(4, 2022);
        DateCalendarMonth dateMonth3 = new DateCalendarMonth(5, 2022);


        Label labelTodayDate = new Label(date.toString());
        Label labelTomorowDate = new Label(date.tommorowDate().toString());
        Label labelMonthYears= new Label(dateMonth.getMonth() + " " + dateMonth.getYear());

        VBox boxDates = new VBox();
        Label labelDatesMonth = new Label(dateMonth.toString() + "\n"+ dateMonth2.toString() + "\n" + dateMonth3);

        ScrollPane scrollPaneDates = new ScrollPane();
        scrollPaneDates.setContent(boxDates);

        scrollPaneDates.setId("scroll");
        labelTodayDate.setId("today");


        root.getChildren().add(labelTodayDate);
        root.getChildren().add(labelTomorowDate);
        boxDates.getChildren().add(labelDatesMonth);
        root.getChildren().add(labelMonthYears);
        root.getChildren().add(scrollPaneDates);

        stage.setScene(scene);
        stage.setTitle("Hello Java FX");
        stage.show();
    }
}
