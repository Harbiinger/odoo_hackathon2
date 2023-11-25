package officeOlympics.frontend.Controllers;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import officeOlympics.App;


public class lockerRoomController {

    private Stage stage;
    private Scene scene;
    private javafx.scene.Parent pane;
    private ActionEvent actionEvent;


    @FXML
    private javafx.scene.control.Button backButton;

    @FXML
    private javafx.scene.control.Button inventoryButton;

    public void goBack(ActionEvent actionEvent) throws IOException {
        URL url = App.class.getResource("/front/susView.fxml");
        pane = FXMLLoader.load(url);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    
}

