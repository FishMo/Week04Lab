/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import business.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author 709317
 */
public class LoginServlet extends HttpServlet {

    UserService us = new UserService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String logoutMessage = request.getParameter("message");
        request.setAttribute("message",logoutMessage);
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        //response.sendRedirect("/WEB-INF/home.jsp");
        String userName = request.getParameter("uname");
        String password = request.getParameter("password");
     
        
        User user = new User(userName,password);
        if(userName!=null&&password!=null||!userName.isEmpty()&&!password.isEmpty()){
            
        if(us.login(userName, password))
        {
            request.setAttribute("user",user);
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
   
        }
        else{
            request.setAttribute("message", "Please enter a valid username and password!");  
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);           
        }
            
        }
            
        else{
            request.setAttribute("message", "Please enter a valid username and password!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }  
      //  UserService us = new UserService();
      //  user=us.login(userName, password);
        
        
    /*    if(user == null)
        {
            request.setAttribute("message", "Invalid username or password");
            request.setAttribute("user",user);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }
     */   

    }


}
