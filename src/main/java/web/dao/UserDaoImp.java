package web.dao;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final EntityManager entityManager;
   @Autowired
   public UserDaoImp(EntityManager entityManager) {
      this.entityManager = entityManager;
   }

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   public void delete(User user) {
       entityManager.find(User.class, user.getId());
       entityManager.remove(user);
   }

   @Override
   public void update(int id, User user) {
      entityManager.find(User.class, id);
      entityManager.merge(user);
   }

   @Override
   public User getUser(int id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public List<User> listUsers() {
      return entityManager.createQuery("select u from User u", User.class).getResultList();
   }
}
