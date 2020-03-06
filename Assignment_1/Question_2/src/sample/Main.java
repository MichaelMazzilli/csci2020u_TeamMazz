// CSCI2020 Assignment 1, Question 2
// Made by Michael Mazzilli 100702741
// March 5, 2020
// This program is used to calculate the future value of an investment with a user-entered interest rate and amount of years
package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    // Creating text fields
    private TextField investmentAmount = new TextField();
    private TextField numberOfYears = new TextField();
    private TextField annualInterestRate = new TextField();
    private TextField futureValue = new TextField();
    private Button btCalculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(20));
        futureValue.setEditable(false);

        // Adding labels to the gridpane
        pane.add(investmentAmount, 1, 0);
        pane.add(new Label("Investement Amount:"), 0, 0);
        pane.add(numberOfYears, 1, 1);
        pane.add(new Label("Number of years:"), 0, 1);
        pane.add(annualInterestRate, 1, 2);
        pane.add(new Label("Annual Interes Rate:"), 0, 2);
        pane.add(futureValue, 1, 3);
        pane.add(new Label("Future Value:"), 0, 3);

        // Adding calculation to the gridpane
        btCalculate.setOnAction(e -> futureValue());
        pane.add(btCalculate, 1, 4);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        // Alligning all values in the grid
        investmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
        numberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        annualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        futureValue.setAlignment(Pos.BOTTOM_RIGHT);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Question 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method for calculating the Future Value
    private void futureValue() {
        double investAmount = Double.parseDouble(investmentAmount.getText());
        int years = Integer.parseInt(numberOfYears.getText());
        double monthlyInterestRate = Double.parseDouble(annualInterestRate.getText()) / 1200;
        futureValue.setText(String.format("$%.2f", (investAmount * Math.pow(1 + monthlyInterestRate, years * 12))));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
