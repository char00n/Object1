package ua.object1.mmclub.dao;

import ua.object1.mmclub.domain.character.Character;
import ua.object1.mmclub.domain.register.User;
import ua.object1.mmclub.domain.register.UserRegistration;

import java.sql.SQLException;

public interface CharacterDao
{
    Character readCharacter(User user) throws SQLException;

    boolean saveCharacter(UserRegistration userRegistration, Long userId) throws SQLException;
}
