package by.itClass.controllers;

import by.itClass.constants.Constants;
import by.itClass.model.beans.Conference;
import by.itClass.model.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/createConfCont")
public class CreateConferenceController extends AbstractController {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titleConf = request.getParameter(Constants.CONF_TITLE_LABEL);
        String description = request.getParameter(Constants.DESCRIPTION_LABEL);
        String place = request.getParameter(Constants.PLACE_LABEL);
        String date = request.getParameter(Constants.DATE_LABEL);

        String[] titleEvents = request.getParameterValues(Constants.EVENT_TITLE_LABEL);
        String[] timeEvents = request.getParameterValues(Constants.TIME_LABEL);

        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute(Constants.USER);

        Conference conference = new Conference(titleConf, description, place, date);
        conference.setEvents(titleEvents, timeEvents);
        conference.setAuthor(user.getName(), user.getSurname());

        conferenceService.saveConference(conference, user.getId());
        jump(request, response, Constants.HOME_JSP);
    }
}
