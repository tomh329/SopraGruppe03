package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RequirementRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateComponentController {

    @GetMapping("/createComponent")
    public String showCreateComponent() {

        return "createComponent";
    }

    @Autowired
    private ComponentService componentService;
    @Autowired
    RequirementRepository requirementRepository;

    @PostMapping("/createComponent")
    public String create(@RequestParam(name = "componentName") String componentName,
                         @RequestParam (name = "lastAttack") String lastAttack,
                         @RequestParam (name = "occurrence") int occurrence,
                         @RequestParam (name = "priority") int priority,
                         @RequestParam (name = "requirementId") int requirementId){

        componentService.createComponent(componentName, occurrence, lastAttack, priority, requirementId);



        return "redirect:/component";
    }
}
