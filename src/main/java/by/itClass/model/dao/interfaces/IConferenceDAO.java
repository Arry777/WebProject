package by.itClass.model.dao.interfaces;

import by.itClass.model.beans.Conference;
import by.itClass.model.beans.Event;
import by.itClass.model.enums.SectionMenu;

import java.util.List;

public interface IConferenceDAO {
    List<Conference> findConferencesBySection(SectionMenu section, int idUser);
    List<Event> findEventsForConf(int idConf);
    void deleteConferences(String[] ids);
    void saveConference(Conference conference, int idUser);
}
