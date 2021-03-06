
package hu.unideb.progtech.musicchallange.controller;

import hu.unideb.progtech.musicchallange.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Az alkalmazás befejező Scene-jének {@code Controller} osztálya.
 */
public class GameOverController implements Initializable{

    @FXML
    private Label totalPoints;

    private static final Logger LOGGER = LoggerFactory.getLogger(GameOverController.class);
    
    /**
     * Visszalépés a főmenübe.
     * 
     * @param event event
     * @throws IOException IOException
     */
    @FXML
    public void handleMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainMenu.fxml"));
        
        Scene scene = new Scene(root);
        
        Button source = (Button) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        
        stage.setScene(scene);
        stage.show();
        LOGGER.trace("visszalépés a főmenübe");
    }
    /**
     * Kilépés a játékból.
     * 
     * @throws IOException IOException
     */
    @FXML
    public void handleExit() throws IOException{
        LOGGER.trace("kilépés a játékból");
        Platform.exit();
    }
    
    
    /**
     * Controller osztály inicializációja.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LOGGER.info("végső pontszám kiírva");
        totalPoints.setText(Integer.toString(MainApp.getGameManager().getTotalPoints()));
    }
    
}
