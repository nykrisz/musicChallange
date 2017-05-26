
package hu.unideb.progtech.musicchallange.controller;

import hu.unideb.progtech.musicchallange.MainApp;
import hu.unideb.progtech.musicchallange.Song;
import hu.unideb.progtech.musicchallange.User;
import hu.unideb.progtech.musicchallange.UserDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import javafx.util.Duration;

/**
 * Az alkalmazás új játék Scene-jének {@code Controller} osztálya.
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
    private Label timerLabel;
    
    @FXML
    private Label lifeLabel;
    
    @FXML
    private Label comboLabel;
    
    private String chosen = "";
    private final int STARTTIME = 10;
    private Integer time = STARTTIME;
    private Timeline timeline;
    
    UserDAO usdao = new UserDAO("users.xml");
    List<User> player = new ArrayList<>();

    /**
     * Visszalépés a főmenübe.
     * 
     * @param event event
     * @throws IOException 
     */
    @FXML
    public void handleBack(ActionEvent event) throws IOException {
        MainApp.getGameManager().stopSong();
        timeline.stop();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        
        Button source = (Button) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Rádiógombok változását figyelő függvény.
     * 
     * @param event event
     * @throws IOException 
     */
    @FXML
    public void change(ActionEvent event) throws IOException{
        
            if(MainApp.getGameManager().getLife() != 0){    
                setAnswer();
                
                if (MainApp.getGameManager().isAnswerCorrect(chosen)) {            

                    MainApp.getGameManager().incCountCorrect();
                    MainApp.getGameManager().countPoints();
                    
                    MainApp.getGameManager().stopSong();
                    if(MainApp.getGameManager().getSongIndex() < MainApp.getGameManager().songSize()){
                        stepSong();
                        rb1.setSelected(false);
                        rb2.setSelected(false);
                        rb3.setSelected(false);
                        rb4.setSelected(false);
                    }else{
                        gameOver();
                    }
                }else{
                    MainApp.getGameManager().setCountCorrect(0);
                    MainApp.getGameManager().stopSong();
                    MainApp.getGameManager().decLife();
                    setLife();
                    if (MainApp.getGameManager().getSongIndex() < MainApp.getGameManager().songSize()) {
                        stepSong();
                        rb1.setSelected(false);
                        rb2.setSelected(false);
                        rb3.setSelected(false);
                        rb4.setSelected(false);
                    }else{
                        gameOver();
                    }
                }
            }else{
                gameOver();
            }    
    }
    
    /**
     * Játékhoz szükséges adatok meghívása.
     */
    public void initData(){
        stepSong();
        setLife();
    }
    
    private void stepSong(){
        countdown();
        Song s = MainApp.getGameManager().getNextSong();
        setLabels(s);
        comboLabel.setText(Integer.toString(MainApp.getGameManager().getCountCorrect()+1) + "X");
    }
    
    private void setLife(){
        lifeLabel.setText(Integer.toString(MainApp.getGameManager().getLife()));
    }
    
    private void setLabels(Song s){
        MainApp.getGameManager().playSong();
        
        rb1.setText(s.getAnswerA());
        rb2.setText(s.getAnswerB());
        rb3.setText(s.getAnswerC());
        rb4.setText(s.getAnswerD());
    }

    private void setAnswer(){
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
    
    private void countdown(){
        if (timeline != null) {
            timeline.stop();
        }
        time = STARTTIME;
        timerLabel.setText(time.toString());
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                  new EventHandler() {
                      @Override
                      public void handle(Event event) {
                        time--;
                        timerLabel.setText(
                              time.toString());
                        if (time <= 0) {
                            timeline.stop();
                        }
                      }
                }));
        timeline.playFromStart();
    }    
    
    private void gameOver() throws IOException{
        MainApp.getGameManager().stopSong();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/gameOver.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) rb1.getScene().getWindow();
        
        stage.setScene(scene);
        stage.show();
        timeline.stop();
        MainApp.getGameManager().setCurrentUser(MainApp.getGameManager().getCurrentUserName(), MainApp.getGameManager().getTotalPoints());
        player.addAll(usdao.getUsers());
        player.add(MainApp.getGameManager().getCurrentUser());
        usdao.persistUsers(player);
    }

    /**
     * Controller osztály inicializációja.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        timerLabel.textProperty().addListener(new ChangeListener<String>() { 
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
               if(Integer.parseInt(t1) == 0){
                   if(MainApp.getGameManager().getSongIndex() < MainApp.getGameManager().songSize() && MainApp.getGameManager().getLife() > 0){
                        MainApp.getGameManager().stopSong();
                        MainApp.getGameManager().decLife();
                        setLife();
                        stepSong();
                   }else{
                       try {
                           gameOver();
                       } catch (IOException ex) {
                           Logger.getLogger(NewGameController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
                }
            }
        });
    } 
    
}
