package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Carrello;
import model.CarrelloDAO;
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
            response.sendRedirect("resources/view/already-registered.jsp");
        }else{
            service.doAddUser(u);
            // Verifico se ci sono album in sessione ed eventualmente li associo al nuovo utente
            HttpSession ssn = request.getSession();
            synchronized (ssn){
                CarrelloDAO serviceC = new CarrelloDAO();
                ssn.setAttribute("id", username);
                ssn.setAttribute("password",password);
                ArrayList<String> albumList = new ArrayList<>();
                if (ssn.getAttribute("albumList") != null) //Se la sessione contiene gia' l'attributo allora lo preleva
                    albumList = (ArrayList<String>) ssn.getAttribute("albumList");
                for (String str: albumList) {
                    Carrello c = new Carrello(username, password, str);
                    serviceC.doLoadChart(c);
                }

            }
            //forward a pagina di registrazione avvenuta
            response.sendRedirect("resources/view/register-confirmation.jsp");
        }
    }
}
