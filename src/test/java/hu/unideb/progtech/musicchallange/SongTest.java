
package hu.unideb.progtech.musicchallange;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krisz
 */
public class SongTest {
    private Song song;
    
    @Before
    public void setUp() {
      song = new Song("path","answerA","answerB","answerC","answerD","correctAns","weight");
    }
    
    @After
    public void tearDown() {
        song = null;
    }
    
    @Test
    public void testGetPath(){
        String expected = "testpath";
        song.setPath("testpath");
        assertEquals(expected, song.getPath());
    }
    
    @Test
    public void testAnswerA(){
        String expected = "testA";
        song.setAnswerA("testA");
        assertEquals(expected,song.getAnswerA());
    }
    
    @Test
    public void testAnswerB(){
        String expected = "testB";
        song.setAnswerB("testB");
        assertEquals(expected,song.getAnswerB());
    }
    
    @Test
    public void testAnswerC(){
        String expected = "testC";
        song.setAnswerC("testC");
        assertEquals(expected,song.getAnswerC());
    }
    
    @Test
    public void testAnswerD(){
        String expected = "testD";
        song.setAnswerD("testD");
        assertEquals(expected,song.getAnswerD());
    }
    
    
    @Test
    public void testCorrectAns(){
        String expected = "testCorrect";
        song.setCorrectAns("testCorrect");
        assertEquals(expected,song.getCorrectAns());
    }
    
    @Test
    public void testWeight(){
        String expected = "K4";
        song.setWeight("K4");
        assertEquals(expected,song.getWeight());
    }
}
