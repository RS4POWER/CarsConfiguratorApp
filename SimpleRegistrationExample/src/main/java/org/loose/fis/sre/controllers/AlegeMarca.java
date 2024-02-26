package org.loose.fis.sre.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class AlegeMarca {

    Parent root = null;
    private Stage stage;
    private Scene scene;
    @FXML
    private ChoiceBox marciauto;
    @FXML
    private Label selecteazaMarca;

    public static String selectare;

    public void initialize() { marciauto.getItems().addAll("Audi", "BMW", "Renault", "Opel");
    }

    public void selecteazaMasinaOnAction(ActionEvent event){
        if(marciauto.getSelectionModel().isEmpty()){
            selecteazaMarca.setText("Selecteaza o marca din lista de mai sus!");
        }else{
            try {
                selectare = marciauto.getSelectionModel().getSelectedItem().toString();
                root = FXMLLoader.load(getClass().getClassLoader().getResource("MainMenu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (IOException e) {
                e.printStackTrace();
             }

        }
        }

    public void buttonLogoutOnAction(ActionEvent event) {
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


