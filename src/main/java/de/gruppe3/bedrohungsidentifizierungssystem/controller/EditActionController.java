package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Action;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ActionService;
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
public class EditActionController {

    @GetMapping("/editAction")
    public String showEditDanger(Action action, Action editAction, BindingResult bindingResult, Model model) {
        model.addAttribute("action", action);
        model.addAttribute("editAction", editAction);
        return "editAction";
    }

    @Autowired
    private ActionService actionService;


    @PostMapping("/editAction/{actionId}")
    public String updateComponent(@PathVariable String actionId,
                                  @RequestParam(name = "actionName") String actionName,
                                  @RequestParam(name = "actionDueDate") String actionDueDate,
                                  @RequestParam(name = "protectionNeeds") int protectionNeeds,
                                  @Valid Action action, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("action", action);
            model.addAttribute("editAction", actionService.findActionWithId(Integer.parseInt(actionId)));
            return "/editAction";
        }
        actionService.updateAction(Integer.parseInt(actionId), actionName, actionDueDate, protectionNeeds);

        return "redirect:/action";
    }
}
