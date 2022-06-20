package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Album;
import model.AlbumDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "addalbumservlet", value = "/addalbumservlet")
public class addalbumservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titolo = request.getParameter("titolo");
        Double prezzo = Double.valueOf(request.getParameter("prezzo"));
        File img = new File(request.getParameter("img"));
        Boolean homepage = Boolean.valueOf(request.getParameter("homepage"));
        Album album = new Album(titolo,prezzo,img,homepage);
        AlbumDAO service = new AlbumDAO();
        service.doInsertAlbum(album);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin-home.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
