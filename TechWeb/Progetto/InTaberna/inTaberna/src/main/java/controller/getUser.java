package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.UserDAO;
import model.Utente;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "getUser", value = "/getUser")
public class getUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO service = new UserDAO();
        ArrayList<Utente> utenti = service.doRetriveAllUsers();
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        for (Utente u:utenti) {
            System.out.println("Preso: " + u.getEmail());
            obj.put("name", u.getEmail());
            array.put(obj);
        }

        response.setContentType("application/json");
        response.getWriter().write(array.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
