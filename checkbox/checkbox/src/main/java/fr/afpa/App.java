package fr.afpa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("");

        // Création des labels couleurs et les sliders
        Label rouge = new Label("Rouge");
        Slider redSlider = new Slider(0, 255, 0);

        Label vert = new Label("Vert");
        Slider greenSlider = new Slider(0, 255, 0);

        Label bleu = new Label("Bleu");
        Slider blueSlider = new Slider(0, 255, 0);

        // Création du textfield pour la saisie
        TextField textField = new TextField();
        textField.setPromptText("Saisissez votre texte");

        Label labelResult = new Label();
        
        VBox vBox = new VBox(10);

        String[] array = { "Couleur de fond", "Couleur des caractères", "Couleur de fond" };

        for (String option : array) {
            CheckBox checkBox = new CheckBox(option);
            checkBox.setIndeterminate(false);
            vBox.getChildren().add(checkBox);
        }

        TitledPane titledPane = new TitledPane("Paramètres label", vBox);
        VBox finalVBox = new VBox(10, textField, labelResult, titledPane);

        // Création fond
        VBox vBoxFont = new VBox(10);
        String[] arrayFont = { "Rouge", "Vert", "Bleu" };

        for (String optionFont : arrayFont) {
            RadioButton radioButton = new RadioButton(optionFont);
            radioButton.setSelected(false);
            vBoxFont.getChildren().add(radioButton);
        }

        TitledPane titledPaneFont = new TitledPane("Font", vBoxFont);
        VBox finalFont = new VBox(10, titledPaneFont);

        // Création de la couleur des caractères
        VBox sliderVBox = new VBox(rouge, redSlider, vert, greenSlider, bleu, blueSlider);
        TitledPane titledPaneCharColor = new TitledPane("Couleur des caractères", sliderVBox);

        //Mettre à jour le laberrresult lorsque le texte est modifié
        textField.textProperty().addListener((observable, oldValue, newValue) -> { labelResult.setText(newValue);});
        // Mettre la couleur sur le texte avec les sliders
        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(labelResult, redSlider, greenSlider, blueSlider));
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(labelResult, redSlider, greenSlider, blueSlider));
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(labelResult, redSlider, greenSlider, blueSlider));

        // Création du camelcase
        VBox vBoxCamelCase = new VBox(10);
        String[] arrayCamelCase = {"Majuscule", "Minuscule"};

        for (String camelCase : arrayCamelCase) {
            RadioButton camelCaseBox = new RadioButton(camelCase);
            camelCaseBox.setSelected(false);
            vBoxCamelCase.getChildren().add(camelCaseBox);
        }

        TitledPane titledPaneCamel = new TitledPane("Casse", vBoxCamelCase);
        VBox finalCamel = new VBox(10, titledPaneCamel);

        // Vbox finale //finalCharColor
        VBox allVBox = new VBox(10, finalVBox, finalFont, titledPaneCharColor, finalCamel);
        TitledPane mainTitledPane = new TitledPane("CheckBox - Radiobutton - Slider", allVBox);
        
        Scene scene = new Scene(mainTitledPane, 640, 600);
        stage.setScene(scene);
        stage.show();
    }

    // Methode pour mettre à jour la couleur des textes saisis
    private void updateColor(Label label, Slider redSlider, Slider greenSlider, Slider blueSlider) {
        int rouge = (int) redSlider.getValue();
        int vert = (int) greenSlider.getValue();
        int bleu = (int) blueSlider.getValue();

        String hexaColor = String.format("#%02x%02x%02x", rouge, vert, bleu);
        label.setStyle("-fx-text-fill:" + hexaColor);
    }

}