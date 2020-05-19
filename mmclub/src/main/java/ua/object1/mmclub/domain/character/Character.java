package ua.object1.mmclub.domain.character;

import ua.object1.mmclub.domain.enums.Gender;
import ua.object1.mmclub.domain.register.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Character
{
    private User user;
    private String name;
    private LocalDate birthDay;
    private Gender gender;
    private String image;
    private int town;
    private int building;
    private int movingType;
    private LocalDateTime endMovingTime;
    private int disposition;
    private int clan;
    private Stat charStat;
    private Skill charSkill;
    private Experience charExp;
    private Stuff charStuff;
    private Slot charSlot;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Stat getCharStat() {
        return charStat;
    }

    public void setCharStat(Stat charStat) {
        this.charStat = charStat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Skill getCharSkill() {
        return charSkill;
    }

    public int getTown() {
        return town;
    }

    public void setTown(int town) {
        this.town = town;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getMovingType() {
        return movingType;
    }

    public void setMovingType(int movingType) {
        this.movingType = movingType;
    }

    public LocalDateTime getEndMovingTime() {
        return endMovingTime;
    }

    public void setEndMovingTime(LocalDateTime endMovingTime) {
        this.endMovingTime = endMovingTime;
    }

    public int getDisposition() {
        return disposition;
    }

    public void setDisposition(int disposition) {
        this.disposition = disposition;
    }

    public int getClan() {
        return clan;
    }

    public void setClan(int clan) {
        this.clan = clan;
    }

    public void setCharSkill(Skill charSkill) {
        this.charSkill = charSkill;
    }

    public Experience getCharExp() {
        return charExp;
    }

    public void setCharExp(Experience charExp) {
        this.charExp = charExp;
    }

    public Stuff getCharStuff() {
        return charStuff;
    }

    public void setCharStuff(Stuff charStuff) {
        this.charStuff = charStuff;
    }

    public Slot getCharSlot() {
        return charSlot;
    }

    public void setCharSlot(Slot charSlot) {
        this.charSlot = charSlot;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Character{");
        sb.append("user=").append(user);
        sb.append(", name='").append(name).append('\'');
        sb.append(", birthDay=").append(birthDay);
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", image='").append(image).append('\'');
        sb.append(", town=").append(town);
        sb.append(", building=").append(building);
        sb.append(", movingType=").append(movingType);
        sb.append(", endMovingTime=").append(endMovingTime);
        sb.append(", disposition=").append(disposition);
        sb.append(", clan=").append(clan);
        sb.append(", charStat=").append(charStat);
        sb.append(", charSkill=").append(charSkill);
        sb.append(", charExp=").append(charExp);
        sb.append(", charStuff=").append(charStuff);
        sb.append(", charSlot=").append(charSlot);
        sb.append('}');
        return sb.toString();
    }
}
