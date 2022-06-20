package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Album;
import model.AlbumDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet(name = "addalbumservlet", value = "/addalbumservlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class addalbumservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titolo = request.getParameter("titolo");
        Double prezzo = Double.valueOf(request.getParameter("prezzo"));
        //File img = new File(request.getParameter("img"));
        Part filePart = request.getPart("img"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        File file = new File(fileName);
        Boolean homepage = Boolean.valueOf(request.getParameter("homepage"));
        Album album = new Album(titolo,prezzo,file,homepage);
        AlbumDAO service = new AlbumDAO();
        service.doInsertAlbum(album);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin-home.jsp");
        dispatcher.forward(request,response);
    }
}
