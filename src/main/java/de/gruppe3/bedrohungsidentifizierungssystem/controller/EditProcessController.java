package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
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
public class EditProcessController {

    @GetMapping("/editProcess")
    public String showEditProcess(Process process, BindingResult bindingResult, Model model) {
        model.addAttribute("editProcess",process);
        return "editProcess";
    }

    @Autowired
    private ProcessService processService;

    @Autowired
    ComponentRepository componentRepository;

    @PostMapping("/editProcess/{processId}")
    public String updateProcess(@PathVariable String processId,
                                @RequestParam(name = "processName") String processName,
                                @RequestParam(name = "protectionLevel") int protectionLevel,
                                @Valid Process process, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()) {
            model.addAttribute("editProcess",process);
            return "/editProcess";
        }

        processService.updateProcess(Integer.parseInt(processId), processName, protectionLevel);

        return "redirect:/process";
    }
}
