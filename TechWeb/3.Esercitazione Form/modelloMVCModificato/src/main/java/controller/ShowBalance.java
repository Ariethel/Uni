package controller;

import model.Customer;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;


@WebServlet("/show-balance")
public class ShowBalance extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // reading parameters from the request
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String dnascita = request.getParameter("dnascita");
        String genderA = request.getParameter("genderA");
        String genderB = request.getParameter("genderB");
        String citta = request.getParameter("citta");
        String provincia = request.getParameter("provincia");
        String cap = request.getParameter("cap");
        String strada = request.getParameter("strada");
        String idcard = request.getParameter("idcard");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String website = request.getParameter("website");
        // creating the javabean "customer" to receive the Model response
        // and invocating the Model service by passing the request parameter "customerId"
        Customer customer = new Customer();
        //storing the resulting javabean in the "request" object
        request.setAttribute("fname", fname);
        request.setAttribute("lname", lname);
        request.setAttribute("dnascita", dnascita);
        request.setAttribute("genderA", genderA);
        request.setAttribute("genderB", genderB);
        request.setAttribute("citta", citta);
        request.setAttribute("provincia", provincia);
        request.setAttribute("cap", cap);
        request.setAttribute("strada", strada);
        request.setAttribute("idcard", idcard);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("website", website);

        String address = "/WEB-INF/results/result.jsp";

        // The servlet dispatches the control to the chosen jsp (through its address)
        // and passes it both the reference to the javabean (stored in the "request") and
        // the response where the jsp will store the final page.
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
