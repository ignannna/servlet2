/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/home") 

public class HomeServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,  IOException {
    req.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
    }
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,  IOException {
        String color = req.getParameter("color");
        Cookie colorCookie = new Cookie ("color", color);
        resp.addCookie(colorCookie);
        resp.sendRedirect(req.getContextPath() + "/home");
    } 
        
}
