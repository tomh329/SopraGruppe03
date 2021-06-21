package de.gruppe3.bedrohungsidentifizierungssystem.service;

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

    public List<Requirement> findAllRequirements() {

        return requirementRepository.findAll();
    }
}