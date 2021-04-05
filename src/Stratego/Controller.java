package Stratego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable
{
    @FXML
    private CheckBox RM,AA,PWP;
    @FXML
    private Button NewGame,LoadGame,Options,Exit,Save,SaveOne,SaveTwo,SaveThree,SaveFour,
            SlotOne,SlotTwo,SlotThree,SlotFour, GoBack,SaveOptions;
    private Boolean Password,Advantage,Rescue;
    @FXML
    public void HandleButtonAction(ActionEvent actionEvent) throws Exception
    {
        Stage stage = null;
        Parent root = null;

        if (actionEvent.getSource() == NewGame)
        {
            stage = (Stage) NewGame.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLFiles/Game.fxml"));
        }
        else if(actionEvent.getSource() == LoadGame)
        {
            stage = (Stage) LoadGame.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLFiles/LoadGame.fxml"));
        }
        else if(actionEvent.getSource()==Options)
        {
            stage = (Stage) Options.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLFiles/Options.fxml"));
        }
        else if(actionEvent.getSource()==Save)
        {
            stage = (Stage) Save.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLFiles/SaveGame.fxml"));
        }
        else if(actionEvent.getSource()==GoBack)
        {
            stage = (Stage) GoBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLFiles/HomePage.fxml"));
        }
        else if (actionEvent.getSource()==SaveOptions)
        {
            stage = (Stage) GoBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLFiles/HomePage.fxml"));
            Password = PWP.isSelected();
            Advantage = AA.isSelected();
            Rescue = RM.isSelected();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle RB)
    {

    }



    public void SaveGame(ActionEvent actionEvent) {
        if(actionEvent.getSource() == SaveOne)
        {
            File SaveFile = new File("/Users/stevenarteaga/Documents/COP3252/FXML/src/sample/SaveOne.txt");
            if (SaveFile.exists()) {
                OverWritePrompt.Display();
            }
        }
        else if(actionEvent.getSource()==SaveTwo)
        {
            File SaveFile = new File("/Users/stevenarteaga/Documents/COP3252/FXML/src/sample/SaveTwo.txt");
            if(SaveFile.exists())
            {
                OverWritePrompt.Display();
            }
        }
        else if(actionEvent.getSource()==SaveThree)
        {
            File SaveFile = new File("/Users/stevenarteaga/Documents/COP3252/FXML/src/sample/SaveThree.txt");
            if(SaveFile.exists())
            {
                OverWritePrompt.Display();
            }
        }
        else if(actionEvent.getSource()==SaveFour)
        {
            File SaveFile = new File("/Users/stevenarteaga/Documents/COP3252/FXML/src/sample/SaveFour.txt");
            if(SaveFile.exists())
            {
                OverWritePrompt.Display();
            }
        }
    }

}
class OverWritePrompt
{
    public static void Display()
    {
        Button Yes = new Button("Yes");
        Button No = new Button("No");

        Stage OverWritePopUp = new Stage();
        OverWritePopUp.initModality(Modality.APPLICATION_MODAL);
        OverWritePopUp.setTitle("Overwrite Warning");
        OverWritePopUp.setMinWidth(300);
        No.setOnAction(e -> OverWritePopUp.close());
        Yes.setOnAction(e-> OverWritePopUp.close());
        VBox Layout = new VBox();

        Label WarningMessage = new Label("This file already exist! Would you like to Overwrite it?");
        Layout.getChildren().addAll(WarningMessage,Yes,No);
        Layout.setAlignment(Pos.CENTER);
        Scene OverWriteScene = new Scene(Layout);
        OverWritePopUp.setScene(OverWriteScene);
        OverWritePopUp.show();
    }
}