package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletSession" , value = "/index.html")
public class ServletSession extends HttpServlet {
    private int numAccessi = 0;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        HttpSession ssn = req.getSession();
        ssn.setAttribute("NumAccessi", Integer.toString(numAccessi));

        PrintWriter out = res.getWriter();

        if (ssn != null){
            numAccessi++;
            ssn.setAttribute("NumAccessi", Integer.toString(numAccessi));
            out.println("Accessi: " + ssn.getAttribute("NumAccessi"));
        }

    }
}
