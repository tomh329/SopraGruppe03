package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String showUser(Model model) {

        model.addAttribute("users", userService.findAllUsers());
        return "user";
    }

    @PostMapping({"/user/{username}"})
    public String showEditUser(Model model, @PathVariable String username) {
        model.addAttribute("editUsersName", userService.findUserWithName(username));
        return "editUser";
    }

    @PostMapping("/deleteUser/{username}")
    public String deleteProcess(@PathVariable String username) {
        System.out.println(
                userService.deleteUser(username)
        );
        return "redirect:/user";
    }

    @PostMapping("/createUserButton")
    public String create() {
        return "redirect:/createUser";
    }

    @PostMapping("/addUserToComponentButton")
    public String add() {

        return "redirect:/addUserToComponent";
    }
}
