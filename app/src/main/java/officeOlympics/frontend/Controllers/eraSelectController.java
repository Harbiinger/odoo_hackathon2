package officeOlympics.frontend.Controllers;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import officeOlympics.App;
import officeOlympics.backend.Game;
import officeOlympics.backend.Object;

public class eraSelectController {

    private Stage stage;
    private Scene scene;
    private Parent pane;

    @FXML
    private Button greekChoiceButton;

    @FXML
    private Button modernChoiceButton;

    public void selectModernEra(ActionEvent actionEvent) throws IOException {
        App.mode = "modern";
        App.game = new Game("jo.json");
        App.objectsList.clear();
        String modernObject1Desc = "Blood test results:\n Kipet Trovitchi: negative\n Marcello Massimo: negative\n Bjorn Seam: negative\n Karl Akerman: negative";
        App.objectsList.add(new Object("Object1", modernObject1Desc));
        App.peopleList = App.game.getPersons();
        URL url = App.class.getResource("/front/susView.fxml");
        pane = FXMLLoader.load(url);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void selectGreekEra(ActionEvent actionEvent) throws IOException {
        App.mode = "antique";
        App.game = new Game("olympe.json");
        App.peopleList = App.game.getPersons();
        App.objectsList.clear();
        Object coca = new Object("coca", "Coca leaf found in Yapadelis' stuff.");
        App.objectsList.add(coca);
        URL url = App.class.getResource("/front/susView.fxml");
        pane = FXMLLoader.load(url);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    
}
