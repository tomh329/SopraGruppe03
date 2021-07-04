package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Action;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ActionService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CreateActionController {


    @GetMapping("/createAction")
    public String showCreateAction(Action action, BindingResult bindingResult, Model model) {
        model.addAttribute("action",action);
        return "createAction";
    }

    @Autowired
    private ActionService actionService;


    @PostMapping("/createAction")
    public String create(@RequestParam(name = "actionName") String actionName,
                         @RequestParam(name = "actionDueDate") String actionDueDate,
                         @RequestParam(name = "protectionNeeds") int protectionNeeds,
                         @Valid Action action, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("action",action);
            return "/createAction";

        }

        actionService.createAction(actionName, actionDueDate, protectionNeeds);

        System.out.println("Success");

        return "redirect:/action";
    }


}
