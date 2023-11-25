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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import officeOlympics.App;

public class mainMenuController {

    private Stage stage;
    private Scene scene;
    private Parent pane;

    @FXML
    private Button newGameButton;

    @FXML
    private ImageView backgroundMainMenu;

    public void goToEraSelection(ActionEvent actionEvent) throws IOException {
        URL url = App.class.getResource("/front/eraSelection.fxml");
        pane = FXMLLoader.load(url);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        }
    
}
