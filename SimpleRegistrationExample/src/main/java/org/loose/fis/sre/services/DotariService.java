
package org.loose.fis.sre.services;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.DotariMasini;
import org.loose.fis.sre.model.User;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

 import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class DotariService {




public static void addDotari(String ChoiceBox21,
                             String ChoiceBox22,
                             String ChoiceBox23,
                             String ChoiceBox24,
                             String ChoiceBox1,
                             String ChoiceBox2,
                             String ChoiceBox3,
                             String ChoiceBox4,
                             String ChoiceBox5,
                             String ChoiceBox6,
                             String ChoiceBox7,
                             String ChoiceBox8,
                             String ChoiceBox9,
                             String ChoiceBox10,
                             String ChoiceBox11,
                             String ChoiceBox12,
                             String ChoiceBox13,
                             String ChoiceBox14,
                             String ChoiceBox15,
                             String ChoiceBox16,
                             String ChoiceBox17,
                             String ChoiceBox18,
                             String ChoiceBox19,
                             String ChoiceBox20){


        UserService.dotariMasiniObjectRepository.insert(new DotariMasini(ChoiceBox21, ChoiceBox22, ChoiceBox23, ChoiceBox24,
                ChoiceBox1,
                ChoiceBox2,
                ChoiceBox3,
                ChoiceBox4,
                ChoiceBox5,
                ChoiceBox6,
                ChoiceBox7,
                ChoiceBox8,
                ChoiceBox9,
                ChoiceBox10,
                ChoiceBox11,
                ChoiceBox12,
                ChoiceBox13,
                ChoiceBox14,
                ChoiceBox15,
                ChoiceBox16,
                ChoiceBox17,
                ChoiceBox18,
                ChoiceBox19,
                ChoiceBox20));
        }


    public static List<DotariMasini> getAllDotari() {
        return UserService.dotariMasiniObjectRepository.find().toList();
    }
}

