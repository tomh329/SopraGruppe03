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
public class ToDoListController {

    @Autowired
    ActionService actionService;
    @Autowired
    ActionRepository actionRepository;

    @GetMapping("/toDoList")
    public String showComponent(Model model) {

        model.addAttribute("toDoActions", actionService.findToDoActionsForUser("Max"));
        model.addAttribute("doneActions", actionService.findDoneActionsForUser("Max"));
        return "toDoList";
    }
    @PostMapping("/toDoChangeStatus/{actionId}")
    public String toDoChangeStatus(@PathVariable String actionId) {


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

        return "redirect:/toDoList";
    }
}
