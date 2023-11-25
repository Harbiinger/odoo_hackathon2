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
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import officeOlympics.App;
import javafx.scene.effect.BoxBlur;

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

    @FXML 
    private ImageView susBackground; 

    @FXML
    private Label suspect1Name;

    @FXML
    private Label suspect2Name;

    @FXML
    private Label suspect3Name;

    @FXML
    private Label suspect4Name;

    public void initialize() {
        susBackground.setImage(new Image("/front/"+ App.mode+"Background.png"));
        BoxBlur blur = new BoxBlur(5, 5, 3);
        susBackground.setEffect(blur);
        imageHolder1.setImage(new Image("/front/"+App.peopleList.get(0).getFirstName()+".png"));
        suspect1Name.setText(App.peopleList.get(0).getFirstName() + " " + App.peopleList.get(0).getLastName());
        imageHolder2.setImage(new Image("/front/"+App.peopleList.get(1).getFirstName()+".png"));
        suspect2Name.setText(App.peopleList.get(1).getFirstName() + " " + App.peopleList.get(1).getLastName());
        imageHolder3.setImage(new Image("/front/"+App.peopleList.get(2).getFirstName()+".png"));
        suspect3Name.setText(App.peopleList.get(2).getFirstName() + " " + App.peopleList.get(2).getLastName());
        imageHolder4.setImage(new Image("/front/"+App.peopleList.get(3).getFirstName()+".png"));
        suspect4Name.setText(App.peopleList.get(3).getFirstName() + " " + App.peopleList.get(3).getLastName());
    }

    public void talkTo1() {
        App.currentPerson = App.peopleList.get(0);
        try {
            goToDialog();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void talkTo2() {
        App.currentPerson = App.peopleList.get(1);
        try {
            goToDialog();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void talkTo3() {
    }

    public void talkTo4() {
    }

    public void displayInventory() {
        System.out.println("Display Inventory");
    }

    public void accuse() {
        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("Accuse");
    }

    public void goToChangingRoom() throws IOException {
        URL url = App.class.getResource("/front/lockerRoom.fxml");
        pane = FXMLLoader.load(url);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void goToDialog() throws IOException {
        URL url = App.class.getResource("/front/dialog.fxml");
        pane = FXMLLoader.load(url);
        stage = App.stage;
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


}
