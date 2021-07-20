package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.UserRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddUserToComponentController {

    @GetMapping("/addUserToComponent")
    public String showAddUserToComponent(Model model) {

        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("components", componentService.findAllComponents());
        return "addUserToComponent";
    }


    @Autowired
    ComponentService componentService;

    @Autowired
    ComponentRepository componentRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/addUserToComponent")
    public String add(@RequestParam(name = "username") String username,
                      @RequestParam(name = "componentId") int componentId) {


        List<User> userList = userRepository.findAll();
        List<Component> componentList = componentRepository.findAll();


        for (User user : userList) {
            if (username.equals(user.getUsername())) {
                for (Component component : componentList) {
                    if (componentId == component.getComponentId()) {


                        if(user.getComponents().contains(component)){
                            userService.saveUser(user);
                            componentService.saveComponent(component);
                            return "redirect:/user";
                        }


                        component.addUser(user);
                        componentService.saveComponent(component);

                        user.addComponent(component);
                        userService.saveUser(user);

                        return "redirect:/user";
                    }
                }
            }
        }


        System.out.println("No Success");
        return "redirect:/user";
    }
}
