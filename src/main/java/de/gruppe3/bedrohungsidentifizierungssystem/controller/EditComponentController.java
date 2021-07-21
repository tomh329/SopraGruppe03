package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class EditComponentController {

    @GetMapping("/editComponent")
    public String showEditComponent(Component editComponent, Component component, BindingResult bindingResult, Model model) {
        model.addAttribute("component", component);
        model.addAttribute("editComponent", editComponent);
        return "editComponent";
    }

    @Autowired
    private ComponentService componentService;


    @PostMapping("/editComponent/{componentId}")
    public String updateComponent(@PathVariable String componentId,
                                  @RequestParam(name = "componentName") String componentName,
                                  @RequestParam(name = "lastAttack") String lastAttack,
                                  @RequestParam(name = "occurrence") int occurrence,
                                  @RequestParam(name = "priority") int priority,
                                  @Valid Component component, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("component", component);
            model.addAttribute("editComponent", componentService.findComponentWithId(Integer.parseInt(componentId)));
            return "/editComponent";
        }

        componentService.updateComponent(Integer.parseInt(componentId), componentName, lastAttack, occurrence, priority);

        return "redirect:/component";
    }
}
