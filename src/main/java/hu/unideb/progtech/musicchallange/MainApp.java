package hu.unideb.progtech.musicchallange;


import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A main függvényt tartalmazó osztály.
 * 
 */
public class MainApp extends Application {

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
        gameManager = new GameManager();
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
