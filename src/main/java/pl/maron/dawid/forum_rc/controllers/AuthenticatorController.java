package pl.maron.dawid.forum_rc.controllers;

import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maron.dawid.forum_rc.database.IUserDAO;
import pl.maron.dawid.forum_rc.exceptions.UserValdationException;
import pl.maron.dawid.forum_rc.model.User;
import pl.maron.dawid.forum_rc.session.SessionObject;
import pl.maron.dawid.forum_rc.validators.UserValidator;

import java.util.Optional;

@Controller
public class AuthenticatorController {
    @Autowired
    IUserDAO userDAO;
    @Resource
    SessionObject sessionObject;
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password) {
        try {
            UserValidator.validateLogin(login);
            UserValidator.validatePassword(password);
        } catch (UserValdationException e) {
            e.printStackTrace();
            return "redirect:/login";
        }
        Optional<User> userBox = this.userDAO.getUserByLogin(login);
        if (userBox.isPresent() && userBox.get().getPassword().equals(DigestUtils.md5Hex(password))) {
            userBox.get().setPassword(null);
            this.sessionObject.setUser(userBox.get());
            return "redirect:/main";
        }
            return "redirect:/login";
    }
    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.sessionObject.setUser(null);
        return "redirect:/login";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String name, @RequestParam String surname,
                           @RequestParam String login, @RequestParam String password,
                           @RequestParam String password2){

        return "register";
    }
}
