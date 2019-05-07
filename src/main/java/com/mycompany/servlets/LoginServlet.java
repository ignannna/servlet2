/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlets;
import com.mycompany.repositories.UsersRepository;
import com.mycompany.repositories.UsersRepositoryInMemoryImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login") 

public class LoginServlet extends HttpServlet{
    private UsersRepository usersRepository;
    
    @Override
    public void init() throws ServletException{
        this.usersRepository = new UsersRepositoryInMemoryImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,  IOException {
    req.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
    }

     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,  IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (usersRepository.isExist(name, password)){
            HttpSession session = req.getSession();
            session.setAttribute("user", name);
            req.getServletContext().getRequestDispatcher("/home").forward(req, resp);
            
        }else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
       
    } 
    
}
