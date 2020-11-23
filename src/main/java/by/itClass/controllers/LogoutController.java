package by.itClass.controllers;

import by.itClass.constants.Constants;
import by.itClass.model.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/logoutCont")
public class LogoutController extends AbstractController {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.USER);
        if (Objects.nonNull(user)) {
            session.invalidate();
        }
        jump(request, response, Constants.INDEX_JSP);
    }
}
