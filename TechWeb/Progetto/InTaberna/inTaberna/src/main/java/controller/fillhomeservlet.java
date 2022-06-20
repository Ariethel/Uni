package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Album;
import model.AlbumDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "fillhomeservlet", value = "/fillhomeservlet")
public class fillhomeservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlbumDAO service = new AlbumDAO();
        ArrayList<Album> homepage = service.doGetHomePage();
        request.setAttribute("homepage",homepage);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
