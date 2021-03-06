
package hu.unideb.progtech.musicchallange;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * A UDAO interfész implementációja.
 */
public class UserDAO implements UDAO{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);
    private static final Logger SEC_LOGGER = LoggerFactory.getLogger(UserDAO.class);
    
    /**
    * Fájl elérési útjának tárolására. 
    */  
    private final String xmlFile;

    /**
    * Konstruktor a {@code UserDAO} objektum példányosításához.
    * @param xmlFile fájl elérési útvonala
    */
    public UserDAO(String xmlFile) {
    this.xmlFile = xmlFile;
    }

    @Override
    public List<User> getUsers() {
        try {
            List<User> listUsers = new ArrayList<>();

            File is = new File(xmlFile);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("user");

            for (int i = 0; i < nList.getLength(); i++) {
                Element eElement = (Element) nList.item(i);

                listUsers.add(new User(eElement.getElementsByTagName("username").item(0).getTextContent(),
                Integer.parseInt(eElement.getElementsByTagName("points").item(0).getTextContent())));
            }
            LOGGER.trace("játékosok beolvasva az " + xmlFile + " fájlból.");

            return listUsers;

        } catch (Exception e) {
            SEC_LOGGER.trace("A fájl {} nem olvasható",xmlFile);
            return new ArrayList<User>();
        }
    }

    @Override
    public void persistUsers(List<User> users) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("users");
            doc.appendChild(rootElement);

            // user elements
            for (int i = 0; i < users.size(); i++) {

                Element user = doc.createElement("user");
                rootElement.appendChild(user);

                Element userName = doc.createElement("username");
                userName.appendChild(doc.createTextNode(users.get(i).getName()));
                user.appendChild(userName);

                // point elements
                Element point = doc.createElement("points");
                point.appendChild(doc.createTextNode(Integer.toString(users.get(i).getScore())));
                user.appendChild(point);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(xmlFile));

            // Output to console for testing
            transformer.transform(source, result);

            LOGGER.trace("adatok kiírva az " + xmlFile + " fájlba.");
            
        }catch (ParserConfigurationException pce) {
             pce.printStackTrace();
        }catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
