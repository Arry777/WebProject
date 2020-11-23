package by.itClass.controllers;

import by.itClass.constants.Constants;
import by.itClass.model.beans.Conference;
import by.itClass.model.enums.ActionConference;
import by.itClass.model.enums.EnumManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/actionConfCont")
public class ActionConferenceController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter(Constants.ACTION_LABEL);
        String idConf = request.getParameter(Constants.ID_CONF_LABEL);

        ActionConference act = EnumManager.getKindActionConference(action);

        if (act == ActionConference.VIEW) {
            HttpSession session = request.getSession(true);
            List<Conference> conferences = (List<Conference>) session.getAttribute(Constants.CONFERENCES);

            Conference conference = conferenceService.getConferenceById(idConf, conferences);

            request.setAttribute(Constants.CONFERENCE, conference);
            jump(request, response, Constants.CONFERENCE_JSP);
        } else if (act == ActionConference.EDIT) {
            jump(request, response, Constants.EDIT_CONFERENCE_JSP);
        } else if (act == ActionConference.DELETE) {
            String[] ids = request.getParameterValues(Constants.IDS_CONF_LABEL);
            if (Objects.nonNull(ids)) {
                conferenceService.deleteConferences(ids);
            }
            jump(request, response, Constants.CONFERENCE_CONT);

        }
    }

}
