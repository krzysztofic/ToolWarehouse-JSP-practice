package pl.vermintyn.service;

import pl.vermintyn.dao.UserDao;
import pl.vermintyn.dao.UserDaoImpl;
import pl.vermintyn.model.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao = UserDaoImpl.getInstance();

    private static UserServiceImpl instance;

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if(instance == null) {
            instance = new UserServiceImpl();
        }

        return instance;
    }

    @Override
    public boolean isUserValid(String username, String password) {
        User user = userDao.getUser(username, password);
        return user != null;
    }
}
