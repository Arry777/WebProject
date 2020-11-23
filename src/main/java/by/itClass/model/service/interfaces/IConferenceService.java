package by.itClass.model.service.interfaces;

import by.itClass.model.beans.Conference;
import by.itClass.model.beans.Event;
import by.itClass.model.beans.User;
import by.itClass.model.enums.SectionMenu;

import java.util.List;

public interface IConferenceService {
    List<Conference> findConferenceBySection(SectionMenu section, User user);
    Conference getConferenceById(String id, List<Conference> conferences);
    void deleteConferences(String[] ids);
    void saveConference(Conference conference, int idUser);
}
