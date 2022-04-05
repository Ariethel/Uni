package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Customer;
import model.CustomerDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ShowAll", value = "/show-all")
public class ShowAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        CustomerDAO service = new CustomerDAO();
        try {
            customers = service.doRetriveAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("customers",customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/show-all.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
