package com.aubrun.eric.projet7.springmvc.model;

import java.util.List;
import java.util.Set;

public class UserAccount {

    private Long userId;
    private String username;
    private String email;
    private String password;
    private List<Borrowing> borrowingList;
    private Set<Role> roles;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<Borrowing> getBorrowingDtoList() {
        return borrowingList;
    }

    public void setBorrowingDtoList(List<Borrowing> borrowingList) {
        this.borrowingList = borrowingList;
    }

    public Set<Role> getRoleDtos() {
        return roles;
    }

    public void setRoleDtos(Set<Role> roles) {
        this.roles = roles;
    }
}
