/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange.controller;

import hu.unideb.progtech.musicchallange.MainApp;
import hu.unideb.progtech.musicchallange.User;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Krisz
 */
public class HighScoresController implements Initializable{
    
    @FXML
    private TableColumn<User, String> userName;
    @FXML
    private TableColumn<User, Integer> userPoint;
    @FXML
    private TableView<User> table;

    @FXML
    public void handleBack(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        
        Button source = (Button) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        
        stage.setScene(scene);
        stage.show();
    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        userName.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
        userPoint.setCellValueFactory(new PropertyValueFactory<User,Integer>("score"));
        table.setItems(MainApp.getGameManager().getResults());
    }    
    
}
