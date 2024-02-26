package org.loose.fis.sre;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import static org.testfx.assertions.api.Assertions.assertThat;


@ExtendWith(ApplicationExtension.class)
class alegeMarcaTest {

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SelectMarcaCumparator.fxml"));
        primaryStage.setTitle("alegeMarca-test");
        primaryStage.setScene(new Scene(root, 834, 570));
        primaryStage.show();
    }

    @Test
    void testLogin(FxRobot robot) {

        robot.clickOn("#selectButton");
        assertThat(robot.lookup("#selecteazaMarca").queryLabeled()).hasText("Selecteaza o marca din lista de mai sus!");

        robot.clickOn("#marciauto");
        robot.type(KeyCode.DOWN);
        robot.type(KeyCode.ENTER);
        robot.clickOn("#selectButton");

    }
}
