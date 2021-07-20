package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ActionService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    ActionService actionService;
    @Autowired
    ComponentService componentService;
    @Autowired
    ProcessService processService;
    @Autowired
    UserService userService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {

        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = ((UserDetails)principal).getUsername();

        //Simple numbers
        int toDoActions = actionService.findToDoActionsForUser(username).size();
        int doneActions = actionService.findDoneActionsForUser(username).size();
        int countComponents = componentService.findAllComponents().size();
        int countProcesses = processService.findAllProcesses().size();

        //Chart data
        ArrayList<String> usernameList = new ArrayList<>();
        ArrayList<Integer> numberOfDoneTasks = new ArrayList<>();
        List<User> userList = userService.findAllUsers();
        for(int i=0; i<userList.size(); i++){
            usernameList.add(userList.get(i).getUsername());
        }
        for(int i=0; i<userList.size(); i++){
            numberOfDoneTasks.add(actionService.findDoneActionsForUser(userList.get(i).getUsername()).size());
        }



        model.addAttribute("toDoActions", Integer.toString(toDoActions));
        model.addAttribute("doneActions", Integer.toString(doneActions));
        model.addAttribute("countComponents", Integer.toString(countComponents));
        model.addAttribute("countProcesses", Integer.toString(countProcesses));
        model.addAttribute("usernameList", usernameList);
        model.addAttribute("userDoneTaskList", numberOfDoneTasks);
        return "dashboard";
    }


}
