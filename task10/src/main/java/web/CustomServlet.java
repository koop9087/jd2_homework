package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Validator;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlet", urlPatterns = "/form")
public class CustomServlet extends HttpServlet {

    public static final String NAME_PARAM = "name";
    public static final String PHONE_PARAM = "phone";
    public static final String EMAIL_PARAM = "email";
    public static final String ERROR_MESSAGE = "Insert error";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String firstName = req.getParameter(NAME_PARAM);
        String lastName = req.getParameter(PHONE_PARAM);
        String email = req.getParameter(EMAIL_PARAM);
        if (Validator.validate(firstName, lastName, email)) {
            out.println(firstName + " " + lastName + " " + email);
        } else {
            out.println(ERROR_MESSAGE);
        }
    }
}
