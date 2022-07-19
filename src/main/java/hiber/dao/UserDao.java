package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void delete(User user);
   void update(int id, User user);
   User getUser(int id);
   List<User> listUsers();
}
