package pl.maron.dawid.forum_rc.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.maron.dawid.forum_rc.database.IUserDAO;
import pl.maron.dawid.forum_rc.session.SessionObject;

@Controller
public class CommonController {
    private String pattern = "";
    @Autowired
    IUserDAO userDAO;
    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "redirect:/";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "main";
    }
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "contact";
    }

    @RequestMapping(value = "/faq", method = RequestMethod.GET)
    public String faq(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "faq";
    }
}
