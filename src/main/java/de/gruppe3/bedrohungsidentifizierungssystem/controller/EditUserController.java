package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import de.gruppe3.bedrohungsidentifizierungssystem.service.RoleService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditUserController {


    @GetMapping("/editUser")
    public String showEditUser(User editUser, User user, BindingResult bindingResult, Model model) {

        model.addAttribute("editUsersName", editUser);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.findAllRoles());
        return "editUser";
    }

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostMapping("/editUser/{username}")
    public String updateUser(@PathVariable String username,
                             @RequestParam(name = "password") String password,
                             @RequestParam(name = "firstname") String firstname,
                             @RequestParam(name = "lastname") String lastname,
                             @RequestParam(name = "roleId") int roleId) {
        userService.updateUser(username, password, firstname, lastname, roleId);

        return "redirect:/user";
    }
}
