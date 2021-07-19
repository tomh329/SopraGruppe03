package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.service.ActionService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    ActionService actionService;
    @Autowired
    ComponentService componentService;
    @Autowired
    ProcessService processService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {

        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = ((UserDetails)principal).getUsername();

        int toDoActions = actionService.findToDoActionsForUser(username).size();
        int doneActions = actionService.findDoneActionsForUser(username).size();
        int countComponents = componentService.findAllComponents().size();
        int countProcesses = processService.findAllProcesses().size();

        model.addAttribute("toDoActions", Integer.toString(toDoActions));
        model.addAttribute("doneActions", Integer.toString(doneActions));
        model.addAttribute("countComponents", Integer.toString(countComponents));
        model.addAttribute("countProcesses", Integer.toString(countProcesses));
        return "dashboard";
    }


}
