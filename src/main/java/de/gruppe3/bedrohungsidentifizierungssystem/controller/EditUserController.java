package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditUserController {

    @GetMapping("/editUser")
    public String showEditUser() {

        return "editUser";
    }

    @Autowired
    private UserService userService;


    @PostMapping("/editUser/{username}")
    public String updateUser(@PathVariable String username,
                             @RequestParam (name = "firstname") String firstname,
                             @RequestParam (name = "lastname") String lastname,
                             @RequestParam (name = "userRole") String userRole) {
        userService.updateUser(username, firstname, lastname, userRole);

        return "redirect:/user";
    }
}
