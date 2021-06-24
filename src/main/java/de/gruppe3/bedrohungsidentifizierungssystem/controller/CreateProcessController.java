package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateProcessController {

    @GetMapping("/createProcess")
    public String showCreateProcess() {

        return "createProcess";
    }

    @Autowired
    private ProcessService processService;
    @Autowired
    ComponentRepository componentRepository;

    @PostMapping("/createProcess")
    public String create(@RequestParam(name = "processName") String processName,
                         @RequestParam (name = "protectionLevel") int protectionLevel,
                         @RequestParam (name = "componentId") int componentId){

        processService.createProcess(processName, protectionLevel, componentId);

        System.out.println(processName);
        System.out.println(protectionLevel);
        System.out.println(componentId);

        return "redirect:/process";
    }
}
