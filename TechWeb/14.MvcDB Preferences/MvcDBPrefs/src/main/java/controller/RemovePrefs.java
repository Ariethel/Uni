package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Customer;
import model.CustomerDAO;

import java.io.IOException;

@WebServlet(name = "RemovePrefs", value = "/remove-prefs")
public class RemovePrefs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO service = new CustomerDAO();
        Customer customer = new Customer();
        customer = service.doRetrieveById(Integer.parseInt(request.getParameter("id")));
        service.doRemovePrefs(customer);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/show-all.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
