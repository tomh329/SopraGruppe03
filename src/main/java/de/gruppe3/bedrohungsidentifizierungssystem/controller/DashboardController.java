package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Action;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.DangerRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RequirementRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    ActionService actionService;
    @Autowired
    ComponentService componentService;
    @Autowired
    ProcessService processService;
    @Autowired
    UserService userService;

    @Autowired
    DangerService dangerService;
    @Autowired
    DangerRepository dangerRepository;
    @Autowired
    RequirementRepository requirementRepository;
    @Autowired
    RequirementService requirementService;


    @GetMapping("/dashboard")
    public String showDashboard(Model model) throws ParseException {

        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = ((UserDetails) principal).getUsername();

        int trafficLight = 2;

        //Simple numbers
        int toDoActions = actionService.findToDoActionsForUser(username).size();
        int doneActions = actionService.findDoneActionsForUser(username).size();
        int countComponents = componentService.findAllComponents().size();
        int countProcesses = (processService.findAllProcesses().size()-1);

        //Chart data
        ArrayList<String> usernameListSorted = new ArrayList<>();
        ArrayList<Integer> numberOfDoneTasks = new ArrayList<>();
        ArrayList<Integer> numberOfDoneTasksSorted = new ArrayList<>();
        List<User> userList = userService.findAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            numberOfDoneTasks.add(actionService.findDoneActionsForUser(userList.get(i).getUsername()).size());
        }

        int userCount = 6;
        if (userList.size() < 6) {
            userCount = userList.size();
        }
        for (int i = 0; i < userCount; i++) {
            int highestAmount = -1;
            int highestUsername = 0;
            for (int j = 0; j < numberOfDoneTasks.size(); j++) {
                if (numberOfDoneTasks.get(j) > highestAmount) {
                    highestAmount = numberOfDoneTasks.get(j);
                    highestUsername = j;
                }
            }
            usernameListSorted.add(userList.get(highestUsername).getUsername());
            numberOfDoneTasksSorted.add(numberOfDoneTasks.get(highestUsername));
            numberOfDoneTasks.set(highestUsername, 0);
        }


        //TrafficLightData
        List<Action> actionsToDo = actionService.findToDoActionsForUser(username);

        Calendar calender = Calendar.getInstance();
        Date todayDate = calender.getTime();
        calender.add(calender.DATE, 7);
        Date todayDateSevenDays = calender.getTime();

        for (Action action : actionsToDo) {
            String dueDateString = action.getActionDueDate();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dueDate = formatter.parse(dueDateString);
            if (todayDate.after(dueDate)) {
                trafficLight = 0;
            }
            if (todayDateSevenDays.after(dueDate) && trafficLight == 2) {
                trafficLight = 1;
            }

        }


        model.addAttribute("toDoActions", Integer.toString(toDoActions));
        model.addAttribute("doneActions", Integer.toString(doneActions));
        model.addAttribute("countComponents", Integer.toString(countComponents));
        model.addAttribute("countProcesses", Integer.toString(countProcesses));
        model.addAttribute("usernameList", usernameListSorted);
        model.addAttribute("userDoneTaskList", numberOfDoneTasksSorted);
        model.addAttribute("trafficLightNumber", trafficLight);
        return "dashboard";
    }

    @PostMapping("/setup")
    public String setup() {

        List<Danger> dangerList = dangerRepository.findAll();
        List<Requirement> requirementList = requirementRepository.findAll();

        for (Requirement requirement : requirementList) {

            if (requirement.getRequirementId() == 1) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 1) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 3) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 4) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 2) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 1) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 2) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 3) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 4) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 5) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 3) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 1) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 2) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 4) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 4) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 1) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 8) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }

                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 5) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 6) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 7) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 8) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 6) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 1) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 7) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 8) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 7) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 3) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 6) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 8) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 2) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 9) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 2) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 10) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 4) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 11) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 4) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 12) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 3) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 13) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 4) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 14) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 5) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 15) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 4) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 16) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 3) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 4) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 18) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 1) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 4) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 19) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 1) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 2) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }

            if (requirement.getRequirementId() == 20) {
                for (Danger danger : dangerList) {

                    if (danger.getDangerId() == 1) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    if (danger.getDangerId() == 3) {

                        requirement.getDangers().add(danger);
                        danger.getRequirements().add(requirement);
                    }
                    requirementService.saveRequirement(requirement);
                    dangerService.saveDanger(danger);
                }
            }


        }


        return "redirect:/dashboard";
    }


}
