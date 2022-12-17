package web.dao;
import web.model.User;
import java.util.List;

public interface UserDao {
    List<User> getUserAll();

    void UserSave(User user);

    User showId(long id);

    void update(long id,User updateUser);

    void delete(long id);
}
