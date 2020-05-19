package ua.object1.mmclub.dao;

import org.apache.commons.lang3.StringUtils;
import ua.object1.mmclub.domain.enums.Gender;
import ua.object1.mmclub.domain.register.User;
import ua.object1.mmclub.domain.register.UserRegistration;
import ua.object1.mmclub.domain.register.UserInformation;

import java.sql.*;

public class RegistrationDaoImpl implements RegistrationDao {

    private static final String INSERT_USER =
            "INSERT INTO mmc_users(user_login, user_pass,  user_email, user_security_answer, " +
                    "user_full_Name, user_birth_Day, " +
                    "user_gender, user_city, user_icq_number ) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

    private static final String SELECT_USER_INFORMATION =
            "SELECT  user_login, user_email, user_full_Name, user_birth_Day, " +
            "   user_gender, user_city, user_icq_number " +
            "FROM mmc_users " +
            "WHERE user_id = ?";

    private static final String SELECT_USER =
            "SELECT user_id " +
            " FROM mmc_users " +
            " WHERE user_login = ? AND user_pass = ?";

    @Override
    public Long saveUser(UserRegistration userRegistration) throws SQLException{
        Long userId = -1L;

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_USER, new String[] {"user_id"}) )
        {
            con.setAutoCommit(false);
            int index = 1;

            try {
                stmt.setString(index, userRegistration.getNickName());
                stmt.setString(++index, userRegistration.getUserPass());
                stmt.setString(++index, userRegistration.getUserEmail());
                stmt.setString(++index, userRegistration.getSecurityAnswer());
                stmt.setString(++index, userRegistration.getFullName());
                stmt.setDate(++index, java.sql.Date.valueOf(userRegistration.getUserBirthDay()));
                stmt.setString(++index, userRegistration.getUserGender().getValue());
                stmt.setString(++index, userRegistration.getUserCity());
                stmt.setString(++index, userRegistration.getIcqNumber());

                stmt.executeUpdate();
                // get userId from DB
                ResultSet gkRs = stmt.getGeneratedKeys();
                if(gkRs.next()) {
                    userId = gkRs.getLong(1);
                }
                gkRs.close();

                con.commit();
            } catch (SQLException ex) {
                con.rollback();
                ex.printStackTrace();
                throw ex;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return userId;
    }

    private UserInformation getUserInformation(Long id) throws SQLException {
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
    public User loginUser(String nickName, String password) throws SQLException
    {
        User user = new User();
        if (StringUtils.isBlank(nickName) || StringUtils.isBlank(password))
        {
            return user;
        }

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(SELECT_USER))
        {
            stmt.setString(1, nickName);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user = getUser(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return user;
    }

    private UserInformation getUserInformation(ResultSet rs) throws SQLException {
        UserInformation inform = new UserInformation();
        inform.setUserLogin(rs.getString("user_login"));
        inform.setUserEmail(rs.getString("user_email"));
        inform.setUserFullName(rs.getString("user_full_name"));
        inform.setUserBirthDay(rs.getDate("user_birth_Day").toLocalDate());
        inform.setUserGender(Gender.fromValue(rs.getString("user_gender")));
        inform.setUserCity(rs.getString("user_city"));
        inform.setUserIcqNumber(rs.getString("user_icq_number"));

        return inform;
    }

    private User getUser(ResultSet rs) throws SQLException {
        User user = new User();

        user.setUserID(rs.getLong("user_id"));
        user.setLogged(true);

        UserInformation information = getUserInformation(user.getUserID());
        user.setUserInformation(information);

        return user;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/mmclub",
                "postgres", "Postgres");
    }
}
