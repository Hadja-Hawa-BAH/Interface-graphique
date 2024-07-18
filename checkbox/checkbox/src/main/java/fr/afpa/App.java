package fr.afpa;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
        textField.setPrefSize(300, 10);

        Label labelResult = new Label();
        // labelResult.setStyle("-fx-text-fill: #000000;");
        VBox vBoxText = new VBox(10, textField, labelResult);
        
        VBox vBox = new VBox(10);

        String[] array = { "Couleur de fond", "Couleur des caractères", "Couleur de fond" };

        for (String option : array) {
            CheckBox checkBox = new CheckBox(option);
            checkBox.setIndeterminate(false);
            vBox.getChildren().add(checkBox);
        }

        TitledPane titledPane = new TitledPane("Paramètres label", vBox);
        HBox hBox1 = new HBox(vBoxText, titledPane);
        hBox1.setSpacing(30.0);
    
        // Création du "font"
        ToggleGroup toggleGroup = new ToggleGroup();
            
        RadioButton redButton = new RadioButton("Rouge");
        RadioButton greeButton = new RadioButton("Vert");
        RadioButton blueButton = new RadioButton("Bleu");

        redButton.setToggleGroup(toggleGroup);
        greeButton.setToggleGroup(toggleGroup);
        blueButton.setToggleGroup(toggleGroup);


        VBox vBoxBackground = new VBox(10, redButton, greeButton, blueButton);
        
        TitledPane titledPaneFont = new TitledPane("Font", vBoxBackground);
        VBox finalFont = new VBox(10, titledPaneFont);

        //Mettre un fond de couleur au texte
        redButton.setOnAction(event -> updateFont(labelResult, "red"));
        greeButton.setOnAction(event -> updateFont(labelResult,"green"));
        blueButton.setOnAction(event -> updateFont(labelResult, "blue"));
        
        // Création de "couleur des caractères"
        VBox sliderVBox = new VBox(rouge, redSlider, vert, greenSlider, bleu, blueSlider);
        TitledPane titledPaneCharColor = new TitledPane("Couleur des caractères", sliderVBox);
        
        //Mettre à jour le labelresult lorsque le texte est modifié
        textField.textProperty().addListener((observable, oldValue, newValue) -> labelResult.setText(newValue));
        
        //Mettre la couleur sur le texte avec les sliders
        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(labelResult, redSlider, greenSlider, blueSlider));
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(labelResult, redSlider, greenSlider, blueSlider));
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(labelResult, redSlider, greenSlider, blueSlider));
        
        // Création de "Casse"
        ToggleGroup toggleGroup2 = new ToggleGroup();

        RadioButton upperButton = new RadioButton("Majuscule");
        RadioButton lowerButton = new RadioButton("Minuscule");
        VBox vBoxCamelCase = new VBox(10, upperButton, lowerButton);

        upperButton.setToggleGroup(toggleGroup2);
        lowerButton.setToggleGroup(toggleGroup2);
      
        //Mettre à jour le labelresult en majuscule ou minuscule
        upperButton.setOnAction(event -> updateTextCase(textField, labelResult, true));
        lowerButton.setOnAction(event -> updateTextCase(textField, labelResult, false));
        
        TitledPane titledPaneCamel = new TitledPane("Casse", vBoxCamelCase);
        HBox hBox2 = new HBox(finalFont, titledPaneCharColor, titledPaneCamel);
        hBox2.setSpacing(50.0);
       
        // Vbox finale 
        VBox allVBox = new VBox(30, hBox1, hBox2);
                        
        Scene scene = new Scene(allVBox, 500, 300);
        stage.setScene(scene);
        stage.show();
    }

    //Methode pour mettre un fond de couleur au texte
    private void updateFont(Label label, String color) {
        // Version avec modification en Java de la couleur de fond
        // déclaration d'un objet de la classe BackgroundFill permettant de changer la couleur
        // d'un label
        BackgroundFill bgFill = null;
        if (color.equals("red")) {
            bgFill = new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY);
        } else if (color.equals("green")) {
            bgFill = new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY);
        } else {
            bgFill = new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY);
        }
        
        label.setBackground(new Background(bgFill));

        // ------- Version avec modification du style CSS du Label
        // label.setStyle("-fx-background-color: " + color + ";");
        // ------- Fin code autre version
    } 
       
    // Methode pour mettre à jour la couleur avec les sliders des textes saisis
    private void updateColor(Label label, Slider redSlider, Slider greenSlider, Slider blueSlider) {
        int rouge = (int) redSlider.getValue();
        int vert = (int) greenSlider.getValue();
        int bleu = (int) blueSlider.getValue();

        String hexaColor = String.format("#%02x%02x%02x", rouge, vert, bleu);

        // Version avec utilisation de Java pour le changement de la couleur de fond du Label
        // dans ce cas il suffit de changer le style CSS du label
        label.setStyle("-fx-text-fill: " + hexaColor + ";");
        
        
        // ------- Version en modifiant le CSS
        // Cas plus complexe car il faut faire attention de ne changer QUE la valeur de la couleur du texte

        // String style = label.getStyle();
        // if (!style.contains("-fx-text-fill")) {
        //     // pas de couleur de texte ajoutée au préalable
        //     // on change le background
        //     label.setStyle(style +  "-fx-text-fill: " + hexaColor + ";");
        // } else {
        //     String newStyle = "";

        //     String[] styleParts = style.split(";");
        //     for (String part : styleParts) {
    
        //         if (part.contains("-fx-text-fill")) {
        //             // une couleur de texte avait déjà été mise
        //             // on va la mettre à jour !
        //             newStyle = newStyle + "-fx-text-fill: " + hexaColor + ";";
        //         } else {
        //             // ce n'est pas un style de couleur de texte (probablement un style de backgroud)
        //             // nous gardons le style
        //             newStyle = newStyle + part + ";";
        //         }
        //     }
        //     label.setStyle(newStyle);
        // }
        // ------- Fin du code permettant d'ajuster le CSS
    }


    //Methode pour mettre en majuscule ou minuscule
    private void updateTextCase(TextField textField, Label labelResult, boolean toUpperCase) {
        String text = textField.getText();

        if (toUpperCase) {

            labelResult.setText(text.toUpperCase());

        } else {

            labelResult.setText(text.toLowerCase());
        }
    }

    

}