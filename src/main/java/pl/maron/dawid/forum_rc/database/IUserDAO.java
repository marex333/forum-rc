package pl.maron.dawid.forum_rc.database;

import pl.maron.dawid.forum_rc.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
    void persistUser(User user);
}
