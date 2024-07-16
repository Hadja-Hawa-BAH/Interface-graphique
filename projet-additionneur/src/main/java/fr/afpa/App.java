package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private int sum;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("");

        // Taille des boutons
        Double buttonWidth = 80.0;
        Double buttonHeight = 20.0;

        Label label = new Label("Additionneur");
        label.setAlignment(Pos.TOP_CENTER);

        // Création du textArea
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setPrefWidth(400);
        textArea.setWrapText(true);
        // textArea.build();

        // Création du scrollpane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefWidth(400);
        scrollPane.setPrefHeight(180);

        // Création de la gridpane sour les chiffres
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Création bouton "vider"
        Button deleteAll = new Button("Vider");
        deleteAll.setPrefSize(buttonWidth, buttonHeight);

        // Methode de boucle pour les boutons en chiffres
        for (int i = 0; i <= 9; i++) {
            Button buttons = new Button(String.valueOf(i));

            // Gestionnaire d'événements
            buttons.setOnAction(event -> {
                String text = textArea.getText();
                Button clickedButton = (Button) event.getTarget();
                String buttonText = clickedButton.getText();

                sum += Integer.valueOf(clickedButton.getText());

                if (text == null) {
                    textArea.setText(buttonText);

                } else {
                    textArea.setText(text + "+" + buttonText);

                }
            });

            if (i < 5) {
                gridPane.add(buttons, i, 0);

            } else {
                gridPane.add(buttons, i - 5, 1);
            }
        }

        // Gestionnaire d'événements pour le bouton "vider"
        deleteAll.setOnAction(event -> textArea.clear());

        // Création des buttons vider et calculer
        Button calculate = new Button("Calculer");
        calculate.setPrefSize(buttonWidth, buttonHeight);

        // Gestionnaire d'événements pour calculer
        calculate.setOnAction(event -> {
            //textArea.setText(String.valueOf(sum));
            textArea.appendText("=" + String.valueOf(sum)+ "+");

        });

        GridPane operatorGridPane = new GridPane();
        operatorGridPane.add(deleteAll, 0, 4);
        operatorGridPane.add(calculate, 1, 4);
        operatorGridPane.setAlignment(Pos.CENTER);
        operatorGridPane.setHgap(5);
        operatorGridPane.setVgap(5);

        VBox vBox = new VBox(10, scrollPane, gridPane, operatorGridPane);

        VBox allVBox = new VBox(vBox);

        Scene scene = new Scene(allVBox, 400, 300);

        stage.setScene(scene);
        stage.show();

    }

}