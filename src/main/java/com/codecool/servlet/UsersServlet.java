package com.codecool.servlet;

import com.codecool.exception.EmailAlreadyExistException;
import com.codecool.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UsersServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersService service = new UsersService();
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        try {
            service.creatNewUser(name, email);
            resp.setStatus(201);

        } catch (EmailAlreadyExistException e) {
            resp.setStatus(409);

        }
    }
}
