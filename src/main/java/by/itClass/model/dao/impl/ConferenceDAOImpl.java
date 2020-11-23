package by.itClass.model.dao.impl;

import by.itClass.model.beans.Conference;
import by.itClass.model.beans.Event;
import by.itClass.model.beans.User;
import by.itClass.model.dao.interfaces.IConferenceDAO;
import by.itClass.model.db.ConnectionManager;
import by.itClass.model.enums.SectionMenu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static by.itClass.constants.SQLRequests.*;

public class ConferenceDAOImpl implements IConferenceDAO {

    @Override
    public List<Conference> findConferencesBySection(SectionMenu section, int idUser) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = section.getSql();

        List<Conference> conferences = new ArrayList<>();

        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(sql);

            if (section == SectionMenu.HOME) {
                pst.setInt(1, idUser);
            }

            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(ID_COL);
                String confTitle = rs.getString(TITLE_COL);
                String description = rs.getString(DESCRIPTION_COL);
                String place = rs.getString(PLACE_COL);
                Date date = rs.getDate(DATE_COL);
                int state = rs.getInt(STATE_COL);
                String author = rs.getString(AUTHOR_COL);
                List<Event> events = findEventsForConf(id);

                conferences.add(new Conference(id, confTitle, description, place, date, state, author, events));
            }


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();

        }

        return conferences;
    }

    @Override
    public List<Event> findEventsForConf(int idConf) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Event> events = new ArrayList<>();

        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(SELECT_EVENTS);
            pst.setInt(1, idConf);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(ID_COL);
                String title = rs.getString(TITLE_COL);
                Time time = rs.getTime(TIME_COL);
                events.add(new Event(id, title, time));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pst);
        }

        return events;
    }

    @Override
    public void deleteConferences(String[] ids) {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(DELETE_CONFERENCES);
            for (String idStr : ids) {
                int id = Integer.parseInt(idStr);
                pst.setInt(1, id);
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public void saveConference(Conference conference, int idUser) {
        Connection cn = null;
        PreparedStatement pstConf = null;
        PreparedStatement pstEvent = null;
        ResultSet rs = null;

        try {
            cn = ConnectionManager.getConnection();
            pstConf = cn.prepareStatement(INSERT_CONFERENCE, Statement.RETURN_GENERATED_KEYS);
            pstConf.setString(1, conference.getDescription());
            pstConf.setString(2, conference.getPlace());
            pstConf.setDate(3, conference.getDate());
            pstConf.setString(4, conference.getTitle());
            pstConf.setInt(5, idUser);
            pstConf.executeUpdate();
            rs = pstConf.getGeneratedKeys();

            List<Event> events = conference.getEvents();

            while (rs.next()) {
                int idConf = rs.getInt(1);
                pstEvent = cn.prepareStatement(INSERT_EVENT);

                for (Event event : events) {
                    pstEvent.setTime(1, event.getTime());
                    pstEvent.setString(2, event.getTitle());
                    pstEvent.setInt(3, idConf);
                    pstEvent.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());

        } finally {
            ConnectionManager.closeStatement(pstConf);
            ConnectionManager.closeStatement(pstEvent);
            ConnectionManager.closeConnection();
        }
    }

}
