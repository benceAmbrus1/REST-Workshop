package com.codecool.model;

public class User {

    private static int staticId = 1;
    private int id;
    private String pass;
    private String email;

    public User(String pass, String email) {
        this.id = incStatID();
        this.pass = pass;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public int incStatID(){
        return staticId++;
    }
}
