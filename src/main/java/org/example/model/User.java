package org.example.model;

public class User {
    private int id;
    private String userName;
    private String password;
    private String nationalCode;

    public User(String userName, String password, String nationalCode) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nationalCode = nationalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
}
