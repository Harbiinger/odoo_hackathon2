package officeOlympics.frontend.Controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import officeOlympics.App;
import officeOlympics.backend.Object;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Tooltip;

public class inventoryController {

    private Stage stage;
    private Scene scene;
    private Parent pane;
    private ActionEvent actionEvent;

    @FXML
    private GridPane grid;

    @FXML 
    private ImageView background;

    public void initialize() {
        System.out.println(App.objectsList.size());
        background.setImage(new Image("/front/"+ App.mode +"InventoryBackground.png"));
        int i = 0, j = 0;
        for (Object o : App.objectsList) {
            ImageView iv = new ImageView(new Image("/front/"+ App.mode + o.getName() + ".png"));
            iv.setFitWidth(90);
            iv.setFitHeight(90);
            Tooltip tooltip = new Tooltip(o.getDesc());
            Tooltip.install(iv, tooltip);
            grid.add(iv, i++, j); 
            grid.setHalignment(iv, javafx.geometry.HPos.CENTER);
            grid.setValignment(iv, javafx.geometry.VPos.CENTER);
            if (i == 3) {
                i = 0;
                j++;
            }
            if (j == 3) {
                break;
            }
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        URL url = App.class.getResource("/front/susView.fxml");
        pane = FXMLLoader.load(url);
        Stage stage = App.stage;
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
