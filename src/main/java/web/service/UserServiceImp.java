package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    final
    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getUserAll() {
        return userDao.getUserAll();
    }

    @Override
    @Transactional
    public void UserSave(User user) {
        userDao.UserSave(user);
    }

    @Override
    @Transactional
    public User showId(long id) {
        return userDao.showId(id);
    }

    @Override
    @Transactional
    public void update(long id, User updateUser) {
        userDao.update(id, updateUser);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }


}



