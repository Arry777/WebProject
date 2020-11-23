package by.itClass.model.dao.impl;

import by.itClass.model.beans.User;
import by.itClass.model.dao.interfaces.IUserDAO;
import by.itClass.model.db.ConnectionManager;

import static by.itClass.constants.SQLRequests.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements IUserDAO {
    private final String LOCK = new String();

    @Override
    public boolean save(User user, String password) {
        Connection cn = null;
        PreparedStatement pst = null;
        boolean result = false;

        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(INSERT_USER);

            pst.setString(1, password);
            pst.setString(2, user.getName());
            pst.setString(3, user.getSurname());
            pst.setInt(4, user.getAge());
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getPhone());
            pst.setString(7, user.getLogin());

            synchronized (LOCK) {
                //Thread.sleep(6000);
                if (!isFoundUser(user)) {
                    result = pst.executeUpdate() > 0 ? true : false;
                }

            }

        } catch (SQLException /*| InterruptedException*/ e) {
            e.printStackTrace();
            System.err.println(e.getMessage());

        } finally {
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }

        return result;
    }

    @Override
    public User find(String login, String password) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        User user = null;

        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(SELECT_USER);
            pst.setString(1, login);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(ID_COL);
                String name = rs.getString(NAME_COL);
                String surname = rs.getString(SURNAME_COL);
                int age = rs.getInt(AGE_COL);
                String email = rs.getString(EMAIL_COL);
                String phone = rs.getString(PHONE_COL);
                user = new User(id, login, name, surname, age, email, phone);

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }
        return user;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private boolean isFoundUser(User user) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            cn = ConnectionManager.getConnection();
            pst = cn.prepareStatement(SELECT_LOGIN_AND_EMAIL);
            pst.setString(1, user.getLogin());
            pst.setString(2, user.getEmail());
            rs = pst.executeQuery();
            result = rs.next();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pst);
        }
        System.out.println(result);
        return result;
    }
}
