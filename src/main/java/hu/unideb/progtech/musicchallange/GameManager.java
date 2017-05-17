/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange;

import hu.unideb.progtech.musicchallange.Song;
import hu.unideb.progtech.musicchallange.SongDAO;


/**
 *
 * @author Krisz
 */
public class GameManager {
    private final String XMLFILE = "xml/audio.xml";
    private SongDAO songdao;
    private int index = 0;
    private Song songlist;
    
    public GameManager(){
        songdao = new SongDAO(XMLFILE);
    }
    
    public Song getCurrentSong(){
        songlist = songdao.readSong().get(index);
        System.out.println(songlist);
        return songlist;
    }
        
    /*public void playSong(String path){
        myurl = this.getClass().getClassLoader().getResource(path);
        Media musicfile  = new Media(myurl.toString());
        mediaplayer = new MediaPlayer(musicfile);
        mediaplayer.play();
        System.out.println(myurl.toString());
    }
    
    public void stopSong(){
        mediaplayer.stop();
    }
    */
}
