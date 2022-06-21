package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Album;
import model.AlbumDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@WebServlet(name = "addalbumservlet", value = "/addalbumservlet")
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15  // 15 MB
)
public class addalbumservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titolo = request.getParameter("titolo");
        Double prezzo = Double.valueOf(request.getParameter("prezzo"));
        String[] check = request.getParameterValues("homepage");
        Boolean homepage = false;
        if (check != null) {
            homepage = true;
        }

        System.out.println(homepage);
        InputStream inputStream = null; // input stream of the upload file

        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("file");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        Album album = new Album(titolo,prezzo,inputStream,homepage);
        AlbumDAO service = new AlbumDAO();
        service.doInsertAlbum(album);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin-home.jsp");
        dispatcher.forward(request,response);
    }
}
