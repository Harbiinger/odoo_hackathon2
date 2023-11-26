package officeOlympics.frontend.Controllers;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
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
import officeOlympics.backend.Person;


public class susViewController  {

    private Stage stage;
    private Scene scene;
    private Parent pane;
    private ActionEvent actionEvent;

    private boolean accuseMode = false;
    

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

    @FXML
    private Button accuseButton;


    public void initialize(){
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


        accuseButton.setOnAction(actionEvent1 -> {
            try {
                switchAccuseMode(actionEvent1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });



    }

    public void talkTo1() throws IOException {
        App.currentPerson = App.peopleList.get(0);
        if (accuseMode){
            checkIfGuilty(App.currentPerson);
        }
        else {
            App.currentPerson = App.peopleList.get(0);
            try {
                goToDialog();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void talkTo2() throws IOException {
        App.currentPerson = App.peopleList.get(1);
        if (accuseMode){
            checkIfGuilty(App.currentPerson);
        }
        else {
            try {
                goToDialog();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void talkTo3() throws IOException {
        App.currentPerson = App.peopleList.get(2);
        if (accuseMode) {
            checkIfGuilty(App.currentPerson);
        }
        else {
            try {
                goToDialog();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void talkTo4() throws IOException {
        App.currentPerson = App.peopleList.get(3);
        if (accuseMode){
            checkIfGuilty(App.currentPerson);
        }
        else {
            try {
                goToDialog();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void displayInventory() throws IOException {
        URL url = App.class.getResource("/front/inventory.fxml");
        pane = FXMLLoader.load(url);
        stage = App.stage;
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void switchAccuseMode() {
        App.accuseMode = !App.accuseMode;
    }

    public void checkIfGuilty(Person person) throws IOException {
        if (person.isGuilty()){
            System.out.println("You win");

            URL url = App.class.getResource("/front/win.fxml");
            pane = FXMLLoader.load(url);
            stage = App.stage;
            scene = new Scene(pane);
            stage.setScene(scene);
            stage.show();

        }
        else{
            System.out.println("You lose");
            URL url = App.class.getResource("/front/lose.fxml");
            pane = FXMLLoader.load(url);
            stage = App.stage;
            scene = new Scene(pane);
            stage.setScene(scene);
            stage.show();
        }
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

    public void switchAccuseMode(ActionEvent actionEvent) throws IOException {
        accuseMode = !accuseMode;

        if (accuseMode){
            accuseButton.setStyle("-fx-background-color: #572b0b; -fx-border-color: #1a0902; -fx-border-radius: 16; -fx-border-width: 4; -fx-background-radius: 32");
        }
        else{
            accuseButton.setStyle("-fx-background-color: #965238; -fx-border-color: #1a0902; -fx-border-radius: 16; -fx-border-width: 4; -fx-background-radius: 32");
            accuseButton.setCursor(Cursor.DEFAULT);
            suspect1Button.setCursor(Cursor.DEFAULT);
            suspect2Button.setCursor(Cursor.DEFAULT);
            suspect3Button.setCursor(Cursor.DEFAULT);
            suspect4Button.setCursor(Cursor.DEFAULT);
        }
    }


}
