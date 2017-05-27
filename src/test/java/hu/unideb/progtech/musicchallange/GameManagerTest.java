
package hu.unideb.progtech.musicchallange;


import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Krisz
 */
public class GameManagerTest {
    private GameManager gameManager;
    
    public GameManagerTest(){}
    
    @Before
    public void setUp() {
      gameManager = new GameManager();
    }
    
    @After
    public void tearDown() {
        gameManager = null;
    }
    
    @Test
    public void testGetCurrentUserName(){
        String name = "Test";
        int point = 50;
        
        gameManager.setCurrentUser(name, point);
        assertEquals(name,gameManager.getCurrentUserName());
    }
    
    @Test
    public void testSetCurrentUser(){
        User expected = new User("Test",50);
        
        gameManager.setCurrentUser("Test",50);
        assertEquals(expected,gameManager.getCurrentUser());
    }
    
    @Test
    public void testGetCurrentUser(){
        User expected = new User("Test",50);
        
        gameManager.setCurrentUser("Test",50);
        assertEquals(expected,gameManager.getCurrentUser());
    }

    @Test
    public void testGetNextSongNull(){
        String expected = null;
        gameManager.currentSong();
        gameManager.setSongIndex(gameManager.songSize()+1);
        assertEquals(expected,gameManager.getNextSong());
    }
    
    @Test
    public void testGetSongIndex() {
        int expected = 9;
        gameManager.setSongIndex(9);
        
        assertEquals(expected,gameManager.getSongIndex());
    }
    
    @Test
    public void testGetLife() {
        int expected = 3;
        assertEquals(expected, gameManager.getLife());
    }
    
    @Test
    public void testDecLife(){
        int expected = 2;
        gameManager.setLife(3);
        gameManager.decLife();
        assertEquals(expected,gameManager.getLife());
    }
    
    @Test
    public void testIncCountCorrect(){
        int expected = 5;
        gameManager.setCountCorrect(4);
        gameManager.incCountCorrect();
        assertEquals(expected,gameManager.getCountCorrect());
    }
    
    @Test
    public void testGetCountCorrect(){
        int expected = 0;
        assertEquals(expected, gameManager.getCountCorrect());
    }
    
    @Test
    public void testSetPoints(){
        int expected = 20;
        gameManager.setPoints(20);
        assertEquals(expected, gameManager.getPoints());
    }
    
    @Test
    public void testGetTotalPoints() {
        int points = 10;
        int combo = 3;
        int expected = 30;
        
        gameManager.totalPoints(points, combo);
        assertEquals(expected,gameManager.getTotalPoints());
    }
    
    @Test
    public void testPointByWeight1(){
        int expected = 10;
        gameManager.setWeight("K1");
        gameManager.setPointByWeight();
        assertEquals(expected,gameManager.getPoints());
    }
    @Test
    public void testPointByWeight2(){
        int expected = 20;
        gameManager.setWeight("K2");
        gameManager.setPointByWeight();
        assertEquals(expected,gameManager.getPoints());
    }
    @Test
    public void testPointByWeight3(){
        int expected = 30;
        gameManager.setWeight("K3");
        gameManager.setPointByWeight();
        assertEquals(expected,gameManager.getPoints());
    }
    @Test
    public void testPointByWeight4(){
        int expected = 40;
        gameManager.setWeight("K4");
        gameManager.setPointByWeight();
        assertEquals(expected,gameManager.getPoints());
    }
    @Test
    public void testPointByWeightdef(){
        int expected = 0;
        gameManager.setWeight("");
        gameManager.setPointByWeight();
        assertEquals(expected,gameManager.getPoints());
    }
    @Test(expected = NullPointerException.class)
    public void testPointByWeightNull(){
        gameManager.setWeight(null);
        gameManager.setPointByWeight();
    }
    
    @Test
    public void testGetWeight(){
        String expected = "K3";
        gameManager.setWeight("K3");
        assertEquals(expected,gameManager.getWeight());
    }
    
    @Test
    public void testCountPoints(){
        int expected = 40;
        gameManager.setWeight("K4");
        gameManager.setPointByWeight();
        gameManager.setCountCorrect(1);
        assertEquals(expected,gameManager.countPoints());
    }
 
    @Test
    public void testGetResults(){
        User user = new User("TestName", 100);

        List<User> expResult = new ArrayList<User>();

        expResult.add(user);

        List<User> result = gameManager.getResults("src/test/resources/UserTest.xml");

        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetUxml(){
        String expected = "users.xml";
        assertEquals(expected,gameManager.getUxml());
        
    }
   
    @Test
    public void testSetPath(){
        String expected = "testPath";
        gameManager.setPath("testPath");
        assertEquals(expected,gameManager.getPath());
    }
}