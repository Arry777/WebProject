package by.itClass.controllers;

import by.itClass.constants.Constants;
import by.itClass.model.beans.User;
import by.itClass.model.dao.interfaces.IUserDAO;
import by.itClass.model.service.impl.UserServiceImpl;
import by.itClass.model.service.interfaces.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/loginCont")
public class LoginController extends AbstractController {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(Constants.LOGIN_LABEL);
        String password = request.getParameter(Constants.PASSWORD_LABEL);
        User user = userService.find(login, password);

        if (Objects.nonNull(user)) {
            HttpSession session = request.getSession(true);
            session.setAttribute(Constants.USER, user);
            jump(request, response, Constants.CONFERENCE_CONT);
        } else {
            jump(request, response, Constants.LOGIN_JSP, Constants.NOT_FOUND_USER_MESSAGE);
        }
    }
}
