package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

import model.Album;
import model.AlbumDAO;
import model.Canzone;
import model.CanzoneDAO;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "livesearch", value = "/livesearch")
public class livesearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("str");
        AlbumDAO service = new AlbumDAO();
        CanzoneDAO serviceC = new CanzoneDAO();
        ArrayList<Album> result = service.doGetLiveSearch(str);
        ArrayList<Canzone> canzoni = serviceC.doRetriveByAlbumName(result.get(0).getTitolo());
        JSONArray array = new JSONArray();
        JSONObject user = new JSONObject();
        JSONArray songArray = new JSONArray();
        for (Album a: result) {
            user.put("name", a.getTitolo());
            user.put("prezzo", a.getPrezzo());
            for (Canzone c:canzoni) {
                songArray.put(c.getTitolo());
            }
            user.put("songs",songArray);
            array.put(user);
        }

        response.setContentType("application/json");
        response.getWriter().write(array.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
