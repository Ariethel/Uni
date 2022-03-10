package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.HeaderBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ServletRequestHeaders", value = "/index.html")
public class ServletRequestHeaders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> headerNames = Collections.list(request.getHeaderNames());
        List<String> headerValues = new ArrayList<>();
        for (int i = 0; i < headerNames.size(); i++){
            headerValues.add(request.getHeader(headerNames.get(i)));
        }

        HeaderBean headerBean = new HeaderBean(headerNames,headerValues);
        request.setAttribute("headers", headerBean);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/showHeaders.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
