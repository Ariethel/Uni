package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletSession" , value = "/index.html2")
public class ServletSession extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        HttpSession ssn = req.getSession();

        Integer numAccessi = (Integer) ssn.getAttribute("numAccessi");

        if (numAccessi == null){
            numAccessi = 0;
        }else{
            numAccessi++;
        }

        ssn.setAttribute("numAccessi", numAccessi);

        PrintWriter out = res.getWriter();

        out.println("Accessi: " + ssn.getAttribute("numAccessi"));

    }
}
