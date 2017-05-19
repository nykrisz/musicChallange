/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange.controller;

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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
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
    private ToggleGroup group;
    
    @FXML
    private VBox vbox;
    
    @FXML
    private Label counterLabel;
    
    @FXML
    private Label lifeLabel;
    
    private int index = 0;
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
    //
    @FXML
    public void change(ActionEvent event) throws IOException{
        if(MainApp.getGameManager().getLife() != 0){    
            setAnswer();
            
            if (MainApp.getGameManager().isAnswerCorrect(chosen)) {            
                
                MainApp.getGameManager().countPoints();
                System.out.println(MainApp.getGameManager().getTotalPoints());
                
                MainApp.getGameManager().incCountCorrect();
                System.out.println(MainApp.getGameManager().getCountCorrect());
                MainApp.getGameManager().stopSong();
                if (MainApp.getGameManager().getSongIndex() < 2) {
                    stepSong();
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                    rb3.setSelected(false);
                    rb4.setSelected(false);
                }
            }else{
                MainApp.getGameManager().setCountCorrect(1);
                System.out.println(MainApp.getGameManager().getCountCorrect());
                MainApp.getGameManager().stopSong();
                MainApp.getGameManager().decLife();
                setLife();
                if (MainApp.getGameManager().getSongIndex() < 2) {
                    stepSong();
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                    rb3.setSelected(false);
                    rb4.setSelected(false);
                }
            }
        }else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/gameOver.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            RadioButton source = (RadioButton) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();            
        }      
    }
    
    public void setLife(){
        lifeLabel.setText(Integer.toString(MainApp.getGameManager().getLife()));
    }
    
    public void initData(){
        stepSong();
        setLife();
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
