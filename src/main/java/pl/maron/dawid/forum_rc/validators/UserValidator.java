package pl.maron.dawid.forum_rc.validators;

import pl.maron.dawid.forum_rc.exceptions.UserValdationException;

public class UserValidator {
    public static void validateLogin(String login) {
        String regex = "^[a-zA-Z0-9]{5,}$";
        if(!login.matches(regex)) {
            throw new UserValdationException();
        }
    }

    public static void validatePassword(String password) {
        String regex = "^[a-zA-Z0-9]{5,}$";
        if(!password.matches(regex)) {
            throw new UserValdationException();
        }
    }
}
