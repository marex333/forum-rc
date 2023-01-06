package pl.maron.dawid.forum_rc.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maron.dawid.forum_rc.database.IUserDAO;
import pl.maron.dawid.forum_rc.model.User;

@Controller
public class AuthenticatorController {
    @Autowired
    IUserDAO userDAO;
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password) {
        User user = this.userDAO.getUserByLogin(login);
        if (user != null && user.getPassword().equals(DigestUtils.md5Hex(password))) {
            return "redirect:/main";
        }
            return "redirect:/login";
    }
}
