package officeOlympics.frontend.Controllers;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
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
        // bg
        susBackground.setImage(new Image("/front/"+ App.mode+"Background.png"));
        BoxBlur blur = new BoxBlur(7, 7, 3);
        susBackground.setEffect(blur); 
        // Create a DropShadow effect with a white color
        DropShadow haloEffect = new DropShadow();
        haloEffect.setColor(Color.WHITE);
        haloEffect.setRadius(20); // Set the radius according to your preference
        // suspects pictures
        System.out.println("/front/"+App.peopleList.get(0).getFirstName()+".png");
        imageHolder1.setImage(new Image("/front/"+App.peopleList.get(0).getFirstName()+".png"));
        imageHolder1.setEffect(haloEffect);
        imageHolder2.setImage(new Image("/front/"+App.peopleList.get(1).getFirstName()+".png"));
        imageHolder2.setEffect(haloEffect);
        imageHolder3.setImage(new Image("/front/"+App.peopleList.get(2).getFirstName()+".png"));
        imageHolder3.setEffect(haloEffect);
        imageHolder4.setImage(new Image("/front/"+App.peopleList.get(3).getFirstName()+".png"));
        imageHolder4.setEffect(haloEffect);
        // suspects images
        suspect1Name.setText(App.peopleList.get(0).getFirstName() + " " + App.peopleList.get(0).getLastName());
        suspect1Name.setTextFill(Color.WHITE);
        suspect1Name.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        suspect2Name.setText(App.peopleList.get(1).getFirstName() + " " + App.peopleList.get(1).getLastName());
        suspect2Name.setTextFill(Color.WHITE);
        suspect2Name.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        suspect3Name.setText(App.peopleList.get(2).getFirstName() + " " + App.peopleList.get(2).getLastName());
        suspect3Name.setTextFill(Color.WHITE);
        suspect3Name.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        suspect4Name.setText(App.peopleList.get(3).getFirstName() + " " + App.peopleList.get(3).getLastName());
        suspect4Name.setTextFill(Color.WHITE);
        suspect4Name.setFont(Font.font("Arial", FontWeight.BOLD, 18));

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
        App.currentPerson = App.peopleList.get(2);
        try {
            goToDialog();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void talkTo4() {
        App.currentPerson = App.peopleList.get(3);
        try {
            goToDialog();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayInventory() {
        System.out.println("Display Inventory");
    }

    public void switchAccuseMode() {
        App.accuseMode = !App.accuseMode;
    }

    public void backToEraSelection(ActionEvent actionEvent) throws IOException {
        URL url = App.class.getResource("/front/eraSelection.fxml");
        pane = FXMLLoader.load(url);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void goToChangingRoom(ActionEvent actionEvent) throws IOException {
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
