package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateUserController {

    @GetMapping("/createUser")
    public String showCreateUser() {
        return "createUser";
    }

    @Autowired
    private UserService userService;


    @PostMapping("/createUser")
    public String create(@RequestParam(name = "username") String username,
                         @RequestParam(name = "password") String password,
                         @RequestParam(name = "firstname") String firstname,
                         @RequestParam(name = "lastname") String lastname,
                         @RequestParam(name = "roleId") int roleId) {
        if(userService.findUserWithName(username) != null) {
            return "redirect:user";
        }
        userService.createUser(username, password, firstname, lastname, roleId);
        return "redirect:/user";
    }
}
