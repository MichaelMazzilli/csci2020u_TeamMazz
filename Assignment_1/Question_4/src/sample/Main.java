// CSCI2020 Assignment 1, Question 4
// Made by Michael Mazzilli 100702741
// March 5, 2020
// This program is used to create a histogram for occurrences of each letter within a text document entered
package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) {

        Histogram histogram = new Histogram();

        // Getting the file path
        TextField text = new TextField("");
        text.setOnAction(e -> histogram.setCounts(text.getText()));
        text.setPrefColumnCount(30);

        // Filename label
        Label lblFile = new Label("Filename", text);
        lblFile.setContentDisplay(ContentDisplay.RIGHT);

        // Setting up button for file path
        Button btnView = new Button("View");
        btnView.setOnAction(e -> histogram.setCounts(text.getText()));

        HBox botBox = new HBox(10);
        botBox.getChildren().addAll(text, lblFile, btnView);

        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(histogram);
        mainPane.setBottom(botBox);

        Scene scene = new Scene(mainPane);
        primaryStage.setTitle("Question 4");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}