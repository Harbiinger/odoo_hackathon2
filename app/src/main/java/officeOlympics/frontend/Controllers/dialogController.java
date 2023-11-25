package officeOlympics.frontend.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import officeOlympics.App;

public class dialogController implements Initializable {

    private Pane pane;

    private Stage stage;

    private Scene scene;
    private ActionEvent actionEvent;

    @FXML
    private Button backButton;

    @FXML
    private Button inventoryButton;

    @FXML
    private ImageView suspectPicture;

    @FXML
    private TextField dialogOption1;

    @FXML
    private TextField dialogOption2;

    @FXML
    private TextField dialogOption3;

    @FXML
    private Label suspectName;

    @FXML
    private Label suspectDesc;


    public void back(ActionEvent actionEvent) throws IOException {
        URL url = App.class.getResource("/front/susView.fxml");
        pane = FXMLLoader.load(url);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void displayInventory(ActionEvent actionEvent) throws IOException {
        System.out.println("Display Inventory");
    }

    public void chooseOption1(ActionEvent actionEvent) throws IOException {
        System.out.println("Option 1");
    }

    public void chooseOption2(ActionEvent actionEvent) throws IOException {
        System.out.println("Option 2");
    }

    public void chooseOption3(ActionEvent actionEvent) throws IOException {
        System.out.println("Option 3");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backButton.setText("Back");
        inventoryButton.setText("Inventory");
        dialogOption1.setText("Option 1");
        dialogOption2.setText("Option 2");
        dialogOption3.setText("Option 3");
        suspectName.setText("Suspect Name");
        suspectDesc.setText("Suspect Description");
    }
}
