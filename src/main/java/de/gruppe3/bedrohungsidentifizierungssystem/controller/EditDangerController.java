package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
import de.gruppe3.bedrohungsidentifizierungssystem.service.DangerService;
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
public class EditDangerController {

    @GetMapping("/editDanger")
    public String showEditDanger(Danger danger, Danger editDanger, BindingResult bindingResult, Model model) {
        model.addAttribute("danger", danger);
        model.addAttribute("editDanger", editDanger);
        return "editDanger";
    }

    @Autowired
    private DangerService dangerService;


    @PostMapping("/editDanger/{dangerId}")
    public String updateComponent(@PathVariable String dangerId,
                                  @RequestParam(name = "dangerName") String dangerName,
                                  @RequestParam(name = "dangerLevel") String dangerLevel,
                                  @Valid Danger danger, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("danger", danger);
            model.addAttribute("editDanger", dangerService.findProcessWithId(Integer.parseInt(dangerId)));
            return "/editDanger";
        }
        dangerService.updateDanger(Integer.parseInt(dangerId), dangerName, Integer.parseInt(dangerLevel));

        return "redirect:/danger";
    }
}
