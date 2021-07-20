package de.gruppe3.bedrohungsidentifizierungssystem.controller;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Action;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ActionService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ComponentService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/dashboard")
    public String showDashboard(Model model) throws ParseException {

        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = ((UserDetails)principal).getUsername();

        int trafficLight=2;

        //Simple numbers
        int toDoActions = actionService.findToDoActionsForUser(username).size();
        int doneActions = actionService.findDoneActionsForUser(username).size();
        int countComponents = componentService.findAllComponents().size();
        int countProcesses = processService.findAllProcesses().size();

        //Chart data
        ArrayList<String> usernameList = new ArrayList<>();
        ArrayList<Integer> numberOfDoneTasks = new ArrayList<>();
        List<User> userList = userService.findAllUsers();
        for(int i=0; i<userList.size(); i++){
            usernameList.add(userList.get(i).getUsername());
        }
        for(int i=0; i<userList.size(); i++){
            numberOfDoneTasks.add(actionService.findDoneActionsForUser(userList.get(i).getUsername()).size());
        }

        //TrafficLightData
        List<Action> actionsToDo = actionService.findToDoActionsForUser(username);

        Calendar calender = Calendar.getInstance();
        Date todayDate = calender.getTime();
        calender.add(calender.DATE,7);
        Date todayDateSevenDays = calender.getTime();
        System.out.println(todayDate);
        System.out.println(todayDateSevenDays);

        for(Action action : actionsToDo){
            String dueDateString = action.getActionDueDate();
            System.out.println(dueDateString);
            SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
            Date dueDate = formatter.parse(dueDateString);
            System.out.println(dueDate);
            if(todayDate.after(dueDate)){
                trafficLight=0;
            }
            if(todayDateSevenDays.after(dueDate)&&trafficLight==2){
                trafficLight=1;
            }

        }



        model.addAttribute("toDoActions", Integer.toString(toDoActions));
        model.addAttribute("doneActions", Integer.toString(doneActions));
        model.addAttribute("countComponents", Integer.toString(countComponents));
        model.addAttribute("countProcesses", Integer.toString(countProcesses));
        model.addAttribute("usernameList", usernameList);
        model.addAttribute("userDoneTaskList", numberOfDoneTasks);
        model.addAttribute("trafficLightNumber", trafficLight);
        return "dashboard";
    }


}
