package de.gruppe3.bedrohungsidentifizierungssystem.controller;


import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
public class ComponentController {


    @Autowired
    ComponentService componentService;
    @Autowired
    RequirementService requirementService;

    @GetMapping("/component")
    public String showComponent(Model model) {

        model.addAttribute("components", componentService.findAllComponents());
        return "component";
    }

    @PostMapping("/createComponentButton")
    public String create() {
        return "redirect:/createComponent";
    }

    @PostMapping("/addRequirementButton")
    public String add(@RequestParam(name = "requirementId") String requirementId,
                      Model model, final RedirectAttributes redirectAttributes) {


        Requirement requirementToAdd = requirementService.findRequirementWithId(Integer.parseInt(requirementId));
        redirectAttributes.addFlashAttribute("requirementToAdd", requirementToAdd);
        return "redirect:/addRequirement";
    }

    @PostMapping("/addActionButton")
    public String addAct(@RequestParam(name = "componentId") String componentId,
                         Model model, final RedirectAttributes redirectAttributes) {

        Component componentToAdd = componentService.findComponentWithId(Integer.parseInt(componentId));
        redirectAttributes.addFlashAttribute("componentToAdd", componentToAdd);
        System.out.println(componentService.findComponentWithId(Integer.parseInt(componentId)).getComponentName());
        return "redirect:/addAction";
    }

    @PostMapping("/removeActionButton/{actionId}")
    public String removeAction(@PathVariable String actionId){

        componentService.removeAction(Integer.parseInt(actionId));
        return "redirect:/component";
    }



    @PostMapping({"/component/{componentId}"})
    public String showEditComponent(Model model, @PathVariable String componentId) {
        model.addAttribute("editComponent", componentService.findComponentWithId(Integer.parseInt(componentId)));
        model.addAttribute("component", componentService.findComponentWithId(Integer.parseInt(componentId)));
        return "editComponent";
    }

    @PostMapping("/deleteComponent/{componentId}")
    public String deleteComponent(@PathVariable String componentId) {
        System.out.println(
                componentService.deleteComponent(Integer.parseInt(componentId))
        );
        return "redirect:/component";
    }
}
