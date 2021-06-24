package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DashboardController {



    @GetMapping("/dashboard")
    public String showDashboard() {


        return "dashboard";
    }



    @Autowired
    ProcessService processService;
    @Autowired
    ComponentRepository componentRepository;

    @PostMapping("/create")
    public String create(@RequestParam(name = "processName") String processName,
                         @RequestParam (name = "protectionLevel") int protectionLevel,
                         @RequestParam (name = "componentId") int componentId){

        processService.createProcess(processName, protectionLevel, componentId);

        System.out.println(processName);
        System.out.println(protectionLevel);
        System.out.println(componentId);

        return "dashboard";
    }


}
