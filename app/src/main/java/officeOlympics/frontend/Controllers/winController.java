package officeOlympics.frontend.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class winController {

    @FXML
    private ImageView winImage;

    public void initialize() {
        winImage.setImage(new javafx.scene.image.Image("/front/winBackground.png"));
    }

}
