package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Validator;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/form")
public class CustomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String firstName = req.getParameter("name");
        String lastName = req.getParameter("phone");
        String email = req.getParameter("email");
        if (Validator.validate(firstName, lastName, email)) {
            out.println(firstName + " " + lastName + " " + email);
        } else {
            throw new NullPointerException();
        }
    }
}
