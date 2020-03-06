// CSCI2020 Assignment 1, Question 4
// Made by Michael Mazzilli 100702741
// March 5, 2020
// This class is used to create the histogram used in the main program
package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Histogram extends Pane {

    private double[] counts = new double[26];

    public Histogram() {
        setPrefWidth(250);
        setPrefHeight(350);
    }

    // Counting the occurrences of letters in the text file
    public void setCounts(String filename) {
        try (Scanner input = new Scanner(new File(filename))) {
            while(input.hasNext()) {
                String word = input.next();
                for(int i = 0; i < word.length(); i++) {
                    char c = Character.toUpperCase(word.charAt(i));
                    if (c >= 'A' && c <= 'Z')
                        counts[c - 'A']++;
                }
            }
            redraw();
        } catch(FileNotFoundException ex) { }
    }

    // Normalizing the counts
    private void normalize() {
        double sum = 0;
        for(int i = 0; i < counts.length; i++)
            sum += counts[i];

        for(int i = 0; i < counts.length; i++)
            counts[i] = counts[i] / sum;
    }

    // Redrawing the histogram for a new graph
    private void redraw() {
        getChildren().clear();
        normalize();
        int x = 10;
        double scale = 5;

        // Drawing of the graph
        for(int i = 0; i < counts.length; i++) {
            Rectangle rec = new Rectangle(10, scale * getHeight() * counts[i]);
            rec.setX(x);
            rec.setY(getHeight() - rec.getHeight() - 30);
            rec.setFill(Color.WHITE);
            rec.setStroke(Color.BLACK);
            Text txt = new Text(x + rec.getWidth() / 2 - 3,
                    rec.getY() + rec.getHeight() + 20, Character.toString((char)(i + 'A')));

            getChildren().addAll(rec, txt);
            x += 17;
        }
    }
}