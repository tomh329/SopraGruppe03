package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.*;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ActionRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RequirementRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    private UserRepository userRepository;
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

    public List<Action> findToDoActionsForUser(String username) {
        List<Action> resultActionList = new ArrayList<>();
        List<Action> actionList = findAllActions();
        User currentUser = userRepository.findByUsername(username);

        for (Action action : actionList) {
            if (!(action.getComponent() == null)) {
                for (User user : action.getComponent().getUsers()) {
                    if (!action.getStatus() && user.equals(currentUser)) {
                        resultActionList.add(action);
                    }
                }
            }
        }

        return resultActionList;
    }

    public List<Action> findDoneActionsForUser(String username) {
        List<Action> resultActionList = new ArrayList<>();
        List<Action> actionList = findAllActions();
        User currentUser = userRepository.findByUsername(username);

        for (Action action : actionList) {
            if (!(action.getComponent() == null)) {
                for (User user : action.getComponent().getUsers()) {
                    if (action.getStatus() && user.equals(currentUser)) {
                        resultActionList.add(action);
                    }
                }
            }


        }


        return resultActionList;
    }


    public Action createAction(String actionName, String actionDueDate, int protectionNeeds) {

        Action action = new Action(actionName, actionDueDate, protectionNeeds);

        return actionRepository.save(action);
    }


    public void deleteAction(Action action) {

        actionRepository.delete(action);
    }

    public boolean deleteAction(int actionId) {

        List<Action> actionList = actionRepository.findAll();

        for (Action action : actionList) {
            if (actionId == action.getActionId()) {

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

        for (Action action : actionList) {
            if (actionId == action.getActionId()) {
                action.setActionName(actionName);
                action.setActionDueDate(actionDueDate);
                action.setProtectionNeeds(protectionNeeds);
                actionRepository.save(action);
            }
        }
    }
}


