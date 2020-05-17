package ua.object1.mmclub.dao;

import ua.object1.mmclub.domain.character.Character;
import ua.object1.mmclub.domain.register.User;
import ua.object1.mmclub.domain.register.UserRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CharacterDaoImpl implements CharacterDao
{

    private static final String INSERT_CHARACTER_DEF =
            " INSERT INTO mmc_character(char_user_id, char_name, char_birth_day, char_gender ) " +
                    " VALUES (?, ?, ?, ?) ";

    @Override
    public Character readCharacter(User user) throws SQLException {

        if (!user.isLogged())
        {
            return null;
        }

        Character character = new Character();



        return character;
    }

    @Override
    public boolean saveCharacter(UserRegistration userRegistration, Long userId) throws SQLException {

        int index = 1;
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_CHARACTER_DEF))
        {
            stmt.setLong(index, userId);
            stmt.setString(++index, userRegistration.getNickName());
            stmt.setDate(++index, java.sql.Date.valueOf(userRegistration.getCharacterBirthDay()));
            stmt.setString(++index, userRegistration.getUserGender());

            stmt.executeUpdate();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            throw ex;
        }

        return true;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/mmclub",
                "postgres", "Postgres");
    }
}
