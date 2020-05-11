package ua.object1.mmclub.dao;

import ua.object1.mmclub.domain.Security;
import ua.object1.mmclub.domain.User;
import ua.object1.mmclub.domain.UserInformation;

import java.sql.SQLException;

public interface RegistrationDao {
    Long saveUser(User user) throws SQLException;

    UserInformation getUserInformation(Long id) throws SQLException;

    Security loginUser(String nickName, String password) throws SQLException;
}
