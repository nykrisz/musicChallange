/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 *
 * @author Krisz
 */
public class GameManager {
    private final String XMLFILE = "xml/audio.xml";
    private SongDAO songdao;
    private int songIndex;
    private List<Song> songs;
    private int life = 3;
    private String path;
    private MediaPlayer mediaplayer;
    private URL myurl;
    private int countCorrect;
    private int points;
    private int totalPoints;
    private User currentUser=null;
    private String weight;
    
    public GameManager(){
        songdao = new SongDAO(XMLFILE);
        songIndex = 0;    
    }
    public GameManager(String xmlfile){
        songdao = new SongDAO(xmlfile);
        songIndex = 0;    
    }

    public int songSize(){
        return songs.size();
    }
    //
    public void setCurrentUser(String name, int point) {
        currentUser = new User(name, point);
    }

    //
    public String getCurrentUserName() {
        return currentUser.getName();
    }
    //
    public User getCurrentUser() {
        return currentUser;
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

    public void setPath(String path) {
        this.path = path;
    }
    
    public void playSong(){
        path = songdao.readSong().get(songIndex-1).getPath();
        getSongWeight();
        myurl = this.getClass().getClassLoader().getResource(path);
        Media musicfile  = new Media(myurl.toString());
        mediaplayer = new MediaPlayer(musicfile);
        mediaplayer.play();
    }

    public void stopSong(){
        mediaplayer.stop();
    }
    
    public Song getNextSong() {
        if (songIndex < songs.size()) {
            return songs.get(songIndex++);
        }
        return null;
    }
    
    public boolean isAnswerCorrect(String answer) {
        stopSong();
        return answer.equals(songs.get(songIndex - 1).getCorrectAns());
    }

    public void getSongWeight(){
        weight = songs.get(songIndex - 1).getWeight();
    }
    
    public void setPointByWeight(){
        switch (weight) {
            case "K1":
                setPoints(10);
                break;
            case "K2":
                setPoints(20);
                break;
            case "K3":
                setPoints(30);
                break;
            case "K4":
                setPoints(40);
                break;
            default:
                break;
        }
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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
 
    public int countPoints(){
        setPointByWeight();
        setTotalPoints(points, countCorrect);
        return totalPoints;
    }
    
    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int points, int countCorrect) {
        this.points = points;
        this.countCorrect = countCorrect;
        
        totalPoints += points * countCorrect;
    }
    
    public ObservableList<User> getResults() {
        UserDAO usdao = new UserDAO("users.xml");
        List<User> list = new ArrayList<>();

        list = usdao.getUsers();
        ObservableList<User> results = FXCollections.observableArrayList();
        for (User users : list) {
          results.add(users);
        }

    return results;
    }
    
}
