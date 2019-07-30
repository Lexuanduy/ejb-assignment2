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
import session.TokenSessionBeanLocal;

/**
 *
 * @author Lonely
 */
public class CUDServlet extends HttpServlet {

    //Alt + Insert > Call Enterpride Bean..
    @EJB
    private TokenSessionBeanLocal tokenSessionBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Action name
        String button = request.getParameter("action");

        //Input name
        int userId = Integer.parseInt(request.getParameter("userId"));
        String tokenString = request.getParameter("tokenString");

        //Case button submit
        if ("Insert".equalsIgnoreCase(button)) {
            if (tokenSessionBean.insert(tokenString, userId)) {
                request.setAttribute("items", tokenSessionBean.getAll());
                request.getRequestDispatcher("tokenview.jsp").forward(request, response);
            } else {
                request.setAttribute("ERROR", "Insert error!");
                request.getRequestDispatcher("tokenview.jsp").forward(request, response);
            }
        } else if ("Update".equalsIgnoreCase(button)) {
            if (tokenSessionBean.update(tokenString, userId)) {
                request.setAttribute("items", tokenSessionBean.getAll());
                request.getRequestDispatcher("tokenview.jsp").forward(request, response);
            } else {
                request.setAttribute("ERROR", "Update error!");
                request.getRequestDispatcher("tokenview.jsp").forward(request, response);
            }
        } else if ("Delete".equalsIgnoreCase(button)) {
            if (tokenSessionBean.delete(userId)) {
                request.setAttribute("items", tokenSessionBean.getAll());
                request.getRequestDispatcher("tokenview.jsp").forward(request, response);
            } else {
                request.setAttribute("ERROR", "Delete error!");
                request.getRequestDispatcher("tokenview.jsp").forward(request, response);
            }
        } else {
           
            request.setAttribute("items", tokenSessionBean.getAll());
            request.getRequestDispatcher("tokenview.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String searchToken = request.getParameter("searchToken");
        //Search tokenString
        if (tokenSessionBean.searchToken(searchToken) != null) {
            request.setAttribute("items", tokenSessionBean.searchToken(searchToken) );
            request.getRequestDispatcher("tokenview.jsp").forward(request, response);
        } else {
            request.setAttribute("ERROR", "Search error!");
            request.getRequestDispatcher("tokenview.jsp").forward(request, response);
        }
    }

}