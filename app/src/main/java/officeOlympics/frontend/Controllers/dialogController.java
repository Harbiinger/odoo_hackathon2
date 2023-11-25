package officeOlympics.frontend.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import officeOlympics.App;
import officeOlympics.backend.Choice;
import officeOlympics.backend.Interaction;
import officeOlympics.backend.Person;

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
    private Label suspectNameLabel;

    @FXML
    private Label suspectDesc;

    @FXML
    private TextArea dialogBox;


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
        Person currentPerson = App.currentPerson;
        Interaction interaction = currentPerson.getCurrentInteraction();
        backButton.setText("Back");
        inventoryButton.setText("Inventory");
        dialogBox.setText(interaction.getText());

        ArrayList<Choice> choices = interaction.getChoices();
        dialogOption1.setText(choices.get(0).getValue());
        dialogOption2.setText(choices.get(1).getValue());
        dialogOption3.setText(choices.get(2).getValue());
        suspectNameLabel.setText(currentPerson.getFirstName() + " " + currentPerson.getLastName());
        suspectPicture.setImage(new Image("/front/"+currentPerson.getFirstName()+".png"));
        suspectDesc.setText("");
    }
}
