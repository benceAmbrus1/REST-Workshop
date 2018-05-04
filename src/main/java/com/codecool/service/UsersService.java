package com.codecool.service;

import com.codecool.Singleton.SingletonDB;
import com.codecool.model.User;

public class UsersService {

    public void creatNewUser(String name, String email){
        User tempU = new User(name, email);
        SingletonDB.getInstance().getUsers().add(tempU);
    }
}
