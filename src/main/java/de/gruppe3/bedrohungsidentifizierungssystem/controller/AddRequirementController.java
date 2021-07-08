package de.gruppe3.bedrohungsidentifizierungssystem.controller;


import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RequirementRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddRequirementController {

    @GetMapping("/addRequirement")
    public String showAddComponent(Model model) {

        model.addAttribute("requirements", requirementService.findAllRequirements());
        model.addAttribute("components", componentService.findAllComponents());
        return "addRequirement";
    }


    @Autowired
    RequirementService requirementService;
    @Autowired
    ComponentRepository componentRepository;

    @Autowired
    RequirementRepository requirementRepository;
    @Autowired
    ComponentService componentService;

    @PostMapping("/addRequirement")
    public String add(@RequestParam(name = "componentId") int componentId,
                      @RequestParam(name = "requirementId") int requirementId) {

        List<Requirement> requirementList = requirementRepository.findAll();
        List<Component> componentList = componentRepository.findAll();

        for (Component component : componentList) {
            if (componentId == component.getComponentId()) {
                for (Requirement requirement : requirementList) {
                    if (requirementId == requirement.getRequirementId()) {

                        requirement.setComponent(component);
                        requirementService.saveRequirement(requirement);
                        return "redirect:/component";
                    }
                }
            }
        }

        System.out.println("No Success");
        return "redirect:/component";
    }
}
