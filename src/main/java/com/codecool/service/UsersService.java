package com.codecool.service;

import com.codecool.Singleton.SingletonDB;
import com.codecool.exception.EmailAlreadyExistException;
import com.codecool.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersService {

    public void creatNewUser(int id, String name, String email) throws EmailAlreadyExistException {
        if(SingletonDB.getInstance().allUserEmail().contains(email)){
            throw new EmailAlreadyExistException("Email already exist");
        }else {
            User tempU = new User(id, name, email);
            SingletonDB.getInstance().getUsers().add(tempU);
        }
    }

    public void deleteAllUser(){
        SingletonDB.getInstance().removeUsers();
    }

    public boolean isThereUser(){
        if(SingletonDB.getInstance().getUsers().size() > 0){
            return true;
        } else {
            return false;
        }
    }

    public List<String> getUsers(){
        List<String> result = new ArrayList<>();
        List<User> users = SingletonDB.getInstance().getUsers();
        for(User u:users){
            result.add(u.getId() + ";" + u.getName() +  ";" + u.getEmail());
        }
        return result;
    }
}
