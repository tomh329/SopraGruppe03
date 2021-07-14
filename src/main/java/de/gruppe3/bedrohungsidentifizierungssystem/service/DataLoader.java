package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.controller.AddDangerController;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.*;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    @Autowired
    private AddDangerController addDangerController;

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


        //example process
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Process orpOrgPers = new Process("ORP: Organisation und Personal", 3);
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Process testProcess1 = new Process("Test1", 3);
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Process testProcess2 = new Process("Test2", 1);
        testProcess1.setProcessName("ÄnderungsTest");


        //example component
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component compOrg
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("ORP.1Organisation", 1, "2021-04-11", 3);
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component compPers
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("ORP.2Personal", 3, "2021-02-23", 7);
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component testComponent1
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("testComp1", 2, "2021-03-23", 5);
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component testComponent2
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("testComp2", 4, "2021-04-11", 3);

        //example requirement
        Requirement reqOrg11 = new Requirement("Festlegung von Verantwortlichkeiten");
        Requirement reqOrg12 = new Requirement("Zuweisung der Zuständigkeiten");
        Requirement reqOrg13 = new Requirement("Beaufsichtigung von Fremdpersonen");

        Requirement reqPers11 = new Requirement("Einarbeitung neuer Mitarbeiter");
        Requirement reqPers12 = new Requirement("Festlegung von Vertretungsregelungen");
        Requirement reqPers13 = new Requirement("Qualifikation des Personals");

        Requirement testReq1 = new Requirement("testReq1");

        //example danger
        Danger spionage = new Danger("Spionage", 3);
        Danger diebstahl = new Danger("Diebstahl von Geräten/Dokumenten", 5);
        Danger fehlplanung = new Danger("Fehlplanung", 2);
        Danger manipulation = new Danger("Manipulation", 4);
        Danger ausfall = new Danger("Ausfall von Geräten/System", 1);
        Danger identitaetsdieebstahl = new Danger("Identitätsdieebstahl", 6);
        Danger missbrauchPersDaten = new Danger("Missbrauch personenbezogener Daten", 6);
        Danger verstoss = new Danger("Verstoß gegen Gesetzte/Regeln", 4);

        Danger testDanger1 = new Danger("testDanger1", 3);

        //example action
        Action testAction1 = new Action("testMaßnahme1", "2021-08-17", 3);
        Action testAction2 = new Action("testMaßnahme2", "2021-10-23", 1);
        testAction2.setStatus(true);

        /*
        ether you start with a component and add that to a process you pick
        or you start with a process and pick the component you want to add
         */
//        testComponent1.setProcess(testProcess1);
//        testComponent2.setProcess(testProcess1);



        orpOrgPers.addComponent(compOrg);
        orpOrgPers.addComponent(compPers);
        testProcess1.addComponent(testComponent1);
        testProcess1.addComponent(testComponent2);

        compOrg.addRequirement(reqOrg11);
        compOrg.addRequirement(reqOrg12);
        compOrg.addRequirement(reqOrg13);
        compPers.addRequirement(reqPers11);
        compPers.addRequirement(reqPers12);
        compPers.addRequirement(reqPers13);
        testComponent1.addRequirement(testReq1);


//        reqOrg11.getDangers().add(spionage);
//        reqOrg11.getDangers().add(fehlplanung);
//        reqOrg11.getDangers().add(manipulation);
//
//        reqOrg12.getDangers().add(spionage);
//        reqOrg12.getDangers().add(diebstahl);
//        reqOrg12.getDangers().add(fehlplanung);
//        reqOrg12.getDangers().add(manipulation);
//        reqOrg12.getDangers().add(ausfall);
//
//        reqOrg13.getDangers().add(spionage);
//        reqOrg13.getDangers().add(diebstahl);
//        reqOrg13.getDangers().add(manipulation);
//
//        reqPers11.getDangers().add(spionage);
//        reqPers11.getDangers().add(verstoss);
//
//        reqPers12.getDangers().add(identitaetsdieebstahl);
//        reqPers12.getDangers().add(missbrauchPersDaten);
//        reqPers11.getDangers().add(verstoss);
//
//        reqPers13.getDangers().add(spionage);
//        reqPers13.getDangers().add(missbrauchPersDaten);
//        reqPers11.getDangers().add(verstoss);
//        testReq1.addDanger(testDanger1);



        processService.saveProcess(orpOrgPers);
        processService.saveProcess(testProcess1);
        processService.saveProcess(testProcess2);

        componentService.saveComponent(compOrg);
        componentService.saveComponent(compPers);
        componentService.saveComponent(testComponent1);
        componentService.saveComponent(testComponent2);

        requirementService.saveRequirement(reqOrg11);
        requirementService.saveRequirement(reqOrg12);
        requirementService.saveRequirement(reqOrg13);
        requirementService.saveRequirement(reqPers11);
        requirementService.saveRequirement(reqPers12);
        requirementService.saveRequirement(reqPers13);
        requirementService.saveRequirement(testReq1);

        dangerService.saveDanger(spionage);
        dangerService.saveDanger(diebstahl);
        dangerService.saveDanger(fehlplanung);
        dangerService.saveDanger(manipulation);
        dangerService.saveDanger(ausfall);
        dangerService.saveDanger(identitaetsdieebstahl);
        dangerService.saveDanger(missbrauchPersDaten);
        dangerService.saveDanger(verstoss);
        dangerService.saveDanger(testDanger1);

        actionService.saveAction(testAction1);
        actionService.saveAction(testAction2);
    }
}