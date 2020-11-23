package by.itClass.controllers;

import by.itClass.constants.Constants;
import by.itClass.model.beans.Conference;
import by.itClass.model.beans.User;
import by.itClass.model.enums.EnumManager;
import by.itClass.model.enums.SectionMenu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/confCont")
public class ConferenceController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sect = req.getParameter(Constants.SECTION_LABEL);

        SectionMenu section = EnumManager.getKindSectionMenu(sect);

        HttpSession session = req.getSession(true);
        User user = (User) session.getAttribute(Constants.USER);

        List<Conference> conferences = conferenceService.findConferenceBySection(section, user);

        session.setAttribute(Constants.CONFERENCES, conferences);
        if (section == SectionMenu.HOME) {
            jump(req, resp, Constants.HOME_JSP);
        } else {
            jump(req, resp, Constants.INDEX_JSP);
        }


    }
}
