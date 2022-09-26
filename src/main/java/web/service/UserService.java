package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(int id, User user);
    void update(int id, User user);
    User getUser(int id);
    List<User> listUsers();
}
