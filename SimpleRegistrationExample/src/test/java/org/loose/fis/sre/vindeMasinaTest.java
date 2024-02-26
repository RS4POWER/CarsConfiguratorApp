
package org.loose.fis.sre;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.fis.sre.controllers.SelectMarca;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import java.nio.file.Paths;
import static org.testfx.assertions.api.Assertions.assertThat;



@ExtendWith(ApplicationExtension.class)
class vindeMasinaTest {


    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".vindeMasina-test";
        FileSystemService.APPLICATION_HOME_PATH = Paths.get(FileSystemService.USER_FOLDER, FileSystemService.APPLICATION_FOLDER);
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
    }

    @Start
    void start(Stage primaryStage) throws Exception {
        SelectMarca.alegere="Audi";
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("interfataVindeMasina.fxml"));
        primaryStage.setTitle("vindeMasina-Test");
        primaryStage.setScene(new Scene(root, 1020, 1020));
        primaryStage.show();
    }
@AfterEach
void tearDown ()
{
    UserService.closeDatabase();
}

    @Test
    void vindeMasinaTest(FxRobot robot) {

       UserService.userRepository.insert(new User("user","password","Vanzator"));

      robot.clickOn("#ChoiceBox21");
      robot.type(KeyCode.DOWN);
      robot.type(KeyCode.ENTER);

        robot.clickOn("#ChoiceBox22");
        robot.type(KeyCode.DOWN);
        robot.type(KeyCode.ENTER);


        robot.clickOn("#ChoiceBox23");
        robot.type(KeyCode.DOWN);
        robot.type(KeyCode.ENTER);


        robot.clickOn("#ChoiceBox24");
        robot.type(KeyCode.DOWN);
        robot.type(KeyCode.ENTER);

        robot.clickOn("#ChoiceBox1");
        robot.clickOn("#ChoiceBox2");
        robot.clickOn("#ChoiceBox3");
        robot.clickOn("#ChoiceBox16");
        robot.clickOn("#ChoiceBox15");
        robot.clickOn("#FinisareButton");

        Assertions.assertThat(UserService.getAllUsers()).size().isEqualTo(1);



    }
}
