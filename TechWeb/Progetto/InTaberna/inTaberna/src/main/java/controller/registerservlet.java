package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.UserDAO;
import model.Utente;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "registerservlet", value = "/register-servlet")
public class registerservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO service = new UserDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Utente u = new Utente(username,password,"registrato");
        if (service.doCheckEmail(username)){
            //Forward a pagina di utente gia' registrato
            RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/already-registered.jsp");
            dispatcher.forward(request,response);
        }else{
            service.doAddUser(u);
            //forward a pagina di registrazione avvenuta
            RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/register-confirmation.jsp");
            dispatcher.forward(request,response);
        }
    }
}
