package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
import de.gruppe3.bedrohungsidentifizierungssystem.service.DangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CreateDangerController {

    @GetMapping("/createDanger")
    public String showCreateDanger(Danger danger, BindingResult bindingResult, Model model) {
        model.addAttribute("danger", danger);
        return "createDanger";
    }

    @Autowired
    private DangerService dangerService;


    @PostMapping("/createDanger")
    public String create(@RequestParam(name = "dangerName") String dangerName,
                         @RequestParam(name = "dangerLevel") int dangerLevel,
                         @Valid Danger danger, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("danger", danger);
            return "/createDanger";
        }
        dangerService.createDanger(dangerName, dangerLevel);

        return "redirect:/danger";
    }
}
