package ua.object1.mmclub.domain;

import java.time.LocalDate;

public class User {
    private String nickName;
    private String userPass;
    private Long sessionId;
    private String userEmail;
    private String securityAnswer;
    private LocalDate userBirthDay;
    private LocalDate characterBirthDay;
    private String userGender;
    private String userCity;
    private String icqNumber;

    public User() {
    }

    public User(String nickName, String userPass, Long sessionId, String userEmail, String securityAnswer, LocalDate userBirthDay, LocalDate characterBirthDay, String userGender, String userCity, String icqNumber) {
        this.nickName = nickName;
        this.userPass = userPass;
        this.sessionId = sessionId;
        this.userEmail = userEmail;
        this.securityAnswer = securityAnswer;
        this.userBirthDay = userBirthDay;
        this.characterBirthDay = characterBirthDay;
        this.userGender = userGender;
        this.userCity = userCity;
        this.icqNumber = icqNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public LocalDate getUserBirthDay() {
        return userBirthDay;
    }

    public void setUserBirthDay(LocalDate userBirthDay) {
        this.userBirthDay = userBirthDay;
    }

    public LocalDate getCharacterBirthDay() {
        return characterBirthDay;
    }

    public void setCharacterBirthDay(LocalDate characterBirthDay) {
        this.characterBirthDay = characterBirthDay;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getIcqNumber() {
        return icqNumber;
    }

    public void setIcqNumber(String icqNumber) {
        this.icqNumber = icqNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", sessionId=" + sessionId +
                ", userEmail='" + userEmail + '\'' +
                ", securityAnswer='" + securityAnswer + '\'' +
                ", userBirthDay=" + userBirthDay +
                ", characterBirthDay=" + characterBirthDay +
                ", userGender='" + userGender + '\'' +
                ", userCity='" + userCity + '\'' +
                ", icqNumber='" + icqNumber + '\'' +
                '}';
    }
}

