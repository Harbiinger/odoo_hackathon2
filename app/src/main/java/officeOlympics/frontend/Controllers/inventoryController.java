package officeOlympics.frontend;

import officeOlympics.App;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class inventoryController {

    @FXML
    private GridPane grid;

    @FXML 
    private ImageView background;

    public void initialize() {
        background.setImage(new Image("/front/"+ App.mode +"InventoryBackground.png"));
    }
}
