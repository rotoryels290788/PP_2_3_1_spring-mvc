package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getUserAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void UserSave(User user) {
        entityManager.persist(user);
    }

    @Override
    public User showId(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(long id, User user) {
        User userUpdate = entityManager.find(User.class, id);
        userUpdate.setName(user.getName());
        userUpdate.setUserName(user.getUserName());
        userUpdate.setEmail(user.getEmail());
        entityManager.persist(userUpdate);
    }

    @Override
    public void delete(long id) {
        User userDelete = entityManager.find(User.class, id);
            entityManager.remove(userDelete);
      
    }
}



