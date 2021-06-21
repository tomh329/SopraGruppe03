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


        Requirement testReq1 = new Requirement("testReq1");


        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component testComponent1
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("testComp1", 2, "Date", 5);
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component testComponent2
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("testComp2", 10, "Date", 3);


        Process testProcess1 = new Process("Test1", 3);
        Process testProcess2 = new Process("Test2", 1);
        testProcess1.setProcessName("ÄnderungsTest");

        /*
        ether you start with a component that to add to a process
        or you start with a process and pick the component you want to add
         */
//        testComponent1.setProcess(testProcess1);
//        testComponent2.setProcess(testProcess1);
        testProcess1.addComponent(testComponent1);
        testProcess1.addComponent(testComponent2);

        processService.saveProcess(testProcess1);
        processService.saveProcess(testProcess2);
        componentService.saveComponent(testComponent1);
        componentService.saveComponent(testComponent2);
        requirementService.saveRequirement(testReq1);

    }
}