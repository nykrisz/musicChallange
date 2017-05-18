/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange;

import java.net.URL;
import java.util.List;
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
    
    private String path;
    private MediaPlayer mediaplayer;
    private URL myurl;
    
    
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
          return songs.get(songIndex++);
        }

        return null;
    }
    
    public boolean isAnswerCorrect(String answer) {
        return answer.equals(songs.get(songIndex - 1).getCorrectAns());
    }

}
