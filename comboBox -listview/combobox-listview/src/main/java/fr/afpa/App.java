package fr.afpa;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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
        stage.setTitle("Liste pays");

        // Création des boutons
        Button addOneElement = new Button(">");
        Button addAllElement = new Button(">>");
        Button removeOneElement = new Button("<");
        Button removeAllElement = new Button("<<");
        Button exitButton = new Button("Quitter");
        exitButton.setAlignment(Pos.BASELINE_RIGHT);

        VBox addElement = new VBox(10, addOneElement, addAllElement);
        VBox removeElement = new VBox(10, removeOneElement, removeAllElement);
        VBox elementVBox = new VBox(30, addElement, removeElement);
        elementVBox.setAlignment(Pos.BASELINE_CENTER);

        ObservableList<Country> countriesList = FXCollections.observableArrayList();
        ArrayList<Country> countryList = Country.getCountriesList();

        for (Country country : countryList) {
            countriesList.add(country);
        }

        // Permet d'afficher les pays
        ComboBox<Country> finalComboBox = new ComboBox<Country>(countriesList);

        // Affiche les boutons "Haut" et "Bas"
        UpDownListView<Country> upDownListView = new UpDownListView<Country>();

        Label label = new Label("Pays disponibles:");
        VBox comboBoxCountry = new VBox(10, label, finalComboBox);

        VBox upDownExit = new VBox(10, upDownListView, exitButton);
        HBox finalHBox = new HBox(10);
        finalHBox.getChildren().addAll(comboBoxCountry, elementVBox, upDownExit);

        // // Création de la comboBox
        // ObservableList<Country> comboBoxList = FXCollections.observableArrayList();
        // comboBoxList.add(new Country("Ukraine", "UKR"));
        // comboBoxList.add(new Country("Argentine", "ARG"));
        // ComboBox<Country> comboBox = new ComboBox<Country>(comboBoxList);

        addOneElement.setDisable(true);
        addAllElement.setDisable(true);

        removeOneElement.setDisable(true);
        removeAllElement.setDisable(true);

        finalComboBox.setOnAction(event -> {
<<<<<<< HEAD
            if (finalComboBox.getSelectionModel().getSelectedItem() != null || !finalComboBox.getItems().isEmpty()) {
                addOneElement.setDisable(false);
                addAllElement.setDisable(false);
            }
        });

    

=======
            if (finalComboBox.getSelectionModel().getSelectedItem() != null) {
                addOneElement.setDisable(false);
                addAllElement.setDisable(false);
            } else {
                addOneElement.setDisable(true);
                addAllElement.setDisable(true);
        
            }
        });
       
>>>>>>> 924629909acd0993ce64168d23c3bb41093ec554
        countriesList.addListener(new ListChangeListener<Country>() {

            @Override
            public void onChanged(Change<? extends Country> country) {
                if (upDownListView.getListView().getItems().isEmpty()) {
                    removeOneElement.setDisable(true);
                    removeAllElement.setDisable(true);

                } else {
                    removeOneElement.setDisable(false);
                    removeAllElement.setDisable(false);
                }

                if (countriesList.isEmpty()) {
                    addOneElement.setDisable(false);
                    addAllElement.setDisable(false);
                }

            }
        });


      

        ObservableList<Country> upDownObservableList = FXCollections.observableArrayList();

        // Gestionnaire d'événements
        // Methode pour ajouter un élément
        addOneElement.setOnAction(event -> {
            if (finalComboBox.getSelectionModel().getSelectedItem() != null || !finalComboBox.getItems().isEmpty()) {
                upDownObservableList.add(finalComboBox.getValue());
                upDownListView.setObjectsList(upDownObservableList);
                finalComboBox.getItems().remove(finalComboBox.getValue());
            }

        });

        addAllElement.setOnAction(event -> {
            upDownObservableList.addAll(finalComboBox.getItems());
            upDownListView.setObjectsList(upDownObservableList);
            finalComboBox.getItems().clear();
        });

        Country country = upDownListView.getListView().getSelectionModel().getSelectedItem();
        removeOneElement.setOnAction(event -> {

            finalComboBox.getItems().add(country);
            upDownListView.getObjectsList().remove(country);

        });

        removeAllElement.setOnAction(event -> {

            finalComboBox.getItems().addAll(upDownListView.getObjectsList());
            upDownListView.getObjectsList().clear();
        });

        // Méthode pour fermer l'application avec le bouton "Quitter"
        exitButton.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

        Scene scene = new Scene(finalHBox, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

}