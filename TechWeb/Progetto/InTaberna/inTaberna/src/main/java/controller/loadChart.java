package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.AlbumDAO;
import model.Canzone;
import model.CanzoneDAO;
import model.CarrelloDAO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "loadChart", value = "/loadChart")
public class loadChart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("id");
        CarrelloDAO service = new CarrelloDAO();
        AlbumDAO service2 = new AlbumDAO();
        ArrayList<String> res = service.doRetriveById(id);
        JSONArray array = new JSONArray();
        for (String s:res) {
            JSONObject aName = new JSONObject();
            aName.put("name",s);
            aName.put("prezzo",service2.doGetPrice(s));
            array.put(aName);
        }
        response.setContentType("application/json");
        response.getWriter().write(array.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
