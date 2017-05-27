
package hu.unideb.progtech.musicchallange;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
    
    @Test
    public void testPresistUsers() {
        UserDAO udao = new UserDAO("userTest.xml");

        User u = new User("TestName", 100);

        List<User> expResult = new ArrayList<User>();

        expResult.add(u);

        udao.persistUsers(expResult);

        List<User> result = udao.getUsers();

        assertEquals(expResult, result);
    }
}
