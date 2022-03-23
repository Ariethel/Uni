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


/**
 * Servlet that reads a customer ID and displays
 * information on the account balance of the customer
 * who has that ID.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT,
 * Spring, Hibernate/JPA, and Java programming</a>.
 */

@WebServlet("/show-balance")
public class ShowBalance extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // reading parameters from the request
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        // instantiating a Model class to query the data
        CustomerDAO service = new CustomerDAO();
        // creating the javabean "customer" to receive the Model response
        // and invocating the Model service by passing the request parameter "customerId"
        Customer customer = service.doRetrieveById(customerId);

        //storing the resulting javabean in the "request" object
        request.setAttribute("customer", customer);
        String address;

        // depending on the Model response the  "address" of the proper View component (jsp) is set
        if (customer == null) {
            request.setAttribute("badId", customerId);
            address = "/WEB-INF/results/unknown-customer.jsp";
        } else if (customer.getBalance() < 0) {
            address = "/WEB-INF/results/negative-balance.jsp";
        } else if (customer.getBalance() < 10000) {
            address = "/WEB-INF/results/normal-balance.jsp";
        } else {
            address = "/WEB-INF/results/high-balance.jsp";
        }

        // The servlet dispatches the control to the chosen jsp (through its address)
        // and passes it both the reference to the javabean (stored in the "request") and
        // the response where the jsp will store the final page.
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
