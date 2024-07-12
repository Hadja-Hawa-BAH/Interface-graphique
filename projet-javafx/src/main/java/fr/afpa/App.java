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
        stage.setTitle("Formulaire");
         
       

        //Taille des boutons
        Double buttonWidth = 100.0;
        Double buttonHeight = 100.0;

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

        // Création d'un gridpane
        GridPane gridPane = new GridPane();

        gridPane.add(label1, 0, 0);
        gridPane.add(field1, 1, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(field2, 1, 1);

        // Methode1: Ajout des gestionnaires d'événements pour les boutons
        button3.setOnAction(new ButtonEventHandlerController());

        // //Méthode 2: fonction lambda(fonction flêchée)
        // button3.setOnAction((ActionEvent event) ->{
        // Platform.exit();
        // });
        // button3.setOnAction(event -> {

        // });

        //

        // Création du conteneur
        VBox vBox = new VBox(button1, button2, button3);
        vBox.setPrefSize(200, 50);
        vBox.setAlignment(Pos.BASELINE_RIGHT);
        vBox.setSpacing(10);
  
      
        gridPane.add(vBox, 2, 0);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle("-fx-background-color: lightyellow; -fx-padding: 10");
       

        // Création de la scène et ajout du conteneur
        Scene scene = new Scene(gridPane, 500, 200);

        //couleur arrière plan
        scene.setFill(Color.LIGHTYELLOW);
        scene.getRoot().setStyle("-fx-background-color: lightyellow");

        stage.setScene(scene);
        stage.centerOnScreen();
        // stage.setFill(Color.BLUE);
        // stage.getRoot().setStyle("-fx-background-color: lightyellow");
      
        // Affichage de la fenêtre
        stage.show();

    }

}