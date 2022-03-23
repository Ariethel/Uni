package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import model.CustomerDAO;

@WebServlet("/add-account")
public class AddAccount extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        int id = Integer.parseInt(req.getParameter("id"));
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        double balance = Double.parseDouble(req.getParameter("balance"));
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName(fname);
        customer.setLastName(lname);
        customer.setBalance(balance);
        CustomerDAO service = new CustomerDAO();
        service.doSave(customer);
    }
}
