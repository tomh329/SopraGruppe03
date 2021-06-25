package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditComponentController {

    @GetMapping("/editComponent")
    public String showEditComponent() {
        return "editComponent";
    }

    @Autowired
    private ComponentService componentService;


    @PostMapping("/editComponent/{componentId}")
    public String updateComponent(@PathVariable String componentId,
                                  @RequestParam(name = "componentName") String componentName,
                                  @RequestParam(name = "lastAttack") String lastAttack,
                                  @RequestParam(name = "occurrence") int occurrence,
                                  @RequestParam(name = "priority") int priority) {
        componentService.updateComponent(Integer.parseInt(componentId), componentName, lastAttack, occurrence, priority);

        return "redirect:/component";
    }
}
