
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
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Az alkalmazás főmenü Scene-jének {@code Controller} osztálya.
 */

public class MainMenuController implements Initializable{

    private static final Logger LOGGER = LoggerFactory.getLogger(MainMenuController.class);
    
    /**
     * Továbblépés a játékos megadásához.
     * 
     * @param event event
     * @throws IOException IOException
     */
    @FXML
    public void handleNewGame(ActionEvent event) throws IOException{
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            
            Button source = (Button) event.getSource();            
            Stage stage = (Stage) source.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
            LOGGER.trace("login képernyő betöltve");
    }
    
    /**
     * Belépés a pontszámokhoz.
     * 
     * @param event event
     * @throws IOException IOException
     */
    @FXML
    public void handleHighScores(ActionEvent event) throws IOException{
        
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/highScores.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            
            Button source = (Button) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
            LOGGER.trace("pontszámok betöltve");
    }
    
    /**
     * Kilépés a játékból.
     * 
     * @throws IOException IOException
     */
    @FXML
    public void handleExit() throws IOException{
        Platform.exit();
        LOGGER.trace("kilépés a játékból");
    }
    
    
    /**
     * Controller osztály inicializációja.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MainApp.newGameManager();
    }  
}
