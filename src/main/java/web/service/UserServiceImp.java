package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;
   @Autowired
   public UserServiceImp(UserDao userDao) {this.userDao = userDao;};

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public void delete(User user) {
      userDao.delete(user);
   }

   @Transactional
   @Override
   public void update(int id, User user) {
      userDao.update(id, user);
   }
   @Transactional
   @Override
   public User getUser(int id) {
      return userDao.getUser(id);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

}
