package ua.object1.mmclub.dao;

import ua.object1.mmclub.domain.register.User;
import ua.object1.mmclub.domain.register.UserRegistration;

import java.sql.SQLException;

public interface RegistrationDao {
    Long saveUser(UserRegistration userRegistration) throws SQLException;

    User loginUser(String nickName, String password) throws SQLException;
}
