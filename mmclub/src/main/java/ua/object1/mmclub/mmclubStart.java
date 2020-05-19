package ua.object1.mmclub;

import ua.object1.mmclub.dao.CharacterDaoImpl;
import ua.object1.mmclub.dao.RegistrationDaoImpl;
import ua.object1.mmclub.domain.constants.UtUserRegistration;
import ua.object1.mmclub.domain.enums.Gender;
import ua.object1.mmclub.domain.register.User;
import ua.object1.mmclub.domain.register.UserRegistration;
import ua.object1.mmclub.domain.character.Character;

import java.sql.SQLException;
import java.time.LocalDate;

public class mmclubStart {
    public static void main(String[] args) throws SQLException {

        setupDB();
        User user = logingUser();
        System.out.println(user);

        Character character = readCharacter(user);
        System.out.println(character);
    }

    private static Character readCharacter(User user) throws SQLException
    {
        Character character = null;
        if (user.isLogged())
        {
            character = new CharacterDaoImpl().readCharacter(user);
        }
        return character;
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
        User sec = new RegistrationDaoImpl().loginUser(UtUserRegistration.NICK_1, UtUserRegistration.PASS_1);
        return sec;
    }


    private static UserRegistration CreateUser() {
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.setNickName(UtUserRegistration.NICK_1);
        userRegistration.setUserPass(UtUserRegistration.PASS_1);
        userRegistration.setUserEmail(UtUserRegistration.EMAIL_1);
        userRegistration.setSecurityAnswer(UtUserRegistration.ANSWER_1);
        userRegistration.setFullName(UtUserRegistration.FULL_NAME_1);
        userRegistration.setUserBirthDay(UtUserRegistration.BIRTH_DAY);
        userRegistration.setCharacterBirthDay(LocalDate.now());
        userRegistration.setUserGender(Gender.fromValue(UtUserRegistration.GENDER_1));
        userRegistration.setUserCity(UtUserRegistration.CITY_1);
        userRegistration.setIcqNumber(UtUserRegistration.ICQ_1);

        return userRegistration;
    }


}
