package officeOlympics.frontend.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class loseController {

    @FXML
    private ImageView loseImage;

    public void initialize() {
        loseImage.setImage(new javafx.scene.image.Image("/front/loseBackground.png"));
    }

}
