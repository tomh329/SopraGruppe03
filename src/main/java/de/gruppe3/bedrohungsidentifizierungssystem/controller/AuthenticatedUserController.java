package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.UserRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthenticatedUserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/newPassword")
        public String currentUserName(Authentication authentication, Model model) {

            User loggedInUser = userRepository.findByUsername(authentication.getName());
            model.addAttribute("loggedInUser", loggedInUser);
            model.addAttribute("user", loggedInUser);
            return "/newPassword";
    }

    @PostMapping("/newPassword")
    public String create(Authentication authentication,
                         @RequestParam(name = "password") String password,
                         @Valid User user, BindingResult bindingResult, Model model) {
        User loggedInUser = userRepository.findByUsername(authentication.getName());

        if(bindingResult.hasFieldErrors("password")){
            model.addAttribute("user", user);
            model.addAttribute("loggedInUser", loggedInUser);
            return "/newPassword";
        }

        userService.updateUser(loggedInUser, bCryptPasswordEncoder.encode(password));
        return "redirect:/dashboard";
    }

    @PostMapping("/newPassword/{username}")
    public String updateUser(@PathVariable String username,
                             @RequestParam(name = "password") String password,
                             @Valid User user, BindingResult bindingResult, Model model) {
        User loggedInUser = userRepository.findByUsername(username);

        if(bindingResult.hasFieldErrors("password")){
            model.addAttribute("user", user);
            model.addAttribute("editUsersName", loggedInUser);
            return "/editUser";
        }

        userService.updateUser(loggedInUser, bCryptPasswordEncoder.encode(password));

        return "redirect:/user";
    }
}



