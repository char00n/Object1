package ua.object1.mmclub.domain.register;

public class User {
    private Long userID;
    private boolean isLogged;
    private UserInformation userInformation;

    public User() {
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("userID=").append(userID);
        sb.append(", isLogged=").append(isLogged);
        sb.append(", userInformation=").append(userInformation);
        sb.append('}');
        return sb.toString();
    }
}


