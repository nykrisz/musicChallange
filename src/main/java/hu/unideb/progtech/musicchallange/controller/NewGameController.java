/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange.controller;

import hu.unideb.progtech.musicchallange.GameManager;
import hu.unideb.progtech.musicchallange.MainApp;
import hu.unideb.progtech.musicchallange.Song;
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
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 *
 * @author Krisz
 */
public class NewGameController implements Initializable{
    
    @FXML
    private RadioButton rb1;
    
    @FXML
    private RadioButton rb2;
    
    @FXML
    private RadioButton rb3;
    
    @FXML
    private RadioButton rb4;
    
    @FXML
    private Label counterLabel;
    
    @FXML
    private Label lifeLabel;
    
    private int index = 0;
    private int life = 3;
    private String chosen = "";
    
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
    
    @FXML
    public void handleNext(){

            if (!(rb1.isSelected() || rb2.isSelected() || rb3.isSelected() || rb4.isSelected()))
            {
              return;
            }
            if (MainApp.getGameManager().isAnswerCorrect(chosen)) {
                MainApp.getGameManager().stopSong();
              if (MainApp.getGameManager().getSongIndex() < 2) {
                stepSong();
                rb1.setSelected(false);
                rb2.setSelected(false);
                rb3.setSelected(false);
                rb4.setSelected(false);
                }
            }
    }
    
    public void initData(){
        stepSong();
    }
    
    public void stepSong(){
        Song s = MainApp.getGameManager().getNextSong();
        setLabels(s);
        MainApp.getGameManager().playSong();
    }
  
    public void setLabels(Song s){
        rb1.setText(s.getAnswerA());
        rb2.setText(s.getAnswerB());
        rb3.setText(s.getAnswerC());
        rb4.setText(s.getAnswerD());
    }

    public void setAnswer(){
        if(rb1.isSelected()){
            chosen = rb1.getText();
        }if(rb2.isSelected()){
            chosen = rb2.getText();
        }if(rb3.isSelected()){
            chosen = rb3.getText();
        }if(rb4.isSelected()){
            chosen = rb4.getText();
        }
    }
    /*
    public void countTime(){
        final Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                     public void run() {
                        counterLabel.setText(Integer.toString(counter));
                        counter--;
                    }
                });
            }  
        }, 0, 1000);       
    }*/
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    } 
    
}
