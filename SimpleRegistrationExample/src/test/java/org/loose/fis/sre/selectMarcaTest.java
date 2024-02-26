package org.loose.fis.sre;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.fis.sre.controllers.AlegeMarca;
import org.loose.fis.sre.controllers.SelectMarca;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.nio.file.Paths;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.assertions.api.Assertions.assertThat;
import static org.testfx.util.NodeQueryUtils.isVisible;

@ExtendWith(ApplicationExtension.class)
class selectMarcaTest {

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SelectMarca.fxml"));
        primaryStage.setTitle("selectMarca-test");
        primaryStage.setScene(new Scene(root, 834, 570));
        primaryStage.show();
    }
    @AfterEach
    void tearDown ()
    {
        UserService.closeDatabase();
    }
    @Test
    void testLogin(FxRobot robot) {

       robot.clickOn("#AdaugaMasina");
       assertThat(robot.lookup("#labelError").queryLabeled()).hasText("SELECTATI MARCA!");

       robot.clickOn("#marca");
        robot.type(KeyCode.DOWN);
      robot.type(KeyCode.ENTER);
    robot.clickOn("#AdaugaMasina");
    
    }
}