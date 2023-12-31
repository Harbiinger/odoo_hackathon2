package officeOlympics.frontend.Controllers;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import officeOlympics.App;
import officeOlympics.backend.Object;

public class lockerRoomController {

    private Stage stage;
    private Scene scene;
    private javafx.scene.Parent pane;
    private ActionEvent actionEvent;

    @FXML
    private Button backButton;

    @FXML
    private ImageView lockerRoomBackground;

    @FXML
    private Polygon openableLocker;

    @FXML
    private Label objectFoundLabel;

    public void goBack(ActionEvent actionEvent) throws IOException {
        URL url = App.class.getResource("/front/susView.fxml");
        pane = FXMLLoader.load(url);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void searchLocker(MouseEvent mouseEvent) throws IOException {

        System.out.println("Searching locker");

        App.moneyFound = true;
        objectFoundLabel.setVisible(App.moneyFound);
        openableLocker.setVisible(!App.moneyFound);

        App.game.modifyChoice(App.game.talk("Seam"), 3, 0, false);

        Object money = new Object("money", "20 000$ found in Bjorn's locker.");
        App.objectsList.add(money);

    }

    public void initialize() {
        openableLocker.setVisible(!App.moneyFound);
        objectFoundLabel.setVisible(App.moneyFound);
    }

}
