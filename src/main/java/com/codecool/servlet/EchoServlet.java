package com.codecool.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/echo")
public class EchoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String message = req.getParameter("message");

        resp.getWriter().write(message);
        resp.getWriter().flush();
        resp.getWriter().close();

//        req.setAttribute("message", message);
        resp.setStatus(200);

    }

}
