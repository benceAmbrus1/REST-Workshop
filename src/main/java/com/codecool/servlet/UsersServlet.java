package com.codecool.servlet;

import com.codecool.exception.EmailAlreadyExistException;
import com.codecool.model.User;
import com.codecool.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/users")
public class UsersServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersService service = new UsersService();
        String[] emailAndPass = req.getReader().readLine().split(";");

        try {
            User u = service.creatNewUser(emailAndPass);
            resp.setStatus(201);
            resp.addHeader("Location","/users/" + u.getId());

        } catch (EmailAlreadyExistException e) {
            resp.setStatus(409);

        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersService service = new UsersService();
        if(service.isThereUser()){
            service.deleteAllUser();
            resp.setStatus(200);
        }else{
            resp.setStatus(204);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersService service = new UsersService();

        if(service.isThereUser()) {
            List<String> users = service.getUsers();
            PrintWriter out = resp.getWriter();
            resp.setStatus(200);
            for (String s : users) {
                out.write(s);
            }
        }else{
            resp.setStatus(204);
        }
    }
}
