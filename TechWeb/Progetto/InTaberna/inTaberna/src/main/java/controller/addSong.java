package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.CanzoneDAO;

import java.io.IOException;

@WebServlet(name = "addSong", value = "/addSong")
public class addSong extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_titolo = request.getParameter("c_title");
        String a_titolo = request.getParameter("a_title");
        CanzoneDAO service = new CanzoneDAO();
        service.doAddSong(c_titolo,a_titolo);
        response.sendRedirect("resources/view/admin-function.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
