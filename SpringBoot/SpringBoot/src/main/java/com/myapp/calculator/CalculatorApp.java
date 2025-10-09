package com.myapp.calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private TextField display = new TextField();
    private CalculatorController controller = new CalculatorController();

    @Override
    public void start(Stage primaryStage) {
        display.setEditable(false);
        display.setPrefHeight(50);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);

        String[] buttons = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", "C", "=", "+"
        };

        int row = 0, col = 0;
        for (String text : buttons) {
            Button btn = new Button(text);
            btn.setPrefSize(50, 50);
            btn.setOnAction(e -> onButtonClick(text));
            grid.add(btn, col, row);
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }

        VBox root = new VBox(10, display, grid);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 240, 300);

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onButtonClick(String text) {
        try {
            String result = controller.processInput(text);
            display.setText(result);
        } catch (ArithmeticException ex) {
            display.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
