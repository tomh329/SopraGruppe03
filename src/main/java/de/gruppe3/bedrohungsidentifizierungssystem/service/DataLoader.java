package de.gruppe3.bedrohungsidentifizierungssystem.service;

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

    /**
     * Diese Methode wird zum Aufsetzen von Testdaten für die Datenbank verwendet werden. Die Methode wird immer dann
     * ausgeführt, wenn der Spring Kontext initialisiert wurde, d.h. wenn Sie Ihren Server (neu-)starten.
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("Initialisiere Datenbank mit Testdaten...");

        // Initialisieren Sie Beispielobjekte und speichern Sie diese über Ihre Services

        //creation of role admin
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        List<User> admins = new LinkedList<>();
        adminRole.setUser(admins);
        roleService.saveRole(adminRole);

        //creation of role IT security officer
        Role itSecurityOfficerRole = new Role();
        itSecurityOfficerRole.setRole("IT_SECURITY_OFFICER");
        List<User> itSecurityOfficers = new LinkedList<>();
        adminRole.setUser(itSecurityOfficers);
        roleService.saveRole(itSecurityOfficerRole);

        //creation of role manager
        Role managerRole = new Role();
        managerRole.setRole("MANAGER");
        List<User> managers = new LinkedList<>();
        managerRole.setUser(managers);
        roleService.saveRole(managerRole);

        //creation of role employee
        Role employeeRole = new Role();
        employeeRole.setRole("EMPLOYEE");
        List<User> employees = new LinkedList<>();
        employeeRole.setUser(employees);
        roleService.saveRole(employeeRole);


        //Creation of user Max
        User userMax = new User();
        userMax.setUsername("Max");
        userMax.setPassword("12345");
        userMax.setRole(adminRole);
        userService.saveUser(userMax);

        //Creation of user Paula
        User userPaula = new User();
        userPaula.setUsername("Paula");
        userPaula.setPassword("12345");
        userPaula.setRole(adminRole);

        //Creation of user Paule
        User userPaule = new User();
        userPaule.setUsername("Paule");
        userPaule.setPassword("23456");
        userPaule.setRole(employeeRole);
        userService.saveUser(userPaule);
    }
}