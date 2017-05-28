
package hu.unideb.progtech.musicchallange.controller;

import hu.unideb.progtech.musicchallange.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Az alkalmazás játékos megadása Scene-jének {@code Controller} osztálya.
 */

public class LoginController implements Initializable {

    @FXML
    private TextField loginField;
    
    @FXML
    private Label errorLabel;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    
    /**
     * Továbblépés a játékba.
     * 
     * @param event event
     * @throws IOException 
     */
    @FXML
    void handleButtonNext(ActionEvent event) throws IOException {

        if (!loginField.getText().equals("")) {

            MainApp.getGameManager().setCurrentUser(loginField.getText(),0);
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/newGame.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            
            Button source = (Button) event.getSource();            
            Stage stage = (Stage) source.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
            
            MainApp.getGameManager().currentSong();
            NewGameController gameController = fxmlLoader.getController();
            gameController.initData();
            LOGGER.info("a játék elkezdődött");
        } else {
            LOGGER.info("nem megfelelő név");
            errorLabel.setText("Invalid Username");
        }
    }
    
    /**
     * Visszalépés a főmenübe.
     * 
     * @param event event
     * @throws IOException 
     */
    @FXML
    public void handleButtonBack(ActionEvent event) throws IOException{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            
            Button source = (Button) event.getSource();            
            Stage stage = (Stage) source.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
            LOGGER.trace("visszalépés a főmenübe");
    }
    /**
     * Controller osztály inicializációja.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
