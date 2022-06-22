package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Album;
import model.AlbumDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "fillhomeservlet", value = "/fillhomeservlet", loadOnStartup = 0)

public class fillhomeservlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        AlbumDAO service = new AlbumDAO();
        ArrayList<Album> homepage = null;
        try {
            homepage = service.doGetHomePage();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Album a: homepage) {
            System.out.println(a.getTitolo());
            System.out.println(a.getPrezzo());
        }

        getServletContext().setAttribute("homepage",homepage);
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlbumDAO service = new AlbumDAO();
        ArrayList<Album> homepage = service.doGetHomePage();
        for (Album a: homepage) {
            System.out.println(a.getTitolo());
            System.out.println(a.getPrezzo());
        }

        request.setAttribute("homepage",homepage);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
