
package hu.unideb.progtech.musicchallange;

import java.util.List;

/**
 * Az adatbázist feldolgozó interfész.
 */
public interface SDAO {
    
    /**
     * {@inheritDoc}
     *
     * Visszaadja a zenével kapcsolatos 
     * adatokat egy listában.
     *
     * @return {@code Song} objektumokból álló lista
     */
    public List<Song> readSong();
}
