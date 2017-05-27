
package hu.unideb.progtech.musicchallange;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krisz
 */
public class UserTest {

    private User user;
    private GameManager gameManager;
    
    @Before
    public void setUp() {
        user = new User("TestName", 100);
        gameManager = new GameManager();
    }
    
    @After
    public void tearDown() {
     user = null;
    }
    
    @Test
    public void testSetName(){
        String expected = "TestName";
        user.setName("TestName");
        assertEquals(expected,user.getName());
    }
    
    @Test
    public void testSetScore(){
        int expected = 99;
        user.setScore(99);
        assertEquals(expected,user.getScore());
    }
}
