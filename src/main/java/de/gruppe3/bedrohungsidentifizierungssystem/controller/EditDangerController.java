package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.service.DangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditDangerController {

    @GetMapping("/editDanger")
    public String showEditDanger() {

        return "editDanger";
    }

    @Autowired
    private DangerService dangerService;


    @PostMapping("/editDanger/{dangerId}")
    public String updateComponent(@PathVariable String dangerId,
                                  @RequestParam (name = "dangerName") String dangerName,
                                  @RequestParam (name = "dangerLevel") String dangerLevel){
        dangerService.updateDanger(Integer.parseInt(dangerId),dangerName,Integer.parseInt(dangerLevel));

        return "redirect:/danger";
    }
}
