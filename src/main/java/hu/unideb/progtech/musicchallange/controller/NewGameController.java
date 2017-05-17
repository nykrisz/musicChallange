/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange.controller;

import hu.unideb.progtech.musicchallange.Song;
import hu.unideb.progtech.musicchallange.SongDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
    
    //nemitt
    private SongDAO songdao;
    private int index = 0;
    private int life = 3;
    private Song songlist;
    private String path;
    private MediaPlayer mediaplayer;
    private URL myurl;
    private String chosen = "";
    //
    
    
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
    
    public void setLabels(Song s){
        rb1.setText(s.getAnswerA());
        rb2.setText(s.getAnswerB());
        rb3.setText(s.getAnswerC());
        rb4.setText(s.getAnswerD());
    }
    
    public String getCounter(){
        //System.out.println("ct: " + counterLabel.getText());
        return counterLabel.getText();
    }
    
    public String getlifeCounter(){
        return lifeLabel.getText();
    }
    
    public void setLifeCounter(){
        
        lifeLabel.setText(Integer.toString(life));
    }
    
    //nem itt 
    public Song getCurrentSong(){
        songlist = songdao.readSong().get(index);
        //System.out.println(songlist);
        return songlist;
    }
    
    //
    //nem itt
    public void playSong(){
        path = songdao.readSong().get(index).getPath();
        myurl = this.getClass().getClassLoader().getResource(path);
        Media musicfile  = new Media(myurl.toString());
        mediaplayer = new MediaPlayer(musicfile);
        mediaplayer.play();
        System.out.println(path);
    }
    
    //nem itt
    public void stopSong(){
        mediaplayer.stop();
    }
    //
    
    //talan itt
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
    public boolean isChosen(){
        if(!(rb1.isSelected() || rb2.isSelected() || rb3.isSelected() || rb4.isSelected()))
            return true;
        return false;
    }
    public void resAns(){
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);
    }
    
    public void playGame(){
        songdao = new SongDAO("xml/audio.xml");   
        
        //resAns();
 
        //counterLabel.setText("1");
        //lifeLabel.setText(Integer.toString(life));
        setLabels(getCurrentSong());
        setAnswer();
        System.out.println(chosen);
        playSong();
            //if (isChosen() == true){
                if(chosen.equals(getCurrentSong().getCorrectAns())){
                    
                    stopSong();

                    index++;
                    if(index > 1){
                        index = 0;
                    }
                    playGame();
                }else{
                    life--;
                }
            //}
     
    }
    
    public void countTime(){
        songdao = new SongDAO("xml/audio.xml");
        final Timer timer = new Timer();
        resAns();
        timer.scheduleAtFixedRate(new TimerTask() {
        int i = 10;
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                     public void run() {
                        counterLabel.setText(Integer.toString(i--));
                        lifeLabel.setText(Integer.toString(life));
                        /*
                        setAnswer();
                        if(Integer.parseInt(counterLabel.getText()) > 0 ){
                            if (isChosen() == true){
                                if(chosen.equals(getCurrentSong().getCorrectAns())){
                                    timer.cancel();
                                    stopSong();

                                    index++;
                                    if(index > 1){
                                        index = 0;
                                    }
                                    countTime();
                                }else{
                                    life--;
                                }
                            }
                        }else{
                            stopSong();
                            timer.cancel();
                        }*/
                    }
                });
            }
        }, 0, 1000);
        setLabels(getCurrentSong());
        playSong();
        System.out.println(counterLabel.getText());
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }    
}
