package org.loose.fis.sre.controllers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.loose.fis.sre.exceptions.VerificareCredentiale;
import org.loose.fis.sre.services.UserService;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;
import java.util.ResourceBundle;
import java.net.URL;

public class LoginController implements Initializable {
    @FXML
    private Button RegisterButton;

    @FXML
    private Label labelError;

    @FXML
    private ImageView brandingImageView;
    @FXML
    private TextField UsernameTextField;
    @FXML
    private PasswordField PasswordTextField;

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle){
        File brandingFile = new File ("imagini/pozaloggin.jpeg");
        Image brandingImage= new Image (brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

    }
    public void  loginButtonOnAction(ActionEvent event) throws IOException {
        if(!UsernameTextField.getText().isBlank() && !PasswordTextField.getText().isBlank())
        {
            try {
                String role="";

                role = UserService.verificareLogin(UsernameTextField.getText(), PasswordTextField.getText());
                if(role.equals("Vanzator")) {
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SelectMarca.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }

                    if(role.equals("Cumparator"))
                    {
                       Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SelectMarcaCumparator.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    }


            }catch(VerificareCredentiale e){
                labelError.setText(e.getMessage());
                UsernameTextField.clear();
                PasswordTextField.clear();

            }
        }

    }
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void RegisterButtonOnAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}