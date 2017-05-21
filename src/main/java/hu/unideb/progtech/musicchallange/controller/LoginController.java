/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * FXML Controller class
 *
 * @author Krisz
 */
public class LoginController implements Initializable {

    @FXML
    private TextField loginField;
    
    @FXML
    private Label errorLabel;
    
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
            
            MainApp.getGameManager().getCurrentSong();
            NewGameController gameController = fxmlLoader.getController();
            gameController.initData();
            
        } else {
            errorLabel.setText("Légyszíves add meg a neved!");
        }
    }
    
    @FXML
    public void handleButtonBack(ActionEvent event) throws IOException{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            
            Button source = (Button) event.getSource();            
            Stage stage = (Stage) source.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
