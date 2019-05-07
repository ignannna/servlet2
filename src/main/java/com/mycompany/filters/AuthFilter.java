/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filters;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author user
 */
@WebFilter("/home")
public class AuthFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
     HttpServletRequest request = (HttpServletRequest)servletRequest;    
     HttpServletResponse response = (HttpServletResponse)servletResponse; 
     
     HttpSession session = request.getSession(false);
     if(session == null || session.getAttribute("user") == null){
         servletRequest.getServletContext().getRequestDispatcher ("/login").forward(request, response);
         
     }
       chain.doFilter(request, response);     
    }
    @Override
    public void destroy(){
            
}
}