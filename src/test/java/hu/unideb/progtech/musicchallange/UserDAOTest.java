
package hu.unideb.progtech.musicchallange;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author Krisz
 */
public class UserDAOTest {
    
    @Test
    public void testGetUsers(){
        UserDAO udao = new UserDAO("src/test/resources/UserTest.xml");
        User user = new User("TestName", 100);

        List<User> expResult = new ArrayList<User>();

        expResult.add(user);

        List<User> result = udao.getUsers();

        assertEquals(expResult, result);
    }
    
    @Rule
    public TemporaryFolder folder= new TemporaryFolder();
    
    @Test
    public void testPresistUsers() {
        
        try {
            File createdFile= folder.newFile("userTest.xml");
            UserDAO udao = new UserDAO(createdFile.toString());
            
            User u = new User("TestName", 100);
            
            List<User> expResult = new ArrayList<User>();
            
            expResult.add(u);
            
            udao.persistUsers(expResult);
            
            List<User> result = udao.getUsers();
            
            assertEquals(expResult, result);
        } catch (IOException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
