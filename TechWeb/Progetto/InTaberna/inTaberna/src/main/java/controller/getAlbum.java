package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Album;
import model.AlbumDAO;
import model.UserDAO;
import model.Utente;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "getAlbum", value = "/getAlbum")
public class getAlbum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlbumDAO service = new AlbumDAO();
        ArrayList<Album> album = service.doRetriveAllAlbums();
        JSONArray array = new JSONArray();
        for (Album a:album) {
            JSONObject obj = new JSONObject();
            obj.put("name", a.getTitolo());
            array.put(obj);
        }
        response.setContentType("application/json");
        response.getWriter().write(array.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
