package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(long id);
    List<User> getAllUser();
    void addUser(User user);
    User readUser(long id);
    void updateUser(User user);
    void removeUser(long id);
}
