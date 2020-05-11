package ua.object1.mmclub;

import ua.object1.mmclub.dao.RegistrationDaoImpl;
import ua.object1.mmclub.domain.Security;
import ua.object1.mmclub.domain.User;
import ua.object1.mmclub.domain.UserInformation;

import java.sql.SQLException;
import java.time.LocalDate;

public class mmclubStart {
    public static void main(String[] args) throws SQLException {

        setupDB();
        Security sec = logingUser();
        System.out.println(sec);

        if(sec.isLogged())
        {
            UserInformation user = getUserInformation(sec.getUserID());
            System.out.println(user);
        }

    }

    private static void setupDB() throws SQLException
    {
        if (!logingUser().isLogged()) {
            saveUser();
        }
    }


    private static void saveUser() throws SQLException {

        User user = CreateUser();
        Long id = new RegistrationDaoImpl().saveUser(user);
        System.out.println(id);
    }

    private static Security logingUser() throws SQLException{
        Security sec = new RegistrationDaoImpl().loginUser("User1", "12345");
        return sec;
    }

    private static UserInformation getUserInformation(Long id) throws SQLException{
        UserInformation user = new RegistrationDaoImpl().getUserInformation(id);
        return user;
    }

    private static User CreateUser() {
        User user = new User();
        user.setNickName("User1");
        user.setUserPass("12345");
        user.setUserEmail("char@on.ua");
        user.setSecurityAnswer("Answer");
        user.setFullName("Slava");
        user.setUserBirthDay(LocalDate.of(1983,3,28));
        user.setCharacterBirthDay(LocalDate.now());
        user.setUserGender("M");
        user.setUserCity("Yalta");
        user.setIcqNumber("1234567890");

        return user;
    }


}
