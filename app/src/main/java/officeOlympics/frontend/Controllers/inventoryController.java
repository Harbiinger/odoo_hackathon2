package officeOlympics.frontend.Controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import officeOlympics.App;


public class inventoryController {

    @FXML
    private GridPane grid;

    @FXML 
    private ImageView background;

    public void initialize() {
        System.out.println("HEY");
        background.setImage(new Image("/front/"+ App.mode +"InventoryBackground.png"));
    }
}
