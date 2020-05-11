package ua.object1.mmclub.dao;

import ua.object1.mmclub.domain.Security;
import ua.object1.mmclub.domain.User;
import ua.object1.mmclub.domain.UserInformation;

import java.sql.*;

public class RegistrationDaoImpl implements RegistrationDao {

    private static final String INSERT_USER =
            "INSERT INTO mmc_users(user_login, user_pass,  user_email, user_security_answer, " +
                    "user_full_Name, user_birth_Day, " +
                    "user_gender, user_city, user_icq_number ) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

    private static final String INSERT_CHARACTER =
            " INSERT INTO mmc_character(char_user_id, char_name, char_birth_day, char_gender ) " +
            " VALUES (?, ?, ?, ?) ";

    private static final String SELECT_USER_INFORMATION =
            "SELECT  user_login, user_email, user_full_Name, user_birth_Day, " +
            "   user_gender, user_city, user_icq_number " +
            "FROM mmc_users " +
            "WHERE user_id = ?";

    private static final String SELECT_SECURITY =
            "SELECT user_id " +
            " FROM mmc_users " +
            " WHERE user_login = ? AND user_pass = ?";

    @Override
    public Long saveUser(User user) throws SQLException{
        Long userId = -1L;

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_USER, new String[] {"user_id"}) )
        {
            con.setAutoCommit(false);
            int index = 1;

            try {
                stmt.setString(index, user.getNickName());
                stmt.setString(++index, user.getUserPass());
                stmt.setString(++index, user.getUserEmail());
                stmt.setString(++index, user.getSecurityAnswer());
                stmt.setString(++index, user.getFullName());
                stmt.setDate(++index, java.sql.Date.valueOf(user.getUserBirthDay()));
                stmt.setString(++index, user.getUserGender());
                stmt.setString(++index, user.getUserCity());
                stmt.setString(++index, user.getIcqNumber());

                stmt.executeUpdate();
                // get userId from DB
                ResultSet gkRs = stmt.getGeneratedKeys();
                if(gkRs.next()) {
                    userId = gkRs.getLong(1);
                }
                gkRs.close();

                saveCharacter(con, user, userId);

                con.commit();
            } catch (SQLException ex) {
                con.rollback();
                ex.printStackTrace();
                throw ex;
            }
        } catch (SQLException ex) {
            throw ex;
        }

        return userId;
    }

    private void saveCharacter(Connection con, User user, Long userId) throws SQLException
    {
        int index = 1;
        try (PreparedStatement stmt = con.prepareStatement(INSERT_CHARACTER))
        {
            stmt.setLong(index, userId);
            stmt.setString(++index, user.getNickName());
            stmt.setDate(++index, java.sql.Date.valueOf(user.getCharacterBirthDay()));
            stmt.setString(++index, user.getUserGender());

            stmt.executeUpdate();
        }
    }

    @Override
    public UserInformation getUserInformation(Long id) throws SQLException {
        UserInformation information = null;

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(SELECT_USER_INFORMATION))
        {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                information = getUserInformation(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return information;
    }

    @Override
    public Security loginUser(String nickName, String password) throws SQLException
    {
        Security sec = new Security();

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(SELECT_SECURITY))
        {
            stmt.setString(1, nickName);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                sec = getSecurity(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return sec;
    }

    private UserInformation getUserInformation(ResultSet rs) throws SQLException {
        UserInformation inform = new UserInformation();
        inform.setUserLogin(rs.getString("user_login"));
        inform.setUserEmail(rs.getString("user_email"));
        inform.setUserFullName(rs.getString("user_full_name"));
        inform.setUserBirthDay(rs.getDate("user_birth_Day").toLocalDate());
        inform.setUserGender(rs.getString("user_gender"));
        inform.setUserCity(rs.getString("user_city"));
        inform.setUserIcqNumber(rs.getString("user_icq_number"));

        return inform;
    }

    private Security getSecurity(ResultSet rs) throws SQLException {
        Security sec = new Security();

        sec.setUserID(rs.getLong("user_id"));
        sec.setLogged(true);

        return sec;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/mmclub",
                "postgres", "Postgres");
    }
}
