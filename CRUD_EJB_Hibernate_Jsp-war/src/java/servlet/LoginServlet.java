/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.UserSessionBeanLocal;

/**
 *
 * @author Lonely
 */
public class LoginServlet extends HttpServlet {
    //Alt + Call Enterpride Bean
    @EJB
    private UserSessionBeanLocal userSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Logout
        request.getSession().invalidate();
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Login
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //Boolean login Session Bean
        if (userSessionBean.login(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("welcome", username);
           
            request.getRequestDispatcher("tokenview.jsp").forward(request, response);
        }else{
            request.setAttribute("ERROR", "Login invalid!");
            request.getRequestDispatcher("tokenview.jsp").forward(request, response);
        }
    }
}