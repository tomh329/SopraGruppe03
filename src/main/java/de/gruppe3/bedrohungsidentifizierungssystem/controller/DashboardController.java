package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.DangerRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RequirementRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.DangerService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DashboardController {


    @Autowired
    DangerService dangerService;
    @Autowired
    DangerRepository dangerRepository;
    @Autowired
    RequirementRepository requirementRepository;
    @Autowired
    RequirementService requirementService;


    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }

    @PostMapping("/process")
    public String navigateToProcess() {
        return "redirect:/process";
    }


    @PostMapping("/component")
    public String navigateToComponent() {
        return "redirect:/component";
    }

    @PostMapping("/setup")
    public String setup(){

        List<Danger> dangerList = dangerRepository.findAll();
        List<Requirement> requirementList = requirementRepository.findAll();

        for(Requirement requirement : requirementList){

            if(requirement.getRequirementId() == 1){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 1){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 3){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 4){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 2){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 1){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 2){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 3){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 4){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 5){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 3){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 1){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 2){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 4){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 4){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 1){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 8){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }

                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 5){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 6){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 7){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 8){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 6){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 1){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 7){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 8){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 7){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 3){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 6){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 8){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 2){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 9){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 2){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 10){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 4){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 11){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 4){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 12){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 3){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 13){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 4){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 14){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 5){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 15){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 4){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 16){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 3){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 4){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 18){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 1){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 4){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 19){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 1){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 2){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if(requirement.getRequirementId() == 20){
                for(Danger danger : dangerList){

                    if(danger.getDangerId() == 1){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if(danger.getDangerId() == 3){

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }


        }


        return "dashboard";
    }


}
