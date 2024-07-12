package fr.afpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonEventHandlerController implements EventHandler<ActionEvent> {
    private Logger logger = LogManager.getLogger(ButtonEventHandlerController.class);

    @Override
    public void handle(ActionEvent event) {
        logger.info("You clicked on \"Quit\"");

      //Fermeture de l'application
       Platform.exit();
       logger.info("L'application se ferme");
        
    }

    

}
