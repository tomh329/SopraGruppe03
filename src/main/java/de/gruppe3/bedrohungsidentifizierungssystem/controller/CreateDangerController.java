package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.service.DangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateDangerController {

    @GetMapping("/createDanger")
    public String showCreateDanger() {

        return "createDanger";
    }

    @Autowired
    private DangerService dangerService;


    @PostMapping("/createDanger")
    public String create(@RequestParam(name = "dangerName") String dangerName,
                         @RequestParam(name = "dangerLevel") int dangerLevel) {

        dangerService.createDanger(dangerName, dangerLevel);

        return "redirect:/danger";
    }
}
