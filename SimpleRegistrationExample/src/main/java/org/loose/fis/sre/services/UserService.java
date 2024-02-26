package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.VerificareCredentiale;
import org.loose.fis.sre.model.DotariMasini;
import org.loose.fis.sre.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class UserService {


    public static ObjectRepository<DotariMasini> dotariMasiniObjectRepository;
    public static ObjectRepository<User> userRepository;
   private static Nitrite database;
    public static void initDatabase() {
        database = Nitrite.builder()
                .filePath(getPathToFile("registration-example.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);

        dotariMasiniObjectRepository = database.getRepository(DotariMasini.class);

        findLastDotariNr();

    }
    public static void closeDatabase()
    {
        database.close();
    }
    private static void findLastDotariNr(){
        if(dotariMasiniObjectRepository!=null) {
            for (DotariMasini parcurgere : dotariMasiniObjectRepository.find()) {
                DotariMasini.nrGeneral = parcurgere.getNr() ;
            }
            return ;
        }

        DotariMasini.nrGeneral=0;
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username,  password, role));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }



    public static String verificareLogin (String username, String pass) throws VerificareCredentiale {
        int found = 0;
        String role="";
        for (User user : userRepository.find()) {
            if (username.equals(user.getUsername())) {
                found = 1;
                role = user.getRole();
            }
        }
        if(found == 0) throw new VerificareCredentiale();

        found = 0;

        for (User user : userRepository.find()) {

            if (pass.equals(user.getPassword()))
                found = 1;
        }

        if (found == 0)
            throw new VerificareCredentiale();

        return role;
    }

    public static List<User> getAllUsers() {
        return userRepository.find().toList();
    }
}
