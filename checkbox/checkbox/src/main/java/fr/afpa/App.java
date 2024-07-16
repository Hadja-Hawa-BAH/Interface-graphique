package fr.afpa;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
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
        stage.setTitle("CheckBox - Radiobutton - Slider");

        // Création du textfield pour la saisie
        TextField textField = new TextField();
        textField.setPromptText("Saisissez votre texte");
        // System.out.println(textField);

        Label label = new Label();
        // System.out.println("Bonjour tout le monde");

        Label Parameter = new Label("Paramètres label");

        // Création du TitledPane
        // TitledPane titledPane = new TitledPane(10, Parameter );
        VBox vBox = new VBox(10, Parameter);
        String[] array = { "Couleur de fond", "Couleur des caractères", "Couleur de fond" };

        for (String option : array) {
            CheckBox checkBox = new CheckBox(option);
            checkBox.setIndeterminate(false);
            vBox.getChildren().add(checkBox);
        }

        VBox parametersContent = new VBox(10, label, vBox);
        parametersContent.setAlignment(Pos.CENTER_RIGHT);
        parametersContent.setStyle("-fx- border-color: black");
        TitledPane titledPane = new TitledPane("array", parametersContent);

        VBox finalVBox = new VBox(10, textField, titledPane);

        // Création fond

        Label font = new Label("Fond");

        VBox vBoxFont = new VBox(10, font);
        String[] arrayFont = { "Rouge", "Vert", "Bleu" };

        for (String optionFont : arrayFont) {
            RadioButton radioButton = new RadioButton(optionFont);
            radioButton.setSelected(false);
            vBoxFont.getChildren().add(radioButton);

        }

        VBox fontContent = new VBox(10, font, vBoxFont);

        TitledPane titledPaneFont = new TitledPane("arrayFont", fontContent);

        VBox finalFont = new VBox(10, titledPaneFont);

        // Création de la couleur des caractères
        Label charColor = new Label("Couleur des caractères");
        VBox vBoxCharColor = new VBox(10, charColor);

        
        Label rouge = new Label("Rouge");
        Slider redSlider = new Slider(0, 1, 0.5);
        redSlider.valueProperty().addListener( new ChangeListener<Number>() {
            public void changed(ObservableValue<?extends Number> observable, Number oldValue, Number newValue){
                rouge.setText(rouge.getText());
            }
        });
        
        Slider greenSlider = new Slider(0, 1, 0.5);
        
        Slider blueSlider = new Slider(0, 1, 0.5);

        VBox sliderVBox = new VBox(vBoxCharColor, rouge, redSlider, greenSlider, blueSlider);

        


        // GridPane gridPane = new GridPane();

        // gridPane.setConstraints(rouge, 1, 1);
        // gridPane.add(rouge,1,1);
        // gridPane.setConstraints(vert, 1, 2);
        // gridPane.add(vert, 1, 2);

        // gridPane.setConstraints(bleu, 1, 3);
        // gridPane.add(bleu, 1,2);

    



        // String[] arrayCharColor = { "Rouge", "Vert", "Bleu" };

        // for (String color : arrayCharColor) {
        //     Label colorCheckBox = new Label(color);
        //     vBoxCharColor.getChildren().add(colorCheckBox);
        // }

        // Slider redSlider = new Slider(0, 1, 0.5);
        // vBoxCharColor.getChildren().add(redSlider);

        // Slider greenSlider = new Slider(0, 1, 0.5);
        // vBoxCharColor.getChildren().add(greenSlider);

        // Slider blueSlider = new Slider(0, 1, 0.5);
        // vBoxCharColor.getChildren().add(blueSlider);
        // // redSlider.setShowTickMarks(true);
        // // redSlider.setShowTickLabels(true);

        // GridPane vBoxSlider = new GridPane();
        // vBoxSlider.add(redSlider, 0, 0);
        // vBoxSlider.add(greenSlider, 0, 1);
        // vBoxSlider.add(blueSlider, 0, 2);

        // VBox charColorContnent = new VBox(10, charColor, vBoxCharColor, vBoxSlider);
        // TitledPane titledPaneCharColor = new TitledPane("arrayCharColor", charColorContnent);
        // VBox finalCharColor = new VBox(10, titledPaneCharColor);

         Label casse = new Label("Casse");
         VBox vBoxCamelCase = new VBox(casse);

        String[] arrayCamelCase = { "Majuscule", "Minuscule"};

        for (String camelCase : arrayCamelCase) {
            RadioButton camelCaseBox = new RadioButton(camelCase);
            camelCaseBox.setSelected(false);
            vBoxCamelCase.getChildren().add(camelCaseBox);
        }
        

        VBox camelContent = new VBox(10, casse, vBoxCamelCase);

        TitledPane titledPaneCamel = new TitledPane("arrayFont", camelContent);

        VBox finalCamel = new VBox(10, titledPaneCamel);


        // Vbox finalefinalCharColor
        VBox allVBox = new VBox(10, finalVBox, finalFont, sliderVBox, finalCamel);

        Scene scene = new Scene(allVBox, 640, 600);
        stage.setScene(scene);
        stage.show();
    }

}