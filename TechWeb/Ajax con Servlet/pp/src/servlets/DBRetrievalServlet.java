package servlets;
import informationClasses.MusicDatabase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DBRetrievalServlet")
public class DBRetrievalServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        // We set a specific return type and encoding
        // in order to take advantage of the browser capabilities.
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        
        // Depending on the GET parameters, passed from the Ajax call,
        // we are able to differentiate the requests and call the appropriate
        // method. We can always use more classes for more use-cases.
        
        // The response object returns the information (as a JSON object in String form)
        // to the browser.
        String buttonID = request.getParameter("button-id");
        switch (buttonID) {
            case "bands":
                response.getWriter().write(MusicDatabase
                        .getInstance()
                        .getBands());
                break;
                
            case "bands-albums":
                response.getWriter().write(MusicDatabase
                        .getInstance()
                        .getBandsAndAlbums());
                break;
        }
    }
}
