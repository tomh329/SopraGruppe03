package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Action;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ActionRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ActionController {

    @Autowired
    ActionService actionService;
    @Autowired
    ActionRepository actionRepository;

    @GetMapping("/action")
    public String showComponent(Model model) {

        model.addAttribute("actions", actionService.findAllActions());
        return "action";
    }

    @PostMapping("/createActionButton")
    public String create() {
        return "redirect:/createAction";
    }




//    @PostMapping({"/action/{actionId}"})
//    public String showEditComponent(Model model, @PathVariable String actionId) {
//        model.addAttribute("editAction", actionService.findActionWithId(Integer.parseInt(actionId)));
//        return "editAction";
//    }

    @PostMapping("/deleteAction/{actionId}")
    public String deleteAction(@PathVariable String actionId) {

        actionService.deleteAction(Integer.parseInt(actionId));
        return "redirect:/action";
    }

    @PostMapping("/changeStatus/{actionId}")
    public String changeStatus(@PathVariable String actionId) {


        int id = (Integer.parseInt(actionId));

        List<Action> actionList = actionRepository.findAll();
        for(Action action : actionList){

            if(id == action.getActionId()){
                if(action.getStatus() == false) {
                    action.setStatus(true);
                    actionRepository.save(action);
                } else if (action.getStatus() == true) {
                    action.setStatus(false);
                    actionRepository.save(action);
                }
            }
        }

        return "redirect:/action";
    }

    @PostMapping({"/action/{actionId}"})
    public String showEditProcess(Model model, @PathVariable String actionId) {
        model.addAttribute("editAction", actionService.findActionWithId(Integer.parseInt(actionId)));
        model.addAttribute("action", actionService.findActionWithId(Integer.parseInt(actionId)));
        return "editAction";
    }
}
