package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Categoria;
import model.ServiceDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "InitServlet", value = "/InitServlet", loadOnStartup = 0)
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServiceDAO service = new ServiceDAO();
        ArrayList<Categoria> categorie = service.doRetriveAllCat();
        getServletContext().setAttribute("categorie",categorie);
        super.init();
    }
}
