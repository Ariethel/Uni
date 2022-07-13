package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.AlbumDAO;
import model.UserDAO;

import java.io.IOException;

@WebServlet(name = "confirm-updateAlbum", value = "/confirm-updateAlbum")
public class confirmupdateAlbum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlbumDAO service = new AlbumDAO();
        String title = request.getParameter("title");
        Double prezzo = Double.valueOf(request.getParameter("prezzo"));
        String id = request.getParameter("id");
        String homepage = request.getParameter("homepage");
        if (homepage == null)
            service.doUpdateAlbum(id,title,prezzo);
        else
            service.doUpdateAlbumComplete(id,title,prezzo);

        response.sendRedirect("resources/view/admin-function.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
