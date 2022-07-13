package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "addSession", value = "/addSession")
public class addSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ssn = request.getSession();
        synchronized (ssn){
            if (ssn != null){
                String ssnId = ssn.getId();
                ArrayList<String> albumList = new ArrayList<>();
                if (ssn.getAttribute("albumList") != null) //Se la sessione contiene gia' l'attributo allora lo preleva
                    albumList = (ArrayList<String>) ssn.getAttribute("albumList");
                String albumName = request.getParameter("albumName");
                albumList.add(albumName);
                ssn.setAttribute("albumList", albumList);
                System.out.println("Session id: " + ssnId);
                for (String str:albumList) {
                    System.out.println(" Aggiunto Album: " + str);
                }
                response.sendRedirect("index.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
