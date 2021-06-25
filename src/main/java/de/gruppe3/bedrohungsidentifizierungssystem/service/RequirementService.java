package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RequirementService {

    @Autowired
    private RequirementRepository requirementRepository;

    public Requirement saveRequirement(Requirement requirement) {

        return requirementRepository.save(requirement);
    }


    public Requirement createRequirement(String requirementName){
        Requirement requirement = new Requirement(requirementName);
        return requirementRepository.save(requirement);
    }

    public void updateRequirement(int requirementId, String requirementName) {

        List<Requirement> requirementList = requirementRepository.findAll();

        for(Requirement requirement : requirementList){
            if(requirementId == requirement.getRequirementId()){
                requirement.setRequirementName(requirementName);
                requirementRepository.save(requirement);
            }
        }
    }

    public void deleteRequirement(Requirement requirement){
        requirementRepository.delete(requirement);
    }

    public boolean deleteRequirement(int requirementId){

        List<Requirement> requirementList = requirementRepository.findAll();

        for(Requirement requirement : requirementList){
            if(requirementId == requirement.getRequirementId()){
                for(Danger danger : requirement.getDangers()){
                    danger.setRequirement(null);
                }
                requirementRepository.delete(requirement);
                return true;
            }
        }
        return false;
    }

    public List<Requirement> findAllRequirements() {

        return requirementRepository.findAll();
    }


    public Requirement findRequirementWithId(Integer requirementId) {
        return requirementRepository.findByRequirementId(requirementId);
    }
}
