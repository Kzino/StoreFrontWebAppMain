package com.astonengineers.version1.security.dto;

public class UserDTO {
    private int UserID;
    private String UserName;
    private String email;
    private String password;


    public UserDTO() {

    }

    public UserDTO(int UserID, String UserName, String email, String password) {
        this.UserID = UserID;
        this.UserName = UserName;
        this.email = email;
        this.password = password;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
            "UserID=" + UserID +
            ", UserName='" + UserName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
