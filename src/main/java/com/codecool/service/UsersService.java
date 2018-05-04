package com.codecool.service;

import com.codecool.Singleton.SingletonDB;
import com.codecool.exception.EmailAlreadyExistException;
import com.codecool.model.User;

public class UsersService {

    public void creatNewUser(String name, String email) throws EmailAlreadyExistException {
        if(SingletonDB.getInstance().allUserEmail().contains(email)){
            throw new EmailAlreadyExistException("Email already exist");
        }else {
            User tempU = new User(name, email);
            SingletonDB.getInstance().getUsers().add(tempU);
        }
    }
}
