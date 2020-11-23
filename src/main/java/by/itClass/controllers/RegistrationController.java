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
import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;

@WebServlet("/registrationCont")
public class RegistrationController extends AbstractController {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        User user = new User(
                params.get(Constants.LOGIN_LABEL)[0],
                params.get(Constants.NAME_LABEL)[0],
                params.get(Constants.SURNAME_LABEL)[0],
                params.get(Constants.AGE_LABEL)[0],
                params.get(Constants.EMAIL_LABEL)[0],
                params.get(Constants.PHONE_LABEL)[0]
        );

        if (Objects.isNull(params.get(Constants.PASSWORD_LABEL)[0]) || params.get(Constants.PASSWORD_LABEL)[0].equals("")) {
            jump(request, response, Constants.REGISTRATION_JSP, Constants.EXIST_USER_MESSAGE);

        } else if (userService.save(user, params.get(Constants.PASSWORD_LABEL)[0])){
            jump(request, response, Constants.LOGIN_JSP);

        } else {
            jump(request, response, Constants.REGISTRATION_JSP, Constants.EXIST_USER_MESSAGE);
        }

    }
}
