package officeOlympics.frontend.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class susViewController  {

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

    



}
