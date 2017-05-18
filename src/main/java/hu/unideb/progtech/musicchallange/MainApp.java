package hu.unideb.progtech.musicchallange;



import hu.unideb.progtech.musicchallange.controller.NewGameController;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

     private static GameManager gameManager;

    /**
    *Visszaadja az ebben az osztályban pédányosított {@code GameManager} objektumunkat .
    *
    *@return gameManager
    */
    public static GameManager getGameManager() {
      return gameManager;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        gameManager = new GameManager();
    }

 
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
