package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectMarca  implements Initializable  {
    @FXML
    private ChoiceBox<String> marca= new ChoiceBox<>();

    @FXML
    Label labelError;
    @FXML
   private Button AdaugaMasina;
    @FXML
    private Button LogOut;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static String alegere;

   public void  AdaugaMasinaOnAction(ActionEvent event) throws IOException{

       if(!marca.getSelectionModel().isEmpty()) {
           alegere = marca.getSelectionModel().getSelectedItem().toString();
           Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("interfataVindeMasina.fxml"));
           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
       }else if(marca.getSelectionModel().isEmpty())

       {
            labelError.setText("SELECTATI MARCA!");
       }


   }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        marca.getItems().addAll("Audi", "BMW", "Renault", "Opel");

    }

    public void LogOutOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

