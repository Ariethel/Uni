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
        UserDAO userdao = new UserDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ArrayList<Utente> utenti = userdao.doRetriveByEmail(request.getParameter("username"));
        if (utenti.contains(request.getParameter("username"))){
            //non so bene cosa chiamare
        }else{
        }

    }
}
