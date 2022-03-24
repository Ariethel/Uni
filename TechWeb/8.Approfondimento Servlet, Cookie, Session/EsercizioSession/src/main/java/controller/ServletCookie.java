package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCookie", value = "/index.html")
public class ServletCookie extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //QUESTA SERVLET DEVE ESSERE FIXATA
        PrintWriter out = res.getWriter();
        //Invio
        Cookie cookieTest = new Cookie("numAccessi", "0");
        cookieTest.setSecure(true);
        cookieTest.setMaxAge(60 * 60 * 24);
        cookieTest.setPath("/");
        res.addCookie(cookieTest);

        //Lettura
        Cookie[] cookies = req.getCookies();
        Cookie c = cookies[0];
        if (c != null) {
            out.println("cookie: " + c.getName() + " " + c.getValue());
            cookieTest.setValue(Integer.toString(Integer.parseInt(c.getValue()) + 1));
        }
    }
}
