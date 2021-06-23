package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Action;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Role;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.LinkedList;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);


    @Autowired
    private ProcessService processService;

    @Autowired
    private UserService userService;

    @Autowired
    private ActionService actionService;

    /**
     * Diese Methode wird zum Aufsetzen von Testdaten für die Datenbank verwendet werden. Die Methode wird immer dann
     * ausgeführt, wenn der Spring Kontext initialisiert wurde, d.h. wenn Sie Ihren Server (neu-)starten.
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("Initialisiere Datenbank mit Testdaten...");

        // Initialisieren Sie Beispielobjekte und speichern Sie diese über Ihre Services

        Process normalProcess = new Process();
        normalProcess.setProcessName("NormalProzess");
        normalProcess.setProtectionLevel("Hoch");
        processService.saveProcess(normalProcess);

        User testAdmin = new User();
        testAdmin.setUsername("Max");
        testAdmin.setPassword("1234");
        testAdmin.setActions(new LinkedList<Action>());
        userService.saveUser(testAdmin);

        User normalEmployee = new User();
        normalEmployee.setUsername("Paule");
        normalEmployee.setPassword("2345");
        normalEmployee.setActions(new LinkedList<Action>());
        userService.saveUser(normalEmployee);

    }
}