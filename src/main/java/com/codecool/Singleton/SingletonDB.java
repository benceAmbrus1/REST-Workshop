package com.codecool.Singleton;

import com.codecool.model.User;

import java.util.ArrayList;
import java.util.List;

public class SingletonDB {

    private List<User> users = new ArrayList<>();

    private static SingletonDB ourInstance = new SingletonDB();

    public static SingletonDB getInstance() {
        return ourInstance;
    }

    private SingletonDB() {
    }

    public List<User> getUsers() {
        return users;
    }

    public List<String> allUserEmail(){
        List<String> emails = new ArrayList<>();
        for (User u:users){
            emails.add(u.getEmail());
        }return emails;
    }

    public void removeUsers(){
        users = new ArrayList<>();
    }
}
