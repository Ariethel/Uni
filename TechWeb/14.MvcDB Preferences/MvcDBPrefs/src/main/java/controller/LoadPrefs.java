package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Customer;
import model.CustomerDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "LoadPrefs", value = "/load-prefs")
public class LoadPrefs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CustomerDAO service = new CustomerDAO();
        ArrayList<Customer> customerbookmark = service.doRetriveBookmark();
        session.setAttribute("customersbookmark", customerbookmark);
        ArrayList<Customer> customers = null;
        try {
            customers = service.doRetriveAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("customers",customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/show-all.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
