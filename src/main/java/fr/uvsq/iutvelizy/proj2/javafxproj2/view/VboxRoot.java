package fr.uvsq.iutvelizy.proj2.javafxproj2.view;

import fr.uvsq.iutvelizy.proj2.javafxproj2.model.ConstantCalendar;
import fr.uvsq.iutvelizy.proj2.javafxproj2.model.DateCalendar;
import fr.uvsq.iutvelizy.proj2.javafxproj2.model.DateCalendarMonth;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;


public class VboxRoot extends VBox
        implements ConstantCalendar {

    static List<String> month = new ArrayList<String>();

    public VboxRoot() {
        super();
        VBox CONTENT = new VBox();
        StackPane stackPaneMonth = new StackPane();
        ToggleGroup buttonGroup = new ToggleGroup();
        HBox labelMonthBox = new HBox();
        HBox buttonBoxPrevNext = new HBox();
        HBox monthButtonBox = new HBox();
        Button prev = new Button("<");
        Button next = new Button(">");
        Button start = new Button("<<");
        Button end = new Button(">>");


        for (int o = 1; o <= 12; o++) {
            month.add(MONTH[o - 1]);
        }

        buttonBoxPrevNext.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(buttonBoxPrevNext, Priority.ALWAYS);
        buttonBoxPrevNext.getChildren().addAll(start, prev, next, end);


        for (int i = 1; i <= 12; i++) {
            DateCalendarMonth monthCalendar = new DateCalendarMonth(i, 2022);

            TilePane tilePane = new TilePane();
            tilePane.setMaxWidth(250);

            tilePane.setId("opaque");

            for (String dayShrt : DAY_WEEK_SHRT) {
                Label dayLabel = new Label(dayShrt);
                tilePane.getChildren().add(dayLabel);
            }
            for (DateCalendar date : monthCalendar.getDates()) {

                ToggleButton buttonDate = new ToggleButton(date.getDayString());

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

        List<Node> listStack = stackPaneMonth.getChildren();

        int monthToday = new DateCalendar().getMonth();
        int indexMonth = (12 - monthToday);

        System.out.println("Mois --> " + indexMonth);

        for (int j = indexMonth; j != 0; j--) {
            listStack.get(listStack.size() - 1).toBack();
        }

        Label monthLabel = new Label(listStack.get(listStack.size() - 1).getAccessibleText());

        prev.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if (!listStack.get(listStack.size() - 1).getAccessibleText().equals("Janvier")) {
                    listStack.get(listStack.size() - 1).toBack();
                    monthLabel.setText(listStack.get(listStack.size() - 1).getAccessibleText());
                }
            }
        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!listStack.get(listStack.size() - 1).getAccessibleText().equals("Décembre")) {
                    listStack.get(0).toFront();
                    monthLabel.setText(listStack.get(listStack.size() - 1).getAccessibleText());
                }
            }
        });

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String str = listStack.get(listStack.size() - 1).getAccessibleText();
                int lMonthIndex = month.indexOf(str);

                if (!str.equals("Janvier")) {
                    for (int n = lMonthIndex; n != 0; n--) {
                        listStack.get(listStack.size() - 1).toBack();
                    }

                    monthLabel.setText(listStack.get(listStack.size() - 1).getAccessibleText());
                }
            }
        });

        end.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String str = listStack.get(listStack.size() - 1).getAccessibleText();
                int lMonthIndex = month.indexOf(str);

                if (!str.equals("Décembre")) {
                    for (int n = lMonthIndex; n != 11; n++) {
                        listStack.get(0).toFront();
                    }

                    monthLabel.setText(listStack.get(listStack.size() - 1).getAccessibleText());
                }
            }
        });

        CONTENT.setId("vbox_style");
        CONTENT.setMaxWidth(275);

        monthButtonBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(monthButtonBox, Priority.ALWAYS);

        labelMonthBox.getChildren().add(monthLabel);
        monthButtonBox.getChildren().addAll(labelMonthBox, buttonBoxPrevNext);
        CONTENT.getChildren().addAll(stackPaneMonth, monthButtonBox);
        getChildren().add(CONTENT);
    }
}