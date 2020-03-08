package pl.vermintyn.dao;

import pl.vermintyn.model.User;

import java.util.Arrays;
import java.util.List;

public class UserDaoImpl implements UserDao{



    private static UserDaoImpl instance;

    private List<User> users;
    private UserDaoImpl(){
        users = Arrays.asList(
                new User(1L, "user1", "pwd1"),
                new User(2L, "user2", "pwd2"),
                new User(3L, "user3", "pwd3")
        );
    }

    public static UserDaoImpl getInstance() {
        if(instance ==null){
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public User getUser(String username, String password) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findAny()
                .orElse(null);
    }
}
