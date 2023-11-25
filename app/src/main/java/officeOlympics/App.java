package officeOlympics;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;

import officeOlympics.backend.*;

public class App extends Application {

    public static ArrayList<Person> peopleList;
    public static Person currentPerson;
    public static Stage stage;

    public static void main(String[] args) {
        Game game = new Game("jo.json"); 
        peopleList = game.getPersons();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane root;
        stage = primaryStage;

        try {
            URL url = App.class.getResource("/front/susView.fxml");
            System.out.println(url);
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent, 1280, 720);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle("The Olympics Office");
            primaryStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

