package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import de.gruppe3.bedrohungsidentifizierungssystem.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditRequirementController {

    @GetMapping("/editRequirement")
    public String showEditRequirement(Requirement editRequirement, Requirement requirement, BindingResult bindingResult, Model model) {
        model.addAttribute("editRequirement", editRequirement);
        model.addAttribute("requirement", requirement);
        return "editProcess";
    }

    @Autowired
    private RequirementService requirementService;


    @PostMapping("/editRequirement/{reqiurementId}")
    public String updateRequirement(@PathVariable String reqiurementId,
                                    @RequestParam(name = "requirementName") String requirementName
    ) {
        requirementService.updateRequirement(Integer.parseInt(reqiurementId), requirementName);

        return "redirect:/requirement";
    }
}
