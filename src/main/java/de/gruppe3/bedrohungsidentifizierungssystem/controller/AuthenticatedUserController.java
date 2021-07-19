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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
            return "/newPassword";
    }

    @PostMapping("/newPassword")
    public String create(Authentication authentication,
                         @RequestParam(name = "password") String password) {

        User loggedInUser = userRepository.findByUsername(authentication.getName());
        userService.updateUser(loggedInUser, bCryptPasswordEncoder.encode(password));
        return "redirect:/dashboard";
    }
}



