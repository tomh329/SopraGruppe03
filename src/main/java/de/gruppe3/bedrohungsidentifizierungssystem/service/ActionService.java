package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Action;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ActionRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    RequirementRepository requirementRepository;



//    public void updateComponent(int componentId, String componentName, String lastAttack, int occurrence, int priority) {
//
//        List<Component> componentList = componentRepository.findAll();
//
//        for(Component component : componentList){
//            if(componentId == component.getComponentId()){
//                component.setComponentName(componentName);
//                component.setLastAttack(lastAttack);
//                component.setOccurrence(occurrence);
//                component.setPriority(priority);
//
//                componentRepository.save(component);
//            }
//        }
//    }

    public Action saveAction(Action action) {

        return actionRepository.save(action);
    }

    public List<Action> findAllActions() {

        return actionRepository.findAll();
    }



    public Action createAction(String actionName, String actionDueDate, int protectionNeeds){

        Action action = new Action(actionName, actionDueDate, protectionNeeds);

        return actionRepository.save(action);
    }


    public void deleteAction(Action action) {

        actionRepository.delete(action);
    }

    public boolean deleteAction(int actionId){

        List<Action> actionList = actionRepository.findAll();

        for(Action action : actionList){
            if(actionId == action.getActionId()){

                actionRepository.delete(action);
                return true;
            }
        }
        return false;
    }


    public Action findActionWithId(Integer actionId) {
        return actionRepository.findByActionId(actionId);
    }

    public void updateAction(int actionId, String actionName, String actionDueDate, int protectionNeeds) {

        List<Action> actionList = findAllActions();

        for(Action action : actionList){
            if(actionId == action.getActionId()){
                action.setActionName(actionName);
                action.setActionDueDate(actionDueDate);
                action.setProtectionNeeds(protectionNeeds);
                actionRepository.save(action);
            }
        }
    }
}


