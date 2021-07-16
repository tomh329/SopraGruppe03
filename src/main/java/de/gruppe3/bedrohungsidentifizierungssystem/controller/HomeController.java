package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * Zeigt die Startseite Ihrer Anwendung.
     *
     * @param model enthält alle ModelAttribute.
     * @return home-Seite.
     */
    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

/*    @PostMapping("/login")
    public String login() {
        return "redirect:/dashboard";
    }*/


}