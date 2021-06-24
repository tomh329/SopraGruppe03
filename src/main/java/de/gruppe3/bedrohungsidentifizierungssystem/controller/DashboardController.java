package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {


    @GetMapping("/dashboard")
    public String showDashboard() {


        return "dashboard";
    }


}
