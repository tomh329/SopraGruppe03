package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CreateProcessController {

    @GetMapping("/createProcess")
    public String showCreateProcess(Process process, BindingResult bindingResult, Model model) {
        model.addAttribute("process",process);
        return "createProcess";
    }

    @Autowired
    private ProcessService processService;
    @Autowired
    ComponentRepository componentRepository;

    @PostMapping("/createProcess")
    public String create(@RequestParam(name = "processName") String processName,
                         @RequestParam(name = "protectionLevel") String protectionLevel,
                         @Valid Process process, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("process",process);
            return "/createProcess";

        }


        processService.createProcess(processName, Integer.parseInt(protectionLevel));

        System.out.println(processName);
        System.out.println(protectionLevel);

        return "redirect:/process";
    }

}
