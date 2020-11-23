package by.itClass.model.service.impl;

import by.itClass.constants.Constants;
import by.itClass.model.beans.Conference;
import by.itClass.model.beans.Event;
import by.itClass.model.beans.User;
import by.itClass.model.dao.impl.ConferenceDAOImpl;
import by.itClass.model.dao.interfaces.IConferenceDAO;
import by.itClass.model.enums.EnumManager;
import by.itClass.model.enums.SectionMenu;
import by.itClass.model.service.interfaces.IConferenceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConferenceServiceImpl implements IConferenceService {
    private IConferenceDAO conferenceDAO;

    public ConferenceServiceImpl() {
        conferenceDAO = new ConferenceDAOImpl();
    }

    @Override
    public List<Conference> findConferenceBySection(SectionMenu section, User user) {
        List<Conference> conferences = null;

        if (Objects.nonNull(user)) {
            conferences = conferenceDAO.findConferencesBySection(section, user.getId());
        } else {
            conferences = conferenceDAO.findConferencesBySection(section, Constants.ID_DEFAULT);
        }
        return conferences;
    }

    @Override
    public Conference getConferenceById(String id, List<Conference> conferences) {
        int idConf = Integer.parseInt(id);

        return conferences.stream()
                .filter(conference -> conference.getId() == idConf)
                .findFirst()
                .get();
    }

    @Override
    public void deleteConferences(String[] ids) {
        conferenceDAO.deleteConferences(ids);
    }

    @Override
    public void saveConference(Conference conference, int idUser) {
        conferenceDAO.saveConference(conference, idUser);
    }

}
