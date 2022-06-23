package servlets;

import informationClasses.MusicDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DBInsertionServlet")
public class DBInsertionServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Map<String, String[]> bandInfo = request.getParameterMap();
        
        // In this case here we are not using the data sent to just do different things.
        // Instead we are using them as information to make changes to the server,
        // in this case, adding more bands and albums.
        String bandName = Arrays.asList(bandInfo.get("bandName")).get(0);
        String albums = Arrays.asList(bandInfo.get("albumName")).get(0);

        MusicDatabase.getInstance()
            .setBandAndAlbums(bandName, getAlbumNamesFromString(albums)); 
        
        // return success
        response.setStatus(200); 
    }

    // Split the album String in order to get a list of albums.
    private ArrayList<String> getAlbumNamesFromString(String albums) {
        return new ArrayList<String>(Arrays.asList(albums.split(",")));
    }
}
