package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(User user);
    void update(int id, User user);
    User getUser(int id);
    List<User> listUsers();
}
