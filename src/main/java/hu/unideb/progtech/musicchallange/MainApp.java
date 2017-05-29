package hu.unideb.progtech.musicchallange;


import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A main függvényt tartalmazó osztály.
 * 
 */
public class MainApp extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);
    
    private static GameManager gameManager;

    /**
     * A gameManager-t inicializáló függvény.
     * 
     */
    public static void newGameManager(){
        gameManager = new GameManager();
    }
    /**
     * Ebben az osztályban példányosított {@code GameManager}
     * objektumot adja vissza.
     * 
     * @return példányosított GameManager 
     */ 
    public static GameManager getGameManager() {
      return gameManager;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        stage.setTitle("Music Quiz");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        gameManager = new GameManager();
        LOGGER.info("a játék betöltve");
    }

 
    /**
     * Az applikáció main függvénye.
     *
     * @param args parancssori argumentumok
     */
    public static void main(String[] args) {
        launch(args);
    }

}
