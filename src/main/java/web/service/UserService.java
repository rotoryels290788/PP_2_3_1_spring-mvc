package web.service;
import org.springframework.stereotype.Component;
import web.model.User;
import java.util.List;

@Component
public interface UserService {

    List<User> getUserAll();

    void UserSave(User user);

    User showId(long id);

    void update(long id, User updateUser);

    void delete(long id);
}