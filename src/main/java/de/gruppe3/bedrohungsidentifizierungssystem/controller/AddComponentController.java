package de.gruppe3.bedrohungsidentifizierungssystem.controller;


import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ProcessRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddComponentController {


    @GetMapping("/addComponent")
    public String showAddComponent() {

        return "addComponent";
    }


    @Autowired
    ComponentService componentService;
    @Autowired
    ComponentRepository componentRepository;
    @Autowired
    ProcessRepository processRepository;

    @PostMapping("/addComponent")
    public String add(@RequestParam(name = "processId") int processId,
                         @RequestParam (name = "componentId") int componentId){

        List<Component> componentList = componentRepository.findAll();
        List<Process> processList = processRepository.findAll();

        for(Process process : processList){
            if(processId==process.getProcessId()){
                for(Component component : componentList){
                    if(componentId==component.getComponentId()){
                        component.setProcess(process);
                        componentService.saveComponent(component);
                        return "redirect:/process";
                    }
                }
            }
        }

        System.out.println("No Success");
        return "redirect:/process";
    }
}
