package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditProcessController {

    @GetMapping("/editProcess")
    public String showEditProcess() {

        return "editProcess";
    }

    @Autowired
    private ProcessService processService;
    @Autowired
    ComponentRepository componentRepository;

    @PostMapping("/editProcess")
    public String create(@RequestParam (name = "processId") int processId,
                         @RequestParam(name = "processName") String processName,
                         @RequestParam (name = "protectionLevel") int protectionLevel,
                         @RequestParam (name = "componentId") int componentId){

        processService.updateProcess(processId, processName, protectionLevel, componentId);

        System.out.println(processName);
        System.out.println(protectionLevel);
        System.out.println(componentId);

        return "redirect:/process";
    }

}
