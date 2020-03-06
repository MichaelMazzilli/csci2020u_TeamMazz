// CSCI2020 Assignment 1, Question 1
// Made by Michael Mazzilli 100702741
// March 5, 2020
// This program is used to randomly generate 3 unique cards on the screen from the deck
package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends Application {

    // Generates 3 unique cards from the deck
    public static int[] randomCards() {

        // Puts the possible card numbers into an arraylist that will help with unique selection
        ArrayList cardNums = new ArrayList();
        for(int i = 0; i < 54; i++) {
            cardNums.add(i+1);
        }

        // Shuffles around the arraylist so that card selection is random
        Collections.shuffle(cardNums);

        // Takes the first 3 cards from the arraylist since it has all been randomised
        int cards[] = new int[3];
        for (int i = 0; i < 3; i++){
            cards[i] = (int) cardNums.get(i);
        }
        return cards;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));

        // Select the cards to be displayed
        int[] cards = randomCards();

        // Sets the cards on the pane
        for(int i = 0; i < 3; i++) {
            ImageView cardImage = new ImageView(new Image(new FileInputStream("C:\\Cards\\" + cards[i] + ".png")));
            cardImage.setPreserveRatio(true);
            cardImage.setFitHeight(200);
            pane.getChildren().add(cardImage);
        }

        // Display the pane
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Question 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
