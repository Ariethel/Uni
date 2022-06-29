package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.UserDAO;
import model.Utente;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "login-servlet", value = "/login-servlet")
public class loginservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO service = new UserDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (service.doCheckAdmin(username) && service.doCheckPassword(username,password)){
            if (request.getSession() != null) request.getSession().invalidate();
            HttpSession ssn = request.getSession();
            synchronized (ssn){
                ssn.setAttribute("id", username);
                ssn.setAttribute("password",password);
            }
            //Forward a pagina home admin
            response.sendRedirect("resources/view/admin-home.jsp");
        }

        if(service.doCheckPassword(username,password) && !service.doCheckAdmin(username)){
            //Forward a pagina personale utente registrato
            if (request.getSession() != null) request.getSession().invalidate();
            HttpSession ssn = request.getSession();
            synchronized (ssn){
                    ssn.setAttribute("id", username);
                    ssn.setAttribute("password",password);
            }
            response.sendRedirect("index.jsp");
        }

    }
}
