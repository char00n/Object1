package ua.object1.mmclub.domain.register;

import ua.object1.mmclub.domain.enums.Gender;

import java.time.LocalDate;

public class UserInformation {
    String userLogin;
    String userEmail;
    String userFullName;
    LocalDate userBirthDay;
    Gender userGender;
    String userCity;
    String userIcqNumber;

    public UserInformation() {
    }


    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public LocalDate getUserBirthDay() {
        return userBirthDay;
    }

    public void setUserBirthDay(LocalDate userBirthDay) {
        this.userBirthDay = userBirthDay;
    }

    public Gender getUserGender() {
        return userGender;
    }

    public void setUserGender(Gender userGender) {
        this.userGender = userGender;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserIcqNumber() {
        return userIcqNumber;
    }

    public void setUserIcqNumber(String userIcqNumber) {
        this.userIcqNumber = userIcqNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserInformation{");
        sb.append("userLogin='").append(userLogin).append('\'');
        sb.append(", userEmail='").append(userEmail).append('\'');
        sb.append(", userFullName='").append(userFullName).append('\'');
        sb.append(", userBirthDay=").append(userBirthDay);
        sb.append(", userGender='").append(userGender).append('\'');
        sb.append(", userCity='").append(userCity).append('\'');
        sb.append(", userIcqNumber='").append(userIcqNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
