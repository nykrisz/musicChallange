
package hu.unideb.progtech.musicchallange;

import java.util.Objects;

/**
 * Osztály egy játékos reprezentálására.
 */
public class User {
    
    private String name;
    private int point;

    /**
     * {@code User} objektum létrehozására szolgáló konstruktor.
     * 
     * @param name játékos neve
     * @param score játékos pontszáma
     */
    public User(String name, int score) {
        this.name = name;
        this.point = score;
    }

    /**
     * Visszaadja a játékos nevét.
     * 
     * @return játékos neve 
     */
    public String getName() {
        return name;
    }

    /**
     * Beállítja a játékos nevét.
     * 
     * @param name játékos neve
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Visszaadja a játékos pontszámát.
     * 
     * @return játékos pontszáma 
     */
    public int getScore() {
        return point;
    }

    /**
     * Beállítja a játékos pontszámát.
     * 
     * @param score játékos pontszáma. 
     */
    public void setScore(int score) {
        this.point = score;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.point != other.point) {
            return false;
        }
        return true;
    }

}
