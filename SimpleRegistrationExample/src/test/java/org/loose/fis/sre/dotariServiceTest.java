package org.loose.fis.sre;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.fis.sre.model.DotariMasini;
import org.loose.fis.sre.services.DotariService;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.testfx.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Paths;


import static org.junit.Assert.assertThat;

@ExtendWith(ApplicationExtension.class)
public class dotariServiceTest {

    @BeforeEach
    void start() throws IOException {
        FileSystemService.APPLICATION_FOLDER = ".vindeMasina-test";
        FileSystemService.APPLICATION_HOME_PATH = Paths.get(FileSystemService.USER_FOLDER, FileSystemService.APPLICATION_FOLDER);
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
    }


    @AfterEach
    void tearDown ()
    {
        UserService.closeDatabase();
    }

    @Test
    @DisplayName("Dotare adaugata cu succes in baza de date")
    public void testAdaugareDotare(){
        DotariService.addDotari("A4","Electric","Manuala","Rosu","True","True","True","False","False","False","False","False","False","False","False","False","False","False","False","False","False","False","False","False");
        assertThat(DotariService.getAllDotari()).isNotEmpty();
        assertThat(DotariService.getAllDotari()).size().isEqualTo(1);

        DotariMasini dm = DotariService.getAllDotari().get(0);
        assertThat(dm).isNotNull();
        assertThat(dm.getChoiceBox1()).isEqualTo("A4");
        assertThat(dm.getChoiceBox2()).isEqualTo("Electric");
        assertThat(dm.getChoiceBox3()).isEqualTo("Manuala");
        assertThat(dm.getChoiceBox4()).isEqualTo("Rosu");
        assertThat(dm.getChoiceBox5()).isEqualTo("True");
        assertThat(dm.getChoiceBox6()).isEqualTo("True");
        assertThat(dm.getChoiceBox7()).isEqualTo("True");
        assertThat(dm.getChoiceBox8()).isEqualTo("False");
        assertThat(dm.getChoiceBox9()).isEqualTo("False");
        assertThat(dm.getChoiceBox10()).isEqualTo("False");
        assertThat(dm.getChoiceBox11()).isEqualTo("False");
        assertThat(dm.getChoiceBox12()).isEqualTo("False");
        assertThat(dm.getChoiceBox13()).isEqualTo("False");
        assertThat(dm.getChoiceBox14()).isEqualTo("False");
        assertThat(dm.getChoiceBox15()).isEqualTo("False");
        assertThat(dm.getChoiceBox16()).isEqualTo("False");
        assertThat(dm.getChoiceBox17()).isEqualTo("False");
        assertThat(dm.getChoiceBox18()).isEqualTo("False");
        assertThat(dm.getChoiceBox19()).isEqualTo("False");
        assertThat(dm.getChoiceBox20()).isEqualTo("False");
        assertThat(dm.getChoiceBox21()).isEqualTo("False");
        assertThat(dm.getChoiceBox22()).isEqualTo("False");
        assertThat(dm.getChoiceBox23()).isEqualTo("False");
        assertThat(dm.getChoiceBox24()).isEqualTo("False");






    }


}


