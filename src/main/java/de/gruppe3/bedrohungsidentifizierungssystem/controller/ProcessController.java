package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @GetMapping("/process")
    public String showProcess(Model model) {

        model.addAttribute("processes", processService.findAllProcesses());
        return "process";
    }

    @PostMapping("/createProcessButton")
    public String create(){
        return "redirect:/createProcess";
    }

    @PostMapping("/addComponentButton")
    public String add(){
        return "redirect:/addComponent";
    }
}