package by.itClass.model.service.impl;

import by.itClass.constants.Constants;
import by.itClass.model.beans.User;
import by.itClass.model.dao.impl.UserDAOImpl;
import by.itClass.model.dao.interfaces.IUserDAO;
import by.itClass.model.service.interfaces.IUserService;

import java.util.Map;

public class UserServiceImpl implements IUserService {
    private IUserDAO userDAO;

//    public UserServiceImpl(String db) {//mysql, mongodb
//        userDAO = FactoryDAO.getInstance(db);
//    }

    public UserServiceImpl() {
        super();
        userDAO = new UserDAOImpl();
    }

    @Override
    public boolean save(User user, String password) { return userDAO.save(user, password); }

    @Override
    public User find(String login, String password) {
        return userDAO.find(login, password);
    }

    @Override
    public boolean delete(int id) {
        return userDAO.delete(id);
    }
}
