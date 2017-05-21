/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Krisz
 */
public class SongDAO {
    private final String xmlfile;

    public SongDAO(String xmlfile) {
        this.xmlfile = xmlfile;
    }
    
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

          return songList;
        } catch (Exception e) {
          e.printStackTrace();

          return null;
        }
    }
}
