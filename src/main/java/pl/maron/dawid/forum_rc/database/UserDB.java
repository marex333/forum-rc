package pl.maron.dawid.forum_rc.database;

import org.springframework.stereotype.Component;
import pl.maron.dawid.forum_rc.model.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDB implements IUserDAO {
    private final List<User> users = new ArrayList<>();
    public UserDB() {
        this.users.add(new User(1, "Dawid", "52f6a449e845b89797c84cb27f5a5459",
                "Dawid", "Maron", User.Role.ADMIN));
        this.users.add(new User(2, "Paulina", "7a6c2e495808941f26d5d7d6aafbb972",
                "Paulina", "Maron", User.Role.MOD));
        this.users.add(new User(3, "Malwina", "5c7ec6cf6eb3c7b1b3c186b118efb1ce",
                "Malwina", "Maron", User.Role.USER));
    }

    @Override
    public User getUserByLogin(String login) {
        for (User user : this.users) {
            if(user.getLogin().equals(login))
                return user;
        }
        return null;
    }

    @Override
    public void persistUser(User user) {
        if (getUserByLogin(user.getLogin()) != null) {
            return;
        }
        this.users.add(user);
    }
}
