package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCookie", value = "/index.html2")
public class servletcookie extends HttpServlet {
    private int numero = 0;


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        //Invio
        Cookie cookieTest = new Cookie("NumAccessi", Integer.toString(numero));
        cookieTest.setSecure(true);
        cookieTest.setMaxAge(60 * 60 * 24);
        cookieTest.setPath("/");
        res.addCookie(cookieTest);

        //Lettura
        Cookie[] cookies = req.getCookies();
        Cookie c = cookies[0];
        if (c != null) {
            numero++;
            c.setValue(Integer.toString(Integer.parseInt(c.getValue()) + 1));
            out.println("cookie: " + c.getName() + " " + c.getValue());
        }else numero = 0;
    }
}
