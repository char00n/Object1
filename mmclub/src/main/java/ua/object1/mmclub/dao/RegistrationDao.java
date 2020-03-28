package ua.object1.mmclub.dao;

import ua.object1.mmclub.domain.User;

public interface RegistrationDao {
    Long saveUser(User user);

    User getUser();
}
