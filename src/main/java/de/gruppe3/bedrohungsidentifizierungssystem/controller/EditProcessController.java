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

    @PostMapping("/editProcess/{processId}")
    public String updateProcess(@PathVariable String processId,
                                @RequestParam (name = "processName", required = false) String processName,
                                @RequestParam (name = "protectionLevel", defaultValue = "0") int protectionLevel) {
        processService.updateProcess(Integer.parseInt(processId), processName, protectionLevel);

        return "redirect:/process";
    }
}
