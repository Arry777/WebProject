package by.itClass.controllers;

import by.itClass.constants.Constants;
import by.itClass.model.service.impl.ConferenceServiceImpl;
import by.itClass.model.service.impl.UserServiceImpl;
import by.itClass.model.service.interfaces.IConferenceService;
import by.itClass.model.service.interfaces.IUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AbstractController")
public class AbstractController extends HttpServlet {
    protected IUserService userService;
    protected IConferenceService conferenceService;
    public AbstractController() {
        super();
        this.userService = new UserServiceImpl();
        this.conferenceService = new ConferenceServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void jump(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    protected void jump(HttpServletRequest request, HttpServletResponse response, String url, String message) throws ServletException, IOException {
        request.setAttribute(Constants.MESSAGE, message);
        jump(request, response, url);
    }
}
