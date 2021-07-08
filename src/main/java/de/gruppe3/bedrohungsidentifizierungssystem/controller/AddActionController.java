package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Action;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ActionRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RequirementRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ActionService;
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
public class AddActionController {

    @GetMapping("/addAction")
    public String showAddAction(Model model) {

        model.addAttribute("actions", actionService.findAllActions());
        model.addAttribute("components", componentService.findAllComponents());
        return "addAction";
    }


    @Autowired
    ActionRepository actionRepository;
    @Autowired
    ActionService actionService;

    @Autowired
    ComponentRepository componentRepository;
    @Autowired
    ComponentService componentService;



    @PostMapping("/addAction")
    public String add(@RequestParam(name = "componentId") int componentId,
                      @RequestParam(name = "actionId") int actionId) {

        List<Action> actionList = actionRepository.findAll();
        List<Component> componentList = componentRepository.findAll();

        for (Component component : componentList) {
            if (componentId == component.getComponentId()) {
                for (Action action : actionList) {
                    if (actionId == action.getActionId()) {

                        action.setComponent(component);
                        actionService.saveAction(action);
                        return "redirect:/component";
                    }
                }
            }
        }

        System.out.println("No Success");
        return "redirect:/component";
    }
}
