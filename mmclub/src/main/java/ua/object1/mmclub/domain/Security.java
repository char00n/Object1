package ua.object1.mmclub.domain;

public class Security {
    private Long userID;
    private boolean isLogged;

    public Security() {
        userID = null;
        isLogged = false;
    }

    public Security(Long userID, boolean isLogged) {
        this.userID = userID;
        this.isLogged = isLogged;
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

    @Override
    public String toString() {
        return "Security{" +
                "userID=" + userID +
                ", isLogged=" + isLogged +
                '}';
    }
}


