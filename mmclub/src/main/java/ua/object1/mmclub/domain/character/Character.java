package ua.object1.mmclub.domain.character;

import ua.object1.mmclub.domain.register.User;

import java.time.LocalDate;

public class Character
{
    private User user;
    private String name;
    private LocalDate birthDay;
    private String gender;
    private Stat charStat;
}
