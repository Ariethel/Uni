package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.CarrelloDAO;

import java.io.IOException;

@WebServlet(name = "emptyChart", value = "/emptyChart")
public class emptyChart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarrelloDAO service = new CarrelloDAO();
        service.doEmpty((String) request.getSession().getAttribute("id"));
        HttpSession ssn = request.getSession();
        ssn.setAttribute("albumList", null);
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
