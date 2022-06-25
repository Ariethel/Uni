package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.UserDAO;

import java.io.IOException;

@WebServlet(name = "confirm-update", value = "/confirm-update")
public class confirmupdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO service = new UserDAO();
        String id = request.getParameter("id");
        String email = request.getParameter("username");
        String pass = request.getParameter("password");
        String tipo = request.getParameter("tipo");
        service.doUpdateUser(id,email,pass,tipo);

        response.sendRedirect("resources/view/admin-function.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
