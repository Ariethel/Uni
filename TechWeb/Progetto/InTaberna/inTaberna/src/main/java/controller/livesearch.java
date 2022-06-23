package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

import model.Album;
import model.AlbumDAO;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "livesearch", value = "/livesearch")
public class livesearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("str");
        AlbumDAO service = new AlbumDAO();
        ArrayList<Album> result = service.doGetLiveSearch(str);
        JSONArray array = new JSONArray();
        JSONObject user = new JSONObject();
        for (Album a: result) {
            user.put("name", a.getTitolo());
            user.put("prezzo", a.getPrezzo());
            array.put(user);
        }

        response.setContentType("application/json");
        response.getWriter().write(array.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
