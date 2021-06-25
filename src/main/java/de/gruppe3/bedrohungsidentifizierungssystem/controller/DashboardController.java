package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {


    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }

    @PostMapping("/process")
    public String navigateToProcess() {
        return "redirect:/process";
    }


    @PostMapping("/component")
    public String navigateToComponent() {
        return "redirect:/component";
    }
}
