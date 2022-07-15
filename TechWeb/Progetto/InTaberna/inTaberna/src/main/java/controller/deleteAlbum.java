package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.AlbumDAO;

import java.io.IOException;

@WebServlet(name = "deleteAlbum", value = "/deleteAlbum")
public class deleteAlbum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        AlbumDAO service = new AlbumDAO();
        service.doDeleteById(id);
        response.sendRedirect("resources/view/admin-function.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
