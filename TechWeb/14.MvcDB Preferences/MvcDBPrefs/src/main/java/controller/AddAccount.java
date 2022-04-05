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

@WebServlet("/add-account")
public class AddAccount extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        double balance = Double.parseDouble(req.getParameter("balance"));
        Customer customer = new Customer();
        customer.setFirstName(fname);
        customer.setLastName(lname);
        customer.setBalance(balance);
        CustomerDAO service = new CustomerDAO();
        service.doSave(customer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
        dispatcher.forward(req,res);
    }
}
