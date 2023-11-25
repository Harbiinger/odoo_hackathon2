package officeOlympics.frontend.Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class susViewController  {

    private Stage stage;
    private Scene scene;
    private Parent pane;
    private ActionEvent actionEvent;
    

    @FXML
    private Rectangle suspect1Button;

    @FXML
    private Rectangle suspect2Button;

    @FXML
    private Rectangle suspect3Button;

    @FXML
    private Rectangle suspect4Button;

    @FXML
    private Button backButton;
    
    @FXML
    private Button inventoryButton;

    public void talktTo() {
        System.out.println("Talk to");
    }

    public void displayInventory() {
        System.out.println("Display Inventory");
    }

    public void accuse() {
        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("Accuse");
    }

    public void goToChangingRoom(ActionEvent actionEvent) throws IOException {
        System.out.println("Changing Room");
    }



}
