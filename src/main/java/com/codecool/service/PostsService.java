package com.codecool.service;

import com.codecool.Singleton.SingletonDB;
import com.codecool.exception.UserNotIdentifiedException;
import com.codecool.model.Post;
import java.util.ArrayList;
import java.util.List;

public class PostsService {

    public void createNewPost(String userID, String content) throws UserNotIdentifiedException {
        Post tempPost = new Post(userID, content);
        SingletonDB.getInstance().getPosts().add(tempPost);
    }

    public void deleteAllPost(){
        SingletonDB.getInstance().removePosts();
    }

    public boolean isTherePost(){
        if(SingletonDB.getInstance().getPosts().size() > 0){
            return true;
        } else {
            return false;
        }
    }

    public List<String> getPosts(){
        List<String> result = new ArrayList<>();
        List<Post> posts = SingletonDB.getInstance().getPosts();
        for(Post p : posts){
            result.add(p.getUserID() + ";" + p.getContent());
        }
        return result;
    }
}
