package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Prodotto;
import model.ServiceDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CategoriaServlet", value = "/categoria-servlet")
public class CategoriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceDAO service = new ServiceDAO();
        ArrayList<Prodotto> prodotti = service.doRetriveByCat(Integer.parseInt(request.getParameter("categoria")));
        request.setAttribute("prodotti",prodotti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/result.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
