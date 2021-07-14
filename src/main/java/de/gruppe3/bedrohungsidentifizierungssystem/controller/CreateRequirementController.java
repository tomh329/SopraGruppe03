package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.DangerRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CreateRequirementController {

    @GetMapping("/createRequirement")
    public String showCreateRequirement(Requirement requirement, BindingResult bindingResult, Model model) {
        model.addAttribute("requirement", requirement);
        return "createRequirement";
    }

    @Autowired
    private RequirementService requirementService;

    @Autowired
    DangerRepository dangerRepository;

    @PostMapping("/createRequirement")
    public String create(@RequestParam(name = "requirementName") String requirementName,
                         @Valid Requirement requirement, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("requirement", requirement);
            return "/createRequirement";
        }
        requirementService.createRequirement(requirementName);
        return "redirect:/requirement";
    }
}
