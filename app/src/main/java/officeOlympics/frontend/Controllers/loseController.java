package officeOlympics.frontend.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import officeOlympics.App;

import java.io.IOException;
import java.net.URL;

public class loseController {

    @FXML
    private ImageView loseImage;

    public void initialize() {
        loseImage.setImage(new javafx.scene.image.Image("/front/" + App.mode +  "LoseBackground.png"));
    }

    public void backToEra(MouseEvent actionEvent) throws IOException {
        URL url = App.class.getResource("/front/eraSelection.fxml");
        Pane pane = FXMLLoader.load(url);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


}
