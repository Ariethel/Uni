package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Customer;
import model.CustomerDAO;

import java.io.IOException;

@WebServlet(name = "ConfirmUpdate", value = "/confirm-update")
public class ConfirmUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO service = new CustomerDAO();
        Customer customer = new Customer();

        String fname = (String) request.getParameter("fname");
        String lname = (String) request.getParameter("lname");
        String balance = (String) request.getParameter("balance");
        customer.setFirstName(fname);
        customer.setLastName(lname);
        customer.setBalance(Double.parseDouble(balance));

        service.doModify(customer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
