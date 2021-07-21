package de.gruppe3.bedrohungsidentifizierungssystem.controller;


import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.DangerService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RequirementController {

    @Autowired
    private RequirementService requirementService;
    @Autowired
    ComponentService componentService;
    @Autowired
    DangerService dangerService;

    @GetMapping("/requirement")
    public String showRequirement(Model model) {

        model.addAttribute("requirements", requirementService.findAllRequirements());
        return "requirement";
    }

    @PostMapping("/deleteRequirement/{requirementId}")
    public String deleteRequirement(@PathVariable String requirementId) {

        requirementService.deleteRequirement(Integer.parseInt(requirementId));
        return "redirect:/requirement";
    }

    @PostMapping("/createRequirementButton")
    public String create() {
        return "redirect:/createRequirement";
    }

    @PostMapping("/addDangerButton")
    public String add(@RequestParam(name = "dangerId") String dangerId,
                      Model model, final RedirectAttributes redirectAttributes) {

        Danger dangerToAdd = dangerService.findProcessWithId(Integer.parseInt(dangerId));
        redirectAttributes.addFlashAttribute("dangerToAdd", dangerToAdd);
        return "redirect:/addDanger";
    }

    @PostMapping("/removeRequirementButton/{requirementId}")
    public String removeRequirement(@PathVariable String requirementId) {

        componentService.removeRequirement(Integer.parseInt(requirementId));
        return "redirect:/requirement";
    }

    @PostMapping({"/requirement/{requirementId}"})
    public String showEditRequirement(Model model, @PathVariable String requirementId) {
        model.addAttribute("editRequirement", requirementService.findRequirementWithId(Integer.parseInt(requirementId)));
        model.addAttribute("requirement", requirementService.findRequirementWithId(Integer.parseInt(requirementId)));
        return "editRequirement";
    }
}
