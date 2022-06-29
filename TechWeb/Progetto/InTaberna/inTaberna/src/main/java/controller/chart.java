package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Carrello;
import model.CarrelloDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "chart", value = "/chart")
public class chart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ssn = request.getSession();
        CarrelloDAO service = new CarrelloDAO();
        synchronized (ssn){
            if (ssn != null){
                ArrayList<String> albumList = new ArrayList<>();
                String id = null, password = null;
                if (ssn.getAttribute("albumList") != null) //Se la sessione contiene gia' l'attributo allora lo preleva
                    albumList = (ArrayList<String>) ssn.getAttribute("albumList");
                if (ssn.getAttribute("id") != null && ssn.getAttribute("password") != null){
                    id = (String) ssn.getAttribute("id");
                    password = (String) ssn.getAttribute("password");
                }
                for (String str: albumList) {
                    Carrello c = new Carrello(id, password, str);
                    service.doLoadChart(c);
                }
                response.sendRedirect("resources/view/shopping.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
