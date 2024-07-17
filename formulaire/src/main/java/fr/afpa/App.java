package fr.afpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
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

        // Création des labels et des textfields
        Label formulaire = new Label("Formulaire");
        formulaire.setFont(new Font("Arial", 14));
        // formulaire.setAlignment(Pos.CENTER);

        Label label1 = new Label("Entrée utilisateur");
        label1.setFont(new Font("Arial", 14));

        TextField fieldInput = new TextField();
        fieldInput.setPromptText("Saisissez un texte");

        Label label2 = new Label("Copie de l'entrée");
        label2.setFont(new Font("Arial", 14));

        TextField fieldCopy = new TextField();
        fieldCopy.setPromptText("Saisissez un texte");

        // Methode pour copier la saisie de l'utilisateur
        // field2.setEditable(true);

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
        vBoxButtons.setAlignment(Pos.CENTER);
        vBoxButtons.setSpacing(5);

        // vBoxButtons.setStyle("-fx-background-color: green;");

        // Création d'un gridpane
        GridPane gridPane = new GridPane();

        gridPane.add(label1, 0, 0);
        gridPane.add(fieldInput, 1, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(fieldCopy, 1, 1);
        gridPane.add(vBoxButtons, 2, 0, 1, 2);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(true);
        
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(50);
        gridPane.getRowConstraints().add(row1);
        gridPane.getRowConstraints().add(row1);

        // GridPane.setHgrow(label1, Priority.ALWAYS);
        // GridPane.setHgrow(fieldInput, Priority.ALWAYS);
        // GridPane.setHgrow(label2, Priority.ALWAYS);
        // GridPane.setHgrow(fieldCopy, Priority.ALWAYS);

        AnchorPane anchorPane = new AnchorPane(gridPane);

        // anchor to the label
        AnchorPane.setTopAnchor(gridPane, 0.0);
        AnchorPane.setLeftAnchor(gridPane, 0.0);
        AnchorPane.setRightAnchor(gridPane, 0.0);
        AnchorPane.setBottomAnchor(gridPane, 0.0);

        // anchorPane.setStyle("-fx-background-color: blue;");

        // Methode pour copier la saisie de l'utilisateur
        button1.setOnAction((ActionEvent event) -> fieldCopy.setText(fieldInput.getText()));
        logger.info("Le texte a été copié");

        // Methode pour effacer les contenus des boutons 1 et 3
        button2.setOnAction((ActionEvent event) -> {
            fieldInput.clear();
            fieldCopy.clear();
            logger.info("les saisies ont été effacées ");
        });

        // Methode1: Ajout des gestionnaires d'événements pour les boutons
        button3.setOnAction(new ButtonEventHandlerController());

        // //Méthode 2: fonction lambda(fonction flêchée)
        // button3.setOnAction((ActionEvent event) ->{
        // Platform.exit();
        // });
        // button3.setOnAction(event -> {

        // });

        VBox finalVBox = new VBox(formulaire, anchorPane);
        finalVBox.setAlignment(Pos.CENTER);
        finalVBox.setSpacing(20);
        finalVBox.setStyle("-fx-color: #ff0000;" + "-fx-border-width: 5px;" + "-fx-border-color: #34a4df;");
        // ("-fx-border-style: solid inside;" +
        // "-fx-border-width: 2;" +
        // "-fx-border-radius: 5;" +
        // "-fx-border-color: #34a4df;" +
        // "-fx-background-color : #ede9e3;" +
        // "-fx-effect: dropshadow(gaussian, grey, 10, 0, 5, 5);");
        finalVBox.setPadding(new Insets(20));
        finalVBox.setFillWidth(true);

        // Création de la scène et ajout du conteneur
        Scene scene = new Scene(finalVBox);

        // couleur arrière plan
        scene.setFill(Color.LIGHTYELLOW);
        scene.getRoot().setStyle("-fx-background-color: lightyellow");

        stage.setScene(scene);

        // Affichage de la fenêtre
        stage.show();

    }

}