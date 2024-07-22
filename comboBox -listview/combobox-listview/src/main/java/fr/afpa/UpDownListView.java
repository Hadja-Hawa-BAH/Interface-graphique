package fr.afpa;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UpDownListView<Country> extends VBox {
    private Button upButton;
    private Button downButton;
    private ListView<Country> listView;

    private ObservableList<Country> objectsList;
    // private ObservableList<Country> selectedModel;
    // private Country selectedItem;

    public UpDownListView() {

        // Création des boutons images des boutons haut et bas
        // FileInputStream imagFileInputStream = new FileInputStream(
        // getClass().getResource("211623_b_up_arrow_icon.png").getPath());
        // Image imageUp = new Image(imagFileInputStream);
        // ImageView imageView = new ImageView(imageUp);
        // Button buttonUp = new Button("Bouton", imageView);

        // FileInputStream imagFileInputStream1 = new FileInputStream(
        // getClass().getResource("211614_down_b_arrow_icon.png").getPath());
        // Image imageDown = new Image(imagFileInputStream1);
        // ImageView imageView1 = new ImageView(imageDown);
        // Button buttonDown = new Button("Bouton", imageView1);

        // Création des composants graphiques utilisés
        this.upButton = new Button("Haut");
        this.downButton = new Button("Bas");
        this.listView = new ListView<Country>();

        // Gestionnaire d'événements
        upButton.setOnAction(event -> moveUp());
        downButton.setOnAction(event -> moveDown());

        // Positionnement des boutons côte-à-côte, utilisation dun Hbox
        HBox buttonBox = new HBox();
        buttonBox.setSpacing(5);
        buttonBox.getChildren().add(this.upButton);
        buttonBox.getChildren().add(this.downButton);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().add(buttonBox);
        this.getChildren().add(this.listView);
    }

    // Fonction pour associer une "ObservableList" à ce composant
    public void setObjectsList(ObservableList<Country> list) {
        this.objectsList = list;
        listView.setItems(list);

    }

    public ObservableList<Country> getObjectsList() {
        return objectsList;
    }

    public ListView<Country> getListView() {
        return listView;
    }

    // Methode pour le bouton "moveUp"
    public void moveUp() {
        ObservableList<Country> list = listView.getItems();
        Country country = listView.getSelectionModel().getSelectedItem();
        int indexCountry = list.indexOf(country);
        if (indexCountry != 0){
            list.remove(indexCountry);
            indexCountry--;
            list.add(indexCountry,country);
            listView.getSelectionModel().select(indexCountry);
        }
        // int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        // if (selectedIndex != 0) {
        //     ObservableList<Country> items = listView.getItems();
        //     Country item = items.remove(selectedIndex);
        //     items.add(selectedIndex - 1, item);
        //     listView.getSelectionModel().select(selectedIndex - 1);
        // }
    }

    // Methode pour le bouton "moveDown"
    public void moveDown() {
        ObservableList<Country> list = listView.getItems();
        Country country = listView.getSelectionModel().getSelectedItem();
        int indexCountry = list.indexOf(country);
        if (indexCountry < list.size() - 1){
            list.remove(indexCountry);
            indexCountry++;
            list.add(indexCountry,country);
            listView.getSelectionModel().select(indexCountry);
        }

        // int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        // if (selectedIndex < listView.getItems().size() - 1) {
        //     ObservableList<Country> items = listView.getItems();
        //     Country item = items.remove(selectedIndex);
        //     items.add(selectedIndex + 1, item);
        //     listView.getSelectionModel().select(selectedIndex + 1);

        // }
    }

}
