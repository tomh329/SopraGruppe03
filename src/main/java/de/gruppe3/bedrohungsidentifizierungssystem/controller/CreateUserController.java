package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import de.gruppe3.bedrohungsidentifizierungssystem.service.RoleService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CreateUserController {

    @GetMapping("/createUser")
    public String showCreateUser(User user, BindingResult bindingResult, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.findAllRoles());
        return "createUser";
    }

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    @PostMapping("/createUser")
    public String create(@RequestParam(name = "username") String username,
                         @RequestParam(name = "password") String password,
                         @RequestParam(name = "firstname") String firstname,
                         @RequestParam(name = "lastname") String lastname,
                         @RequestParam(name = "roleId") int roleId,
                         @Valid User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            model.addAttribute("roles", roleService.findAllRoles());
            return "/createUser";
        }
        if(userService.findUserWithName(username) != null) {
            return "redirect:user";
        }
        userService.createUser(username, password, firstname, lastname, roleId);
        return "redirect:/user";
    }
}
