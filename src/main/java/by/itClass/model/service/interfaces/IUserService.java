package by.itClass.model.service.interfaces;

import by.itClass.model.beans.User;

public interface IUserService {
    boolean save(User user, String password);
    User find(String login, String password);
    boolean delete(int id);
}
