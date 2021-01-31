package com.aubrun.eric.projet7.springmvc.model;

import java.util.ArrayList;
import java.util.List;

public class ActiveUserStore {

    public List<String> users;

    public ActiveUserStore() {
        users = new ArrayList<String>();
    }

    public ActiveUserStore(List<String> users) {
        this.users = users;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "ActiveUserStore{" +
                "users=" + users +
                '}';
    }
}
