package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);


    @Autowired
    private ProcessService processService;
    @Autowired
    private ComponentService componentService;
    @Autowired
    private RequirementService requirementService;

    /**
     * Diese Methode wird zum Aufsetzen von Testdaten für die Datenbank verwendet werden. Die Methode wird immer dann
     * ausgeführt, wenn der Spring Kontext initialisiert wurde, d.h. wenn Sie Ihren Server (neu-)starten.
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("Initialisiere Datenbank mit Testdaten...");

        // Initialisieren Sie Beispielobjekte und speichern Sie diese über Ihre Services

        Process testProcess1 = new Process("Test1", 3, 1);
        Process testProcess2 = new Process("Test2", 1, 1);
        processService.saveProcess(testProcess1);
        processService.saveProcess(testProcess2);

        Requirement testReq1 = new Requirement("testReq1");
        requirementService.saveRequirement(testReq1);


        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component testComponent1
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("testComp", 2, "Date", 5);
        componentService.saveComponent(testComponent1);

    }
}