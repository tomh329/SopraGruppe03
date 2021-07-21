package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProcessController {

    @Autowired
    private ProcessService processService;
    @Autowired
    private UserService userService;

    @GetMapping("/process")
    public String showProcess(Model model) {

        model.addAttribute("processes", processService.findAllProcesses());
        return "process";
    }

    @PostMapping("/deleteProcess/{processId}")
    public String deleteProcess(@PathVariable String processId) {
        processService.deleteProcess(Integer.parseInt(processId));
        return "redirect:/process";
    }

    @PostMapping("/createProcessButton")
    public String create() {
        return "redirect:/createProcess";
    }

    @PostMapping("/addComponentButton")
    public String add(@RequestParam(name = "processId") String processId,
                      Model model, final RedirectAttributes redirectAttributes) {

        Process processToAdd = processService.findProcessWithId(Integer.parseInt(processId));
        redirectAttributes.addFlashAttribute("processToAdd", processToAdd);
        return "redirect:/addComponent";
    }

    @PostMapping("/removeComponentButton/{componentId}")
    public String removeComponent(@PathVariable String componentId) {

        processService.removeComponent(Integer.parseInt(componentId));
        return "redirect:/process";
    }

    @PostMapping({"/process/{processId}"})
    public String showEditProcess(Model model, @PathVariable String processId) {
        model.addAttribute("editProcess", processService.findProcessWithId(Integer.parseInt(processId)));
        model.addAttribute("process", processService.findProcessWithId(Integer.parseInt(processId)));
        return "editProcess";
    }
}
