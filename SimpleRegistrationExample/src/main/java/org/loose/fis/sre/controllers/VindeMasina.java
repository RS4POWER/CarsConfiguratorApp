package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.loose.fis.sre.exceptions.VerificareCredentiale;
import org.loose.fis.sre.model.DotariMasini;
import org.loose.fis.sre.services.DotariService;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Boolean.valueOf;

public class VindeMasina {

    @FXML
private Button backButton;
    @FXML
    private Button FinisareButton;

    @FXML
    private CheckBox ChoiceBox1;
    @FXML
    private CheckBox ChoiceBox2;
    @FXML
    private CheckBox ChoiceBox3;
    @FXML
    private CheckBox ChoiceBox4;
    @FXML
    private CheckBox ChoiceBox5;
    @FXML
    private CheckBox ChoiceBox6;
    @FXML
    private CheckBox ChoiceBox7;
    @FXML
    private CheckBox ChoiceBox8;
    @FXML
    private CheckBox ChoiceBox9;
    @FXML
    private CheckBox ChoiceBox10;
    @FXML
    private CheckBox ChoiceBox11;
    @FXML
    private CheckBox ChoiceBox12;
    @FXML
    private CheckBox ChoiceBox13;
    @FXML
    private CheckBox ChoiceBox14;
    @FXML
    private CheckBox ChoiceBox15;
    @FXML
    private CheckBox ChoiceBox16;
    @FXML
    private CheckBox ChoiceBox17;
    @FXML
    private CheckBox ChoiceBox18;
    @FXML
    private CheckBox ChoiceBox19;
    @FXML
    private CheckBox ChoiceBox20;
    @FXML
    private ChoiceBox ChoiceBox21;
    @FXML
    private ChoiceBox ChoiceBox22;
    @FXML
    private ChoiceBox ChoiceBox23;
    @FXML
    private ChoiceBox ChoiceBox24;
    @FXML
    private ImageView image;
    @FXML
    public Label LabelAlegere;


private Stage stage;
private Scene scene;
private Parent root;
@FXML
private ChoiceBox Model;




    public void initialize() throws FileNotFoundException {

       LabelAlegere.setText(String.valueOf(SelectMarca.alegere));
        ChoiceBox22.getItems().addAll("2.0 Diesel", "1.5 Benzina", "Electric");
        ChoiceBox23.getItems().addAll("Manuala","Automata");
        ChoiceBox24.getItems().addAll("Negru","Alb","Rosu","Argintiu","Albastru");

        if (SelectMarca.alegere.equals("Audi")) {
            ChoiceBox21.getItems().addAll("A4");
            ///InputStream stream = new FileInputStream("D:\\Facultate\\fiss\\FisProject2022\\FisProject2022\\SimpleRegistrationExample\\Imagini\\drowdown-vorlage.jpg");
           /* Image image = new Image(stream);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setX(10);
            imageView.setY(10);
            imageView.setFitWidth(575);
            imageView.setPreserveRatio(true);
            Group root = new Group(imageView);
            Scene scene = new Scene(root, 595, 370);
            stage.setScene(scene);
            stage.show(); */

        }
        else if(SelectMarca.alegere.equals("BMW")){
            ChoiceBox21.getItems().addAll("Seria 3");
        }else if(SelectMarca.alegere.equals("Opel")){
            ChoiceBox21.getItems().addAll("Insignia");
        }else if(SelectMarca.alegere.equals("Renault")) {
            ChoiceBox21.getItems().addAll("Megane");
        }

    }

    public void BackButtonOnAction(javafx.event.ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("SelectMarca.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void finisareButtonOnAction(javafx.event.ActionEvent event) throws IOException {

        DotariService.addDotari( String.valueOf(ChoiceBox21.getValue()),
                String.valueOf(ChoiceBox22.getValue()),
                String.valueOf(ChoiceBox23.getValue()),
                String.valueOf(ChoiceBox24.getValue()),String.valueOf(ChoiceBox1.isSelected()),   String.valueOf(ChoiceBox2.isSelected()),   String.valueOf(ChoiceBox3.isSelected()),  String.valueOf(ChoiceBox4.isSelected()), String.valueOf(ChoiceBox5.isSelected()),  String.valueOf(ChoiceBox6.isSelected()), String.valueOf(ChoiceBox7.isSelected()),
                 String.valueOf(ChoiceBox8.isSelected()),
                 String.valueOf(ChoiceBox9.isSelected()),
                String.valueOf(ChoiceBox10.isSelected()),
                String.valueOf(ChoiceBox11.isSelected()),
                 String.valueOf(ChoiceBox12.isSelected()),
                 String.valueOf(ChoiceBox13.isSelected()),
                 String.valueOf(ChoiceBox14.isSelected()),
                 String.valueOf(ChoiceBox15.isSelected()),
                String.valueOf(ChoiceBox16.isSelected()),
                String.valueOf(ChoiceBox17.isSelected()),
                 String.valueOf(ChoiceBox18.isSelected()),
                 String.valueOf(ChoiceBox19.isSelected()),
                String.valueOf(ChoiceBox20.isSelected()));




        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("IstoricComenziVanzator.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void LogOutOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
