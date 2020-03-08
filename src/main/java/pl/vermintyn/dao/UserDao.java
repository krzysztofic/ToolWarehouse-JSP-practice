package pl.vermintyn.dao;

import pl.vermintyn.model.User;

public interface UserDao {
    User getUser(String username, String password);
}
