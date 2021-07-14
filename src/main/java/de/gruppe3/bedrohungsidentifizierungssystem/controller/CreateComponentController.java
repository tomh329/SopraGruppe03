package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RequirementRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CreateComponentController {

    @GetMapping("/createComponent")
    public String showCreateComponent(Component component, BindingResult bindingResult, Model model) {
        model.addAttribute("component", component);
        return "createComponent";
    }

    @Autowired
    private ComponentService componentService;
    @Autowired
    RequirementRepository requirementRepository;

    @PostMapping("/createComponent")
    public String create(@RequestParam(name = "componentName") String componentName,
                         @RequestParam(name = "lastAttack") String lastAttack,
                         @RequestParam(name = "occurrence") int occurrence,
                         @RequestParam(name = "priority") int priority,
                         @Valid Component component, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("component", component);
            return "/createComponent";
        }
        componentService.createComponent(componentName, occurrence, lastAttack, priority);


        return "redirect:/component";
    }
}
