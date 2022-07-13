package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.AlbumDAO;

import java.io.IOException;

@WebServlet(name = "getPicture", value = "/getPicture")
public class getPicture extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        AlbumDAO service = new AlbumDAO();
        if (id != null)
        {
            byte[] bt = service.load(id);

            ServletOutputStream out = response.getOutputStream();
            if(bt != null)
            {
                out.write(bt);
                response.setContentType("image/jpeg");
            }
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
