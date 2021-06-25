package de.gruppe3.bedrohungsidentifizierungssystem.controller;


import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ComponentController {


    @Autowired
    ComponentService componentService;

    @GetMapping("/component")
    public String showComponent(Model model) {

        model.addAttribute("components", componentService.findAllComponents());
        return "component";
    }

    @PostMapping("/createComponentButton")
    public String create(){
        return "redirect:/createComponent";
    }

    @PostMapping("/addRequirementButton")
    public String add(){
        return "redirect:/addRequirement";
    }

    @PostMapping({"/component/{componentId}"})
    public String showEditComponent(Model model, @PathVariable String componentId) {
        model.addAttribute("editComponent", componentService.findComponentWithId(Integer.parseInt(componentId)));
        return "editComponent";
    }

    @PostMapping("/deleteComponent/{componentId}")
    public String deleteProcess(@PathVariable String componentId) {
        System.out.println(
                componentService.deleteComponent(Integer.parseInt(componentId))
        );
        return "redirect:/component";
    }

}
