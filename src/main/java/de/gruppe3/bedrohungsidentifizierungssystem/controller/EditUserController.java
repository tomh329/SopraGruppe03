package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import de.gruppe3.bedrohungsidentifizierungssystem.service.RoleService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditUserController {

    @GetMapping("/editUser")
    public String showEditUser(User user, Model model) {

        model.addAttribute("editUsersName",user);
        model.addAttribute("roles", roleService.findAllRoles());
        return "editUser";
    }

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostMapping("/editUser/{username}")
    public String updateUser(@PathVariable String username,
                             @RequestParam(name = "firstname") String firstname,
                             @RequestParam(name = "lastname") String lastname,
                             @RequestParam(name = "roleId") int roleId) {
        userService.updateUser(username, firstname, lastname, roleId);

        return "redirect:/user";
    }
}
