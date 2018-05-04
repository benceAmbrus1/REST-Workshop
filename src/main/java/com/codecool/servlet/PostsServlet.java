package com.codecool.servlet;

import com.codecool.Singleton.SingletonDB;
import com.codecool.exception.EmailAlreadyExistException;
import com.codecool.exception.UserNotIdentifiedException;
import com.codecool.service.PostsService;
import com.codecool.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/posts")
public class PostsServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PostsService service = new PostsService();
        String userID = req.getParameter("userID");
        String content = req.getParameter("content");

        try {
            service.creatNewPost(userID, content);
            resp.setStatus(201);

        } catch (UserNotIdentifiedException e) {
            resp.setStatus(400);

        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SingletonDB.getInstance().removeUsers();
        resp.setStatus(204);
    }
}
