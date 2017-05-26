
package hu.unideb.progtech.musicchallange;

import java.util.List;

/**
 * Interfész adatbázis feldolgozására,
 * mely játékosokról tartalmaz adatokat.
 */
public interface UDAO {
    
    /**
     * {@inheritDoc}
     * 
     * Visszadja az adatbázisban szereplő játékos nevét
     * és pontszámát egy listában.
     * 
     * @return egy {@code User} objektumokat tartalmazó lista
     */
    public List<User> getUsers();
    
    
    /**
     * {@inheritDoc}
     * 
     * A paraméterül kapott listában lévő játékosok
     * nevét és pontszámát írja ki az adatbázisba.
     * 
     * @param users {@code User} objektumokat tartalmazó lista 
     */

    public void persistUsers(List<User> users);
}
