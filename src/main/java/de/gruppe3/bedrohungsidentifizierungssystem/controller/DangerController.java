package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.service.DangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DangerController {

    @Autowired
    private DangerService dangerService;

    @GetMapping("/danger")
    public String showProcess(Model model) {

        model.addAttribute("dangers", dangerService.findAllDangers());
        return "danger";
    }

    @PostMapping("/deleteDanger/{dangerId}")
    public String deleteProcess(@PathVariable String dangerId) {
        System.out.println(
                dangerService.deleteDanger(Integer.parseInt(dangerId))
        );
        return "redirect:/danger";
    }

    @PostMapping("/createDangerButton")
    public String create() {
        return "redirect:/createDanger";
    }


    @PostMapping({"/danger/{dangerId}"})
    public String showEditDanger(Model model, @PathVariable String dangerId) {
        model.addAttribute("editDanger", dangerService.findProcessWithId(Integer.parseInt(dangerId)));
        return "editDanger";
    }
}
