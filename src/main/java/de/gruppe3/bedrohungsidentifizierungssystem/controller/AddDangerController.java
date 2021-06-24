package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.DangerRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RequirementRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.DangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddDangerController {


    @GetMapping("/addDanger")
    public String showAddDanger() {

        return "addDanger";
    }


    @Autowired
    DangerService dangerService;
    @Autowired
    DangerRepository dangerRepository;
    @Autowired
    RequirementRepository requirementRepository;

    @PostMapping("/addDanger")
    public String add(@RequestParam(name = "requirementId") int requirementId,
                      @RequestParam (name = "dangerId") int dangerId){

        List<Danger> dangerList = dangerRepository.findAll();
        List<Requirement> requirementList = requirementRepository.findAll();

        for(Requirement requirement : requirementList){
            if(requirementId==requirement.getRequirementId()){
                for(Danger danger : dangerList){
                    if(dangerId==danger.getDangerId()){
                        danger.setRequirement(requirement);
                        dangerService.saveDanger(danger);
                        return "redirect:/requirement";
                    }
                }
            }
        }

        System.out.println("No Success");
        return "redirect:/requirement";
    }
}
