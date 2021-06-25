package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Role;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ActionService actionService;

    @Autowired
    private ProcessService processService;

    @Autowired
    private ComponentService componentService;

    @Autowired
    private RequirementService requirementService;

    @Autowired
    private DangerService dangerService;

    /**
     * Diese Methode wird zum Aufsetzen von Testdaten für die Datenbank verwendet werden. Die Methode wird immer dann
     * ausgeführt, wenn der Spring Kontext initialisiert wurde, d.h. wenn Sie Ihren Server (neu-)starten.
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("Initialisiere Datenbank mit Testdaten...");

        // Initialisieren Sie Beispielobjekte und speichern Sie diese über Ihre Services

        //creation of role admin
//        Role adminRole = new Role();
//        adminRole.setRole("ADMIN");
//        List<User> admins = new LinkedList<>();
//        adminRole.setUser(admins);
//        roleService.saveRole(adminRole);
//
//        //creation of role IT security officer
//        Role itSecurityOfficerRole = new Role();
//        itSecurityOfficerRole.setRole("IT_SECURITY_OFFICER");
//        List<User> itSecurityOfficers = new LinkedList<>();
//        adminRole.setUser(itSecurityOfficers);
//        roleService.saveRole(itSecurityOfficerRole);
//
//        //creation of role manager
//        Role managerRole = new Role();
//        managerRole.setRole("MANAGER");
//        List<User> managers = new LinkedList<>();
//        managerRole.setUser(managers);
//        roleService.saveRole(managerRole);
//
//        //creation of role employee
//        Role employeeRole = new Role();
//        employeeRole.setRole("EMPLOYEE");
//        List<User> employees = new LinkedList<>();
//        employeeRole.setUser(employees);
//        roleService.saveRole(employeeRole);
//
//
//        //Creation of user Max
//        User userMax = new User();
//        userMax.setUsername("Max");
//        userMax.setPassword("12345");
//        userMax.setRole(adminRole);
//        userService.saveUser(userMax);
//
//        //Creation of user Paula
//        User userPaula = new User();
//        userPaula.setUsername("Paula");
//        userPaula.setPassword("12345");
//        userPaula.setRole(adminRole);
//
//        //Creation of user Paule
//        User userPaule = new User();
//        userPaule.setUsername("Paule");
//        userPaule.setPassword("23456");
//        userPaule.setRole(employeeRole);
//        userService.saveUser(userPaule);
//
//
//        de.gruppe3.bedrohungsidentifizierungssystem.entity.Process testProcess1 = new Process("Test1", 3);
//        de.gruppe3.bedrohungsidentifizierungssystem.entity.Process testProcess2 = new Process("Test2", 1);
//        testProcess1.setProcessName("ÄnderungsTest");
//
//
//
//        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component testComponent1
//                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("testComp1", 2, "Date", 5);
//        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component testComponent2
//                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("testComp2", 10, "Date", 3);
//
//        Requirement testReq1 = new Requirement("testReq1");
//
//        Danger testDanger1 = new Danger("testDanger1", 3);
//
//
//        /*
//        ether you start with a component and add that to a process you pick
//        or you start with a process and pick the component you want to add
//         */
////        testComponent1.setProcess(testProcess1);
////        testComponent2.setProcess(testProcess1);
//
//        testProcess1.addComponent(testComponent1);
//        testProcess1.addComponent(testComponent2);
//        testComponent1.addRequirement(testReq1);
//        testReq1.addDanger(testDanger1);
//
//        processService.saveProcess(testProcess1);
//        processService.saveProcess(testProcess2);
//        componentService.saveComponent(testComponent1);
//        componentService.saveComponent(testComponent2);
//        requirementService.saveRequirement(testReq1);
//        dangerService.saveDanger(testDanger1);

    
    }
}