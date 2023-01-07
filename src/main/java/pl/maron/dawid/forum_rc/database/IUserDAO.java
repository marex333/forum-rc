package pl.maron.dawid.forum_rc.database;

import pl.maron.dawid.forum_rc.model.User;

import java.util.Optional;

public interface IUserDAO {
    Optional<User> getUserByLogin(String login);
    void persistUser(User user);
}
