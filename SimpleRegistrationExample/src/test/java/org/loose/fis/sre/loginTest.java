package org.loose.fis.sre;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.nio.file.Paths;

import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class loginTest {

    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test-login";
        FileSystemService.APPLICATION_HOME_PATH = Paths.get(FileSystemService.USER_FOLDER, FileSystemService.APPLICATION_FOLDER);
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
    }

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("login-Test");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
    }
    @AfterEach
    void tearDown ()
    {
        UserService.closeDatabase();
    }

    @Test
    void testLogin(FxRobot robot) {

        robot.clickOn("#UsernameTextField");
        robot.write(USERNAME);
        robot.clickOn("#PasswordTextField");
        robot.write(PASSWORD);
        robot.clickOn("#loginButton");
        robot.write("1");
       assertThat(robot.lookup("#labelError").queryLabeled()).hasText("Username sau parola gresita!");
        assertThat(UserService.getAllUsers()).size().isEqualTo(0);

        UserService.userRepository.insert(new User("user","password","Vanzator"));

        robot.clickOn("#UsernameTextField");
        robot.write(USERNAME);
        robot.clickOn("#PasswordTextField");
        robot.write(PASSWORD);
        robot.clickOn("#loginButton");
        robot.write("2");
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
    }
}



