package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.repository.DangerRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateRequirementController {

    @GetMapping("/createRequirement")
    public String showCreateRequirement() {
        return "createRequirement";
    }

    @Autowired
    private RequirementService requirementService;

    @Autowired
    DangerRepository dangerRepository;

    @PostMapping("/createRequirement")
    public String create(@RequestParam(name = "requirementName") String requirementName){
        requirementService.createRequirement(requirementName);
        return "redirect:/requirement";
    }
}
