package officeOlympics;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import officeOlympics.backend.Game;
import officeOlympics.backend.Object;
import officeOlympics.backend.Person;

public class App extends Application {

    public static ArrayList<Person> peopleList;
    public static Person currentPerson;
    public static ArrayList<Object> objectsList = new ArrayList();

    public static Game game;
    public static Stage stage;
    public static String mode = "modern"; // ou antique
    public static boolean accuseMode = false;
    public static boolean moneyFound;

    public static String modernObject1Desc = "Blood test results:\n Kipet Trovitchi: negative\n Marcello Massimo: negative\n Bjorn Seam: negative\n Karl Akerman: negative";

    public static void main(String[] args) {
        game = new Game("jo.json");
        objectsList.add(new Object("Object1", modernObject1Desc));
        peopleList = game.getPersons();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane root;
        stage = primaryStage;

        try {
            URL url = App.class.getResource("/front/eraSelection.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent, 1280, 720);
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image("/front/logo.png"));
            primaryStage.setResizable(false);
            primaryStage.setTitle("The Olympics Office");
            primaryStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

