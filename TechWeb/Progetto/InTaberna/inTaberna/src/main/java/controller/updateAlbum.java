package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Album;
import model.AlbumDAO;
import model.UserDAO;
import model.Utente;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "updateAlbum", value = "/updateAlbum")
public class updateAlbum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlbumDAO service = new AlbumDAO();
        ArrayList<Album> res = service.doRetriveByTitle(request.getParameter("id"));
        request.setAttribute("album",res.get(0));

        RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/modifyAlbum.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
