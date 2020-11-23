package by.itClass.model.dao.interfaces;

import by.itClass.model.beans.User;

public interface IUserDAO {
    boolean save(User user, String password);//registration
    User find(String login, String password);//authorization
    boolean delete(int id);
}
