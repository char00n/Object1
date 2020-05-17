package ua.object1.mmclub.dao;

import ua.object1.mmclub.domain.character.Character;
import ua.object1.mmclub.domain.character.Stat;
import ua.object1.mmclub.domain.constants.DbCharacter;
import ua.object1.mmclub.domain.register.User;
import ua.object1.mmclub.domain.register.UserRegistration;

import java.sql.*;

public class CharacterDaoImpl implements CharacterDao
{

    private static final String INSERT_CHARACTER_DEF =
        " INSERT INTO mmc_character(char_user_id, char_name, char_birth_day, char_gender ) \n" +
            "    VALUES (?, ?, ?, ?) ";

    private static final String SELECT_CHARACTER =
        "SELECT \n" +
            "    char_name, char_birth_day, char_gender, \n" +
            "    char_stat_strength, char_stat_strength_total, \n" +
            "    char_stat_endurance, char_stat_endurance_total, \n" +
            "    char_stat_accuracy, char_stat_accuracy_total, \n" +
            "    char_stat_dexterity, char_stat_dexterity_total, \n" +
            "    char_stat_cur_health, char_stat_max_health, char_stat_unused_points \n" +
            " FROM mmc_character \n" +
            " WHERE char_user_id = ? ";

    @Override
    public Character readCharacter(User user) throws SQLException {

        if (!user.isLogged())
        {
            return null;
        }

        Character character = null;

        try (Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_CHARACTER))
        {
            stmt.setLong(1, user.getUserID());
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                character = getCharacter(user, rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return character;
    }

    private Character getCharacter(User user, ResultSet rs) throws SQLException {
        Character character = new Character();

        character.setUser(user);
        character.setName(rs.getString(DbCharacter.NAME));
        character.setBirthDay(rs.getDate(DbCharacter.DT).toLocalDate());
        character.setGender(rs.getString(DbCharacter.GENDER));

        Stat stat = getStat(rs);
        character.setCharStat(stat);

        return character;
    }

    private Stat getStat(ResultSet rs) throws SQLException {
        Stat stat = new Stat();
        stat.setStrength(rs.getInt(DbCharacter.STAT_STRENGTH));
        stat.setStrengthTotal(rs.getInt(DbCharacter.STAT_STRENGTH_TOTAL));
        stat.setEndurance(rs.getInt(DbCharacter.STAT_ENDURANCE));
        stat.setEnduranceTotal(rs.getInt(DbCharacter.STAT_ENDURANCE_TOTAL));
        stat.setAccuracy(rs.getInt(DbCharacter.STAT_ACCURACY));
        stat.setAccuracyTotal(rs.getInt(DbCharacter.STAT_ACCURACY_TOTAL));
        stat.setDexterity(rs.getInt(DbCharacter.STAT_DEXTERITY));
        stat.setDexterityTotal(rs.getInt(DbCharacter.STAT_DEXTERITY_TOTAL));
        stat.setCurHealth(rs.getInt(DbCharacter.STAT_CUR_HEALTH));
        stat.setMaxHealth(rs.getInt(DbCharacter.STAT_MAX_HEALTH));
        stat.setUnUsedPoints(rs.getInt(DbCharacter.STAT_UNUSED_POINTS));

        return stat;
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
