package de.gruppe3.bedrohungsidentifizierungssystem.controller;


import de.gruppe3.bedrohungsidentifizierungssystem.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RequirementController {

    @Autowired
    private RequirementService requirementService;

    @GetMapping("/requirement")
    public String showRequirement(Model model) {

        model.addAttribute("requirements", requirementService.findAllRequirements());
        return "requirement";
    }

    @PostMapping("/deleteRequirement/{requirementId}")
    public String deleteRequirement(@PathVariable String requirementId) {
        System.out.println(
                requirementService.deleteRequirement(Integer.parseInt(requirementId))
        );
        return "redirect:/requirement";
    }

    @PostMapping("/createRequirementButton")
    public String create() {
        return "redirect:/createRequirement";
    }

    @PostMapping("/addDangerButton")
    public String add() {
        return "redirect:/addDanger";
    }

    @PostMapping({"/requirement/{requirementId}"})
    public String showEditRequirement(Model model, @PathVariable String requirementId) {
        model.addAttribute("editRequirement", requirementService.findRequirementWithId(Integer.parseInt(requirementId)));
        model.addAttribute("requirement", requirementService.findRequirementWithId(Integer.parseInt(requirementId)));
        return "editRequirement";
    }
}
