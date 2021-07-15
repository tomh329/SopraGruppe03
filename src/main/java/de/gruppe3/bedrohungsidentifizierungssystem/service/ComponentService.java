package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.*;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ProcessRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {

    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    ProcessRepository processRepository;
    @Autowired
    RequirementRepository requirementRepository;



    public void updateComponent(int componentId, String componentName, String lastAttack, int occurrence, int priority) {

        List<Component> componentList = componentRepository.findAll();

        for(Component component : componentList){
            if(componentId == component.getComponentId()){
                component.setComponentName(componentName);
                component.setLastAttack(lastAttack);
                component.setOccurrence(occurrence);
                component.setPriority(priority);

                componentRepository.save(component);
            }
        }
    }

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


    public Component createComponent(String componentName, int priority, String lastAttack, int occurrence){

        Component component = new Component(componentName, priority, lastAttack, occurrence);


        processRepository.findByProcessId(1).addComponent(component);


        return componentRepository.save(component);
    }


    public void deleteComponent(Component component) {

        componentRepository.delete(component);
    }

    public boolean deleteComponent(int componentId){

        List<Component> componentList = componentRepository.findAll();

        for(Component component : componentList){
            if(componentId == component.getComponentId()){
                for(Requirement requirement : component.getRequirements()){
                    requirement.setComponent(null);
                }
                for(Action action : component.getActions()){
                    action.setComponent(null);
                }
                for(User user : component.getUsers()){
                    user.removeComponent(component);
                }

                componentRepository.delete(component);
                return true;
            }
        }
        return false;
    }


    public Component findComponentWithId(Integer componentId) {
        return componentRepository.findByComponentId(componentId);
    }
}
