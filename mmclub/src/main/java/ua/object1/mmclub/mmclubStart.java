package ua.object1.mmclub;

import ua.object1.mmclub.dao.CharacterDaoImpl;
import ua.object1.mmclub.dao.RegistrationDaoImpl;
import ua.object1.mmclub.domain.register.User;
import ua.object1.mmclub.domain.register.UserRegistration;

import java.sql.SQLException;
import java.time.LocalDate;

public class mmclubStart {
    public static void main(String[] args) throws SQLException {

        setupDB();
        User sec = logingUser();
        System.out.println(sec);

    }

    private static void setupDB() throws SQLException
    {
        if (!logingUser().isLogged()) {
            saveUser();
        }
    }


    private static void saveUser() throws SQLException {

        UserRegistration userRegistration = CreateUser();
        Long id = new RegistrationDaoImpl().saveUser(userRegistration);
        System.out.println(id);
        boolean save = new CharacterDaoImpl().saveCharacter(userRegistration, id);
        System.out.println(save);
    }

    private static User logingUser() throws SQLException{
        User sec = new RegistrationDaoImpl().loginUser("User1", "12345");
        return sec;
    }


    private static UserRegistration CreateUser() {
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.setNickName("User1");
        userRegistration.setUserPass("12345");
        userRegistration.setUserEmail("char@on.ua");
        userRegistration.setSecurityAnswer("Answer");
        userRegistration.setFullName("Slava");
        userRegistration.setUserBirthDay(LocalDate.of(1983,3,28));
        userRegistration.setCharacterBirthDay(LocalDate.now());
        userRegistration.setUserGender("M");
        userRegistration.setUserCity("Yalta");
        userRegistration.setIcqNumber("1234567890");

        return userRegistration;
    }


}
