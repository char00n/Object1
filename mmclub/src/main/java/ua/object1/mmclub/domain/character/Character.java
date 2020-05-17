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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Stat getCharStat() {
        return charStat;
    }

    public void setCharStat(Stat charStat) {
        this.charStat = charStat;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Character{");
        sb.append("user=").append(user);
        sb.append(", name='").append(name).append('\'');
        sb.append(", birthDay=").append(birthDay);
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", charStat=").append(charStat);
        sb.append('}');
        return sb.toString();
    }
}
