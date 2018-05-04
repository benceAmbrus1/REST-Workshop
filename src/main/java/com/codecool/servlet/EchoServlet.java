package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.sql.rowset.serial.SerialException;

@WebServlet("/echo")
public class EchoServlet extends HttpServlet {

    protected void doGet(HttpServlet req, HttpServlet resp) throws SerialException {

    }

}
