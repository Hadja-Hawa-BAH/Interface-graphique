package fr.afpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    private Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("");

        // Taille des boutons
        Double buttonWidth = 100.0;
        Double buttonHeight = 100.0;

        Label formulaire = new Label("Formulaire");
        formulaire.setFont(new Font("Arial", 14));
        formulaire.setAlignment(Pos.CENTER);
      

        Label label1 = new Label("Entrée utilisateur");
        label1.setFont(new Font("Arial", 14));

        TextField field1 = new TextField();
        field1.setPromptText("Saisissez un texte");

        Label label2 = new Label("Copie de l'entrée");
        label2.setFont(new Font("Arial", 14));

        TextField field2 = new TextField();
        field2.setPromptText("Saisissez un texte");

        // Création des boutons
        Button button1 = new Button("Recopier");
        button1.setTextAlignment(TextAlignment.JUSTIFY);
        button1.setPrefSize(buttonWidth, buttonHeight);

        Button button2 = new Button("Effacer");
        button2.setTextAlignment(TextAlignment.JUSTIFY);
        button2.setPrefSize(buttonWidth, buttonHeight);

        Button button3 = new Button("Quitter");
        button3.setTextAlignment(TextAlignment.JUSTIFY);
        button3.setPrefSize(buttonWidth, buttonHeight);

        // Création du conteneur pour les boutons
        VBox vBoxButtons = new VBox(button1, button2, button3);
        vBoxButtons.setPrefSize(200, 50);
        //vBoxButtons.setAlignment(Pos.CENTER_LEFT);
        vBoxButtons.setSpacing(5);

        // Création d'un gridpane
        GridPane gridPane = new GridPane();

        gridPane.add(label1, 0, 0);
        gridPane.add(field1, 1, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(field2, 1, 1);
        gridPane.add(vBoxButtons, 2, 0);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.BASELINE_RIGHT);

        // Methode1: Ajout des gestionnaires d'événements pour les boutons
        button3.setOnAction(new ButtonEventHandlerController());

        // //Méthode 2: fonction lambda(fonction flêchée)
        // button3.setOnAction((ActionEvent event) ->{
        // Platform.exit();
        // });
        // button3.setOnAction(event -> {

        // });

        
        VBox finalVBox = new VBox(formulaire, gridPane);
        finalVBox.setAlignment(Pos.CENTER);
        finalVBox.setSpacing(20);
        finalVBox.setStyle("-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-radius: 5;" +
        "-fx-border-color: #34a4df;" +
        "-fx-background-color : #ede9e3;" +
        "-fx-effect: dropshadow(gaussian,  grey, 10, 0, 5, 5);");
        finalVBox.setPadding(new Insets(20));

        // Création de la scène et ajout du conteneur
        Scene scene = new Scene(finalVBox, 500, 250);

        // couleur arrière plan
        scene.setFill(Color.LIGHTYELLOW);
        scene.getRoot().setStyle("-fx-background-color: lightyellow");

        stage.setScene(scene);
      
        // Affichage de la fenêtre
        stage.show();

    }

}