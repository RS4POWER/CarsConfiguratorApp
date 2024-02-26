package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;





public class MainMenu {
    @FXML
    Label selecteazaMarca;
     Parent root = null;
    private Stage stage;
    private Scene scene;


 public void initialize(){

       selecteazaMarca.setText(String.valueOf(AlegeMarca.selectare));

    }



    public void buttonSelectOnAction(ActionEvent event) {
    }

    public void buttonBackOnAction(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("SelectMarcaCumparator.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buttonLogoutInAction(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
