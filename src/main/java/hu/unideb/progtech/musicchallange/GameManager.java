/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange;

import java.net.URL;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 *
 * @author Krisz
 */
public class GameManager {
    private final String XMLFILE = "xml/audio.xml";
    private SongDAO songdao;
    private int songIndex=0;
    private List<Song> songs;
    private int life = 3;
    private String path;
    private MediaPlayer mediaplayer;
    private URL myurl;
    private int countCorrect=0;
    private int points=10;
    private int totalPoints=0;
    private int time;
    
    public GameManager(){
        songdao = new SongDAO(XMLFILE);
        songIndex = 0;    
    }
    
    public void getCurrentSong(){
        songs = songdao.readSong();
    }

    public int getSongIndex() {
        return songIndex;
    }

    public void setSongIndex(int songIndex) {
        this.songIndex = songIndex;
    }
   
    public void playSong(){
        path = songdao.readSong().get(songIndex-1).getPath();
        myurl = this.getClass().getClassLoader().getResource(path);
        Media musicfile  = new Media(myurl.toString());
        mediaplayer = new MediaPlayer(musicfile);
        mediaplayer.play();
        System.out.println(path);
    }

    public void stopSong(){
        mediaplayer.stop();
    }
    
    public Song getNextSong() {
        if (songIndex < songs.size()) {
            System.out.println(songs.size());
          return songs.get(songIndex++);
        }
        return null;
    }
    
    
    
    public boolean isAnswerCorrect(String answer) {
        stopSong();
        return answer.equals(songs.get(songIndex - 1).getCorrectAns());
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    
    public void decLife(){
        life--;
    }

    public int getCountCorrect() {
        return countCorrect;
    }

    public void setCountCorrect(int countCorrect) {
        this.countCorrect = countCorrect;
    }
    
    public void incCountCorrect(){
        countCorrect++;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
 
    public int countPoints(){
        totalPoints += points * countCorrect; 
        return totalPoints;
    }

    public int getTime() {
        return time;
    }
    
    /*public void countTime(){
        final Timer timer = new Timer();
        time = 10;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                     public void run() {
                        time--;
                        System.out.println(time);
                    }
                });
            }  
        }, 0, 1000);       
    }*/
}
