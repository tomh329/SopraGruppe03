package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {

    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    RequirementRepository requirementRepository;

    public Component saveComponent(Component component) {

        return componentRepository.save(component);
    }

    public List<Component> findAllComponents() {

        return componentRepository.findAll();
    }

    public Component createComponent(String componentName, int priority, String lastAttack, int occurrence, int requirementId){

        Component component = new Component(componentName, priority, lastAttack, occurrence);
        List<Requirement> requirementList = requirementRepository.findAll();

        for(Requirement requirement : requirementList){

            if (requirementId == requirement.getRequirementId()) {

                component.addRequirement(requirement);
            }
        }

        return componentRepository.save(component);
    }

    public void deleteComponent(Component component){

        componentRepository.delete(component);
    }
}
