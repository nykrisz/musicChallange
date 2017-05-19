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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Krisz
 */
public class MainMenuController implements Initializable{
    
    @FXML
    public void handleNewGame(ActionEvent event) throws IOException{
            
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
    }
    
    @FXML
    public void handleHighScores(ActionEvent event) throws IOException{
        
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/highScores.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            
            Button source = (Button) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            stage.setScene(scene);
            stage.show();    
    }
    
    @FXML
    public void handleExit() throws IOException{
        Platform.exit();
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MainApp.newGameManager();
    }  
}
