package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MyCustomFileCreator;
import service.MyCustomFileWriter;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "customServlet", urlPatterns = "/servlet")
public class MyCustomServlet extends HttpServlet {
    int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        count++;
        MyCustomFileCreator.createDirAndFile();
        MyCustomFileWriter.writeFile(count);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(count);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}