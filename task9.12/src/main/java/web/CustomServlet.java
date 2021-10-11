package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CustomFileCreator;
import service.CustomFileWriter;
import service.CustomImageCreator;

import java.io.IOException;

@WebServlet(name = "customServlet", urlPatterns = "/image")
public class CustomServlet extends HttpServlet {
    int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        count++;
        CustomFileCreator.createDirAndFile();
        CustomFileWriter.writeFile(count);
        resp.setContentType("image/jpeg");
        CustomImageCreator.createAndWriteImage(count, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}