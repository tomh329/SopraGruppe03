package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import de.gruppe3.bedrohungsidentifizierungssystem.service.DangerService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    DangerService dangerService;

    @GetMapping("/user")
    public String showUser(Model model) {

        model.addAttribute("users", userService.findAllUsers());
        return "user";
    }

    @PostMapping({"/user/{username}"})
    public String showEditUser(Model model, @PathVariable String username) {
        model.addAttribute("editUsersName", userService.findUserWithName(username));
        model.addAttribute("user", userService.findUserWithName(username));
        return "editUser";
    }

    @PostMapping("/deleteUser/{username}")
    public String deleteProcess(@PathVariable String username) {

        userService.deleteUser(username);
        return "redirect:/user";
    }

    @PostMapping("/createUserButton")
    public String create() {
        return "redirect:/createUser";
    }

    @PostMapping("/addUserToComponentButton")
    public String add(@RequestParam(name = "username") String username,
                      Model model, final RedirectAttributes redirectAttributes) {

        User userToAdd = userService.findUserWithName(username);
        redirectAttributes.addFlashAttribute("userToAdd", userToAdd);
        return "redirect:/addUserToComponent";
    }


    @PostMapping("/removeComponentAndUserButton")
    public String removeComponent(@RequestParam(name = "username") String username,
                                  @RequestParam(name = "componentId") int componentId) {

        userService.removeComponent(username, componentId);
        return "redirect:/user";
    }
}
