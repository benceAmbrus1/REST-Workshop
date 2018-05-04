package com.codecool.service;

import com.codecool.Singleton.SingletonDB;
import com.codecool.exception.UserNotIdentifiedException;
import com.codecool.model.Post;

public class PostsService {

    public void creatNewPost(String userID, String content) throws UserNotIdentifiedException {
        Post tempPost = new Post(userID, content);
        SingletonDB.getInstance().getPosts().add(tempPost);
    }
}
