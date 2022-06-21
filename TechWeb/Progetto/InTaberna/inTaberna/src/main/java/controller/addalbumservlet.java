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
        fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15, // 15 MB
        location            = "/home/amnesia/Uploads"
)
public class addalbumservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private static final String SAVE_DIR = "uploadFiles";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titolo = request.getParameter("titolo");
        Double prezzo = Double.valueOf(request.getParameter("prezzo"));
        Boolean homepage = Boolean.valueOf(request.getParameter("homepage"));

        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }


        //Save file in "location" path
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName);
        }



        /*AlbumDAO service = new AlbumDAO();
        service.doInsertAlbum(album);*/

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin-home.jsp");
        dispatcher.forward(request,response);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
