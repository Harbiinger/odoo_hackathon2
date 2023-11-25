package officeOlympics.frontend.Controllers;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import officeOlympics.App;

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

    @FXML
    private ImageView imageHolder1;

    @FXML
    private ImageView imageHolder2;

    @FXML
    private ImageView imageHolder3;

    @FXML
    private ImageView imageHolder4;

    public void initialize() {
    }

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
        URL url = App.class.getResource("/front/lockerRoom.fxml");
        pane = FXMLLoader.load(url);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }



}
