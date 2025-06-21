package com.virtunexa.week2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class AsciiFxApp extends Application {
    private TextField inputField;
    private Label resultLabel;
    private TextArea historyArea;
    private List<String> history = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ASCII Value Converter (JavaFX)");

        // Input components
        inputField = new TextField();
        inputField.setPromptText("Enter a character");
        Button convertButton = new Button("Convert");

        // Output components
        resultLabel = new Label("Result will appear here.");
        historyArea = new TextArea();
        historyArea.setEditable(false);

        // Layout
        VBox inputBox = new VBox(10, new Label("Enter a character:"), inputField, convertButton);
        VBox outputBox = new VBox(10, resultLabel, new Label("History:"), historyArea);
        VBox mainBox = new VBox(20, inputBox, outputBox);
        mainBox.setPadding(new javafx.geometry.Insets(20));

        // Event handler
        convertButton.setOnAction(e -> {
            String input = inputField.getText();
            if (input.length() == 1) {
                char c = input.charAt(0);
                int ascii = (int) c;
                resultLabel.setText("ASCII value of '" + c + "' is " + ascii);
                String entry = c + " → " + ascii;
                history.add(entry);
                historyArea.appendText(entry + "\n");
                inputField.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Input");
                alert.setContentText("Please enter exactly one character.");
                alert.showAndWait();
            }
        });

        // Set scene and show stage
        primaryStage.setScene(new Scene(mainBox, 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
