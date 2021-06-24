package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Role;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import de.gruppe3.bedrohungsidentifizierungssystem.service.RoleService;
import de.gruppe3.bedrohungsidentifizierungssystem.service.UserService;
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

        //creation of Role admin
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        List<User> adminUsers = new LinkedList<>();
        adminRole.setUser(adminUsers);
        roleService.saveRole(adminRole);
        //creation of Role Employee
        Role employeeRole = new Role();
        employeeRole.setRole("EMPLOYEE");
        List<User> employeeUsers = new LinkedList<>();
        employeeRole.setUser(employeeUsers);
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
        userService.saveUser(userPaula);
        //Creation of user Paule
        User userPaule = new User();
        userPaule.setUsername("Paule");
        userPaule.setPassword("23456");
        userPaule.setRole(employeeRole);
        userService.saveUser(userPaule);
    }
}