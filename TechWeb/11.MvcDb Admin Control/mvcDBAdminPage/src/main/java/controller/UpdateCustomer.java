package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import model.CustomerDAO;

import java.io.IOException;
@WebServlet("/update-customer")
public class UpdateCustomer extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        CustomerDAO service = new CustomerDAO();
        Customer customer = new Customer();

        int id = Integer.parseInt(req.getParameter("id"));
        customer = service.doRetrieveById(id);

        req.setAttribute("customer", customer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/results/form-modify.jsp");
        dispatcher.forward(req,res);
    }
}
