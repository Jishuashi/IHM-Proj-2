package fr.uvsq.iutvelizy.proj2.javafxproj2.view;

import fr.uvsq.iutvelizy.proj2.javafxproj2.model.ConstantCalendar;
import fr.uvsq.iutvelizy.proj2.javafxproj2.model.DateCalendar;
import fr.uvsq.iutvelizy.proj2.javafxproj2.model.DateCalendarMonth;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class VboxRoot extends VBox
        implements ConstantCalendar {

    public VboxRoot() {
        super();
        StackPane stackPaneMonth = new StackPane();
        ToggleGroup buttonGroup = new ToggleGroup();

        for (int i = 1; i <= 12; i++) {
            DateCalendarMonth monthCalendar = new DateCalendarMonth(i, 2022);

            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);
            tilePane.setPrefRows(monthCalendar.getDates().size() % 7 + 1);

            tilePane.setId("opaque");

            for (String dayShrt : DAY_WEEK_SHRT) {
                Label dayLabel = new Label(dayShrt);
                tilePane.getChildren().add(dayLabel);
            }
            for (DateCalendar date : monthCalendar.getDates()) {

                ToggleButton buttonDate = new ToggleButton(Integer.toString(date.getDay()));

                buttonDate.setToggleGroup(buttonGroup);
                tilePane.getChildren().add(buttonDate);

                buttonDate.setUserData(date);

                buttonDate.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println(buttonDate.getUserData().toString());
                    }
                });

                if (date.getMonth() != monthCalendar.getMonth()) {
                    buttonDate.setId("dateHorsMois");
                }
                if (date.isToday()) {
                    buttonDate.setId("today");
                }
            }
            tilePane.setAccessibleText(MONTH[i - 1]);
            stackPaneMonth.getChildren().add(tilePane);
        }


        getChildren().add(stackPaneMonth);
    }
}


