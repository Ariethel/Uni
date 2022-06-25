package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.AlbumDAO;
import model.Canzone;
import model.CanzoneDAO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "getSong", value = "/getSong")
public class getSong extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("id");
        CanzoneDAO service = new CanzoneDAO();
        ArrayList<Canzone> res = service.doRetriveByAlbumName(str);
        JSONArray array = new JSONArray();
        for (Canzone c:res) {
            JSONObject song = new JSONObject();
            song.put("name",c.getTitolo());
            array.put(song);
        }
        System.out.println(array.toString());
        response.setContentType("application/json");
        response.getWriter().write(array.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
