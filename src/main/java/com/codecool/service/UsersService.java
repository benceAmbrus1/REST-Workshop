package com.codecool.service;

import com.codecool.Singleton.SingletonDB;
import com.codecool.exception.EmailAlreadyExistException;
import com.codecool.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersService {

    public void creatNewUser(String[] eAndp) throws EmailAlreadyExistException {
        if(SingletonDB.getInstance().allUserEmail().contains(eAndp[0])){
            throw new EmailAlreadyExistException("Email already exist");
        }else {
            User tempU = new User(eAndp[1], eAndp[0]);
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
            result.add(u.getId() + ";" + u.getEmail() +  ";" + u.getPass());
        }
        return result;
    }
}
