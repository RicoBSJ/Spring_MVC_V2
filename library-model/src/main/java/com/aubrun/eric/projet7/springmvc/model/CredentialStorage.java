package com.aubrun.eric.projet7.springmvc.model;

public class CredentialStorage {

    private String username;
    private String password;

    public CredentialStorage() {
    }

    public CredentialStorage(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CredentialStorage{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
