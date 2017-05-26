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
    private final String UXML = "users.xml";
    
    /**
    * Konstruktor egy {@code GameManager} létrehozására.
    * Egy {@code SongDAO} objektumot példányosít
    * a zenék beolvasásához, és az aktuális zene indexét
    * inicializálja.
    */
    
    public GameManager(){
        songdao = new SongDAO(XMLFILE);
        songIndex = 0;    
    }
    /**
     * Visszaadja a konstans UMXL-t,
     * melynek értéke users.xml.
     * 
     * @return konstans UMXL
     */
    public String getUxml() {
        return UXML;
    }
    /**
     * Beállítja az aktuális játékos adatait.
     * 
     * @param name a játékos neve
     * @param point a játékos pontszáma
     */
    public void setCurrentUser(String name, int point) {
        currentUser = new User(name, point);
    }

    /**
     * Visszaadja az aktuális {@code User} játékost,
     * objektumként.
     * 
     * @return aktuális {@code User} objektum 
     */
    public User getCurrentUser() {
        return currentUser;
    }
    
    /**
     * Visszaadja az éppen játszó játékos nevét.
     * 
     * @return aktuális játékos neve 
     */
    public String getCurrentUserName() {
        return currentUser.getName();
    }

    /**
     * Visszaadja az aktuális zene indexét.
     * @return aktuális zene indexe.
     */
    public int getSongIndex() {
        return songIndex;
    }

    /**
     * Beállítja a zene indexét.
     * 
     * @param songIndex aktuális zene indexe
     */
    public void setSongIndex(int songIndex) {
        this.songIndex = songIndex;
    }
    /**
     * Beállítja a zene elérési útvonalát.
     * 
     * @param path zene elérési útvonala
     */
    public void setPath(String path) {
        this.path = path;
    }
    
    /**
     * Visszaadja a zene súlyát,
     * melynek a pontszámításnál van szerepe.
     * 
     * @return zene súlya
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Beállítja a zene súlyát.
     * "K1","K2","K3" vagy "K4".
     * 
     * @param weight zene súlya
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }
 
    /**
     * Vissszaadja az életek számát.
     * 
     * @return játékos élete 
     */
    public int getLife() {
        return life;
    }

    /**
     * Beállítja az életek számát.
     * 
     * @param life életek száma
     */
    public void setLife(int life) {
        this.life = life;
    }
    /**
     * Visszaadja a zsinórban jó válaszok számát.
     * 
     * @return egymást követő jó válaszok.
     */
    public int getCountCorrect() {
        return countCorrect;
    }

    /**
     * Beállítja az egymást követő jó válaszok számát.
     * 
     * @param countCorrect egymás utáni jó válaszok száma
     */
    public void setCountCorrect(int countCorrect) {
        this.countCorrect = countCorrect;
    }
    
    /**
     * Visszaadja a pontszámot.
     * 
     * @return pontok értéke 
     */
    public int getPoints() {
        return points;
    }

    /**
     * Beállítja a pontszámot.
     * 
     * @param points pontok értéke
     */
    public void setPoints(int points) {
        this.points = points;
    }
    
    /**
     * Visszaadja a játék során megszerzett
     * összpontszámot.
     * 
     * @return összpontszám
     */
    public int getTotalPoints() {
        return totalPoints;
    }
    
    /**
     * Beolvassa a zenéket és az osztály
     * {@code songs} nevű listájában tárolja.
     * 
     */
    public void currentSong(){
        songs = songdao.readSong();
    }
    /**
     * Visszaadja a {@code songs} nevű lista méretét.
     * 
     * @return {@code songs} lista mérete.
     */
    public int songSize(){
        return songs.size();
    }
    /**
     * Az aktuális zenéhez tartozó elérési útvonal
     * alapján elindítja a zene lejátszást.
     */
    public void playSong(){
        myurl = this.getClass().getClassLoader().getResource(path);
        Media musicfile  = new Media(myurl.toString());
        mediaplayer = new MediaPlayer(musicfile);
        mediaplayer.play();
    }
    /**
     * Leállítja a zene lejátszását.
     * 
     */
    public void stopSong(){
        mediaplayer.stop();
    }
    
    /**
    * Visszaadja a soron következő zenét, amíg az aktuális
    * zeneszám indexe ({@code songIndex})
    * kisebb mint az összes száma. Ha ez a <em>feltétel</em>
    * nem teljesül akkor a függvény <em>null</em> értékkel tér vissza.
    *
    * @return a soron következő zene vagy null
    */
    public Song getNextSong() {
        if (songIndex < songs.size()) {
            setPath(songdao.readSong().get(songIndex).getPath());
            setWeight(songs.get(songIndex).getWeight());
            return songs.get(songIndex++);
        }
        return null;
    }
    
    /**
     * Megvizsgálja, hogy a kapott válasz megegyezik-e
     * a zenéhez tartozó helyes válasszal.
     * 
     * @param answer játékos válasza
     * @return true, ha a játékos válasza helyes 
     */
    public boolean isAnswerCorrect(String answer) {
        stopSong();
        return answer.equals(songs.get(songIndex - 1).getCorrectAns());
    }
    /**
     * Csökkenti a játékos életét.
     * 
     */
    public void decLife(){
        life--;
    }
    
    /**
     * Egymást követő helyes válaszok számlálója. 
     */
    public void incCountCorrect(){
        countCorrect++;
    }

    /**
     * Beállítja a zenéhez tartozó súlyt, és
     * az alapján rendel pontot a {@code points}
     * változóhoz. Ezután kiszámolja az összpontszámot,
     * majd visszaadja ennek értékét.
     * 
     * @return játékos által elért összpontszám
     */
    public int countPoints(){
        setPointByWeight();
        totalPoints(points, countCorrect);
        return totalPoints;
    }
    /**
     * A kapott pontok és "combo" számláló alapján
     * növeli az összpontszámot.
     * 
     * @param points adott pontszám
     * @param countCorrect egymást követő helyes válaszok száma
     */
    
    public void totalPoints(int points, int countCorrect) {
        this.points = points;
        this.countCorrect = countCorrect;
        
        totalPoints += points * countCorrect;
    }
    /**
     * Adott zenéhez tartozó súly alapján rendeli
     * a pontokat az osztály {@code points} változójához.
     */
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

    /**
    * Egy {@code User} objektumokat tartalmazó
    * {@code ObservableList}-et ad vissza. Erre a
    * {@code TableView} feltöltése során van  szükség.
    *
    * @param UXML konstans változó, értéke users.xml
    * @return {@code User} objektumokat tartalmazó {@code ObservableList}
    */
    public ObservableList<User> getResults(String UXML) {
        UserDAO usdao = new UserDAO(UXML);
        List<User> list = new ArrayList<>();

        list = usdao.getUsers();
        ObservableList<User> results = FXCollections.observableArrayList();
        for (User users : list) {
          results.add(users);
        }

    return results;
    }
    
}
