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
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import officeOlympics.App;
import officeOlympics.backend.Choice;
import officeOlympics.backend.Interaction;
import officeOlympics.backend.ModifyChoice;
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
    private Button dialogOption1;

    @FXML
    private Button dialogOption2;

    @FXML
    private Button dialogOption3;

    @FXML
    private Button dialogOption4;

    @FXML
    private Button dialogOption5;

    @FXML
    private Label suspectNameLabel;

    @FXML
    private Label suspectDesc;

    @FXML
    private TextArea dialogBox;

    @FXML
    private ImageView background;
    @FXML
    private ImageView dialogImageHolder;

    // Button gestion
    private int buttonNumber = 0;


    public void clearButtons() {
        buttonNumber = 0;
        dialogOption1.setVisible(false);
        dialogOption2.setVisible(false);
        dialogOption3.setVisible(false);
        dialogOption4.setVisible(false);
        dialogOption5.setVisible(false);
    }

    public void addButton(Choice text) {
        switch (buttonNumber++) {
            case 0:
                dialogOption1.setVisible(true);
                dialogOption1.setText(text.getValue());
                dialogOption1.setTextFill(Color.WHITE);
                dialogOption1.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                if (text.getSeeb()) {
                    dialogOption1.setStyle("-fx-border-radius: 15; -fx-border-color: #1a0902; -fx-background-color: #757474; -fx-background-radius: 15;");
                }
                break;
            case 1:
                dialogOption2.setVisible(true);
                dialogOption2.setText(text.getValue());
                dialogOption2.setTextFill(Color.WHITE);
                dialogOption2.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                if (text.getSeeb()) {
                    dialogOption1.setStyle("-fx-border-radius: 15; -fx-border-color: #1a0902; -fx-background-color: #757474; -fx-background-radius: 15;");
                }
                break;
            case 2:
                dialogOption3.setVisible(true);
                dialogOption3.setText(text.getValue());
                dialogOption3.setTextFill(Color.WHITE);
                dialogOption3.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                if (text.getSeeb()) {
                    dialogOption1.setStyle("-fx-border-radius: 15; -fx-border-color: #1a0902; -fx-background-color: #757474; -fx-background-radius: 15;");
                }
                break;
            case 3:
                dialogOption4.setVisible(true);
                dialogOption4.setText(text.getValue());
                dialogOption4.setTextFill(Color.WHITE);
                dialogOption4.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                if (text.getSeeb()) {
                    dialogOption1.setStyle("-fx-border-radius: 15; -fx-border-color: #1a0902; -fx-background-color: #757474; -fx-background-radius: 15;");
                }
                break;
            case 4:
                dialogOption5.setVisible(true);
                dialogOption5.setText(text.getValue());
                dialogOption5.setTextFill(Color.WHITE);
                dialogOption5.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                if (text.getSeeb()) {
                    dialogOption1.setStyle("-fx-border-radius: 15; -fx-border-color: #1a0902; -fx-background-color: #757474; -fx-background-radius: 15;");
                }
                break;
            default:
                break;
        }
    }


    public void back(ActionEvent actionEvent) throws IOException {
        App.currentPerson.reset();
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
        changeInteraction(0, actionEvent);
    }

    public void chooseOption2(ActionEvent actionEvent) throws IOException {
        changeInteraction(1, actionEvent);
    }

    public void chooseOption3(ActionEvent actionEvent) throws IOException {
        changeInteraction(2,actionEvent);
    }

    public void chooseOption4(ActionEvent actionEvent) throws IOException {
        changeInteraction(3, actionEvent);
    }

    public void chooseOption5(ActionEvent actionEvent) throws IOException {
        changeInteraction(4, actionEvent);
    }

    public void changeInteraction(int choiceIndex, ActionEvent actionEvent) throws IOException {
        Person currentPerson = App.currentPerson;
        Interaction interaction = currentPerson.getCurrentInteraction();
        Choice currentChoice = interaction.getChoices().get(choiceIndex);
        currentChoice.saw();
        if (currentChoice.getModifyChoices() != null) {
            System.out.println("Choice : " + currentChoice.getValue());
            for (ModifyChoice modifyChoice : currentChoice.getModifyChoices()) {
                Person p = App.game.talk(modifyChoice.getName());
                System.out.println(p.getFirstName() + " " + p.getLastName());
                App.game.modifyChoice(p, modifyChoice.getChoiceId(), modifyChoice.getInteractionId(), !modifyChoice.isUnlock());
            }
        }
        int nextInteractionId = currentChoice.getInteractionDir();
        if (nextInteractionId == -1) {
            back(actionEvent);
        }
        currentPerson.changeInteraction(nextInteractionId);
        dialogBox.setText(currentPerson.getCurrentInteraction().getText());
        ArrayList<Choice> choices = currentPerson.getCurrentInteraction().getChoices();
        clearButtons();

        for(Choice choice : choices){
            addButton(choice);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        background.setImage(new Image("front/"+App.mode+"Background.png"));
        BoxBlur blur = new BoxBlur(7, 7, 3);
        background.setEffect(blur);

        DropShadow haloEffect = new DropShadow();
        haloEffect.setColor(Color.WHITE);
        haloEffect.setRadius(20); // Set the radius according to your preference

        background.setImage(new Image("/front/"+ App.mode+"Background.png"));
        Person currentPerson = App.currentPerson;
        Interaction interaction = currentPerson.getCurrentInteraction();
        backButton.setText("Back");
        inventoryButton.setText("Inventory");
        dialogBox.setText(interaction.getText());

        clearButtons();

        ArrayList<Choice> choices = interaction.getChoices();
        for (Choice choice : choices) {
            addButton(choice);
        }
        suspectNameLabel.setText(currentPerson.getFirstName() + " " + currentPerson.getLastName());
        suspectNameLabel.setTextFill(Color.WHITE);
        suspectNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        suspectPicture.setImage(new Image("/front/"+currentPerson.getFirstName()+".png"));
        suspectPicture.setEffect(haloEffect);
        suspectDesc.setText("");
    }
}
