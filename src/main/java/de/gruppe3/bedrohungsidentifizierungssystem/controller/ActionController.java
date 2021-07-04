package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.service.ActionService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActionController {

    @Autowired
    ActionService actionService;

    @GetMapping("/action")
    public String showComponent(Model model) {

        model.addAttribute("actions", actionService.findAllActions());
        return "action";
    }

    @PostMapping("/createActionButton")
    public String create() {
        return "redirect:/createAction";
    }

//    @PostMapping("/addRequirementButton")
//    public String add() {
//        return "redirect:/addRequirement";
//    }

    @PostMapping({"/action/{actionId}"})
    public String showEditComponent(Model model, @PathVariable String actionId) {
        model.addAttribute("editAction", actionService.findActionWithId(Integer.parseInt(actionId)));
        return "editComponent";
    }

    @PostMapping("/deleteAction/{actionId}")
    public String deleteAction(@PathVariable String actionId) {
        System.out.println(
                actionService.deleteAction(Integer.parseInt(actionId))
        );
        return "redirect:/action";
    }
}
