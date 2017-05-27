
package hu.unideb.progtech.musicchallange;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * SDAO interfész implementációja.
 * 
 */
public class SongDAO implements SDAO{

    private static final Logger LOGGER = LoggerFactory.getLogger(SongDAO.class);
    
    /**
     * Az {@code xml} elérési útvonalát
     * tároló konstans változó.
     */
    private final String xmlfile;

    /**
     * Konstruktor egy {@code SongDAO} objektum létrehozására.
     * @param xmlfile {@code xml} elérési útvonala
     */
    public SongDAO(String xmlfile) {
        this.xmlfile = xmlfile;
    }
    
    @Override
    public List<Song> readSong(){
        try {
          List<Song> songList = new ArrayList<>();

          InputStream is = this.getClass().getClassLoader().getResourceAsStream(xmlfile);
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          Document doc = dBuilder.parse(is);

          doc.getDocumentElement().normalize();

          NodeList nList = doc.getElementsByTagName("audio");

          for (int i = 0; i < nList.getLength(); i++) {
            Element eElement = (Element) nList.item(i);

            songList.add(new Song(
                eElement.getElementsByTagName("path").item(0).getTextContent(),
                eElement.getElementsByTagName("answerA").item(0).getTextContent(),
                eElement.getElementsByTagName("answerB").item(0).getTextContent(),
                eElement.getElementsByTagName("answerC").item(0).getTextContent(),
                eElement.getElementsByTagName("answerD").item(0).getTextContent(),
                eElement.getElementsByTagName("correctAns").item(0).getTextContent(),
                eElement.getElementsByTagName("weight").item(0).getTextContent()));
          }
          LOGGER.trace("zenék beolvasása megtörtént");
          return songList;
        } catch (Exception e) {
          e.printStackTrace();

          LOGGER.trace("zenék beolvasása nem sikerült");
          return null;
        }
    }
}
