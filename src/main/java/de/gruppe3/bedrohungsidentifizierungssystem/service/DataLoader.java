package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.controller.AddDangerController;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.*;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
        adminRole.setRole("ROLE_ADMIN");
        List<User> admins = new LinkedList<>();
        adminRole.setUser(admins);
        roleService.saveRole(adminRole);

        //creation of role IT security officer
        Role itSecurityOfficerRole = new Role();
        itSecurityOfficerRole.setRole("ROLE_IT_SECURITY_OFFICER");
        List<User> itSecurityOfficers = new LinkedList<>();
        adminRole.setUser(itSecurityOfficers);
        roleService.saveRole(itSecurityOfficerRole);

        //creation of role manager
        Role managerRole = new Role();
        managerRole.setRole("ROLE_MANAGER");
        List<User> managers = new LinkedList<>();
        managerRole.setUser(managers);
        roleService.saveRole(managerRole);

        //creation of role employee
        Role employeeRole = new Role();
        employeeRole.setRole("ROLE_EMPLOYEE");
        List<User> employees = new LinkedList<>();
        employeeRole.setUser(employees);
        roleService.saveRole(employeeRole);


        //Creation of user Max
        User userMax = new User();
        userMax.setUsername("Max");
        userMax.setPassword("12345");
        userMax.setFirstname("Maximilian");
        userMax.setLastname("Mustermann");
        userMax.setRole(adminRole);
        userMax.setPassword(bCryptPasswordEncoder.encode(userMax.getPassword()));
        userService.saveUser(userMax);

        //Creation of user Paula
        User userPaula = new User();
        userPaula.setUsername("Paula");
        userPaula.setPassword("12345");
        userPaula.setFirstname("Paula");
        userPaula.setLastname("Müller");
        userPaula.setPassword(bCryptPasswordEncoder.encode(userPaula.getPassword()));
        userPaula.setRole(adminRole);
        userService.saveUser(userPaula);

        //Creation of user Paule
        User userPaule = new User();
        userPaule.setUsername("Paule");
        userPaule.setPassword("23456");
        userPaule.setFirstname("Paule");
        userPaule.setLastname("Müller");
        userPaule.setRole(employeeRole);
        userPaule.setPassword(bCryptPasswordEncoder.encode(userPaule.getPassword()));
        userService.saveUser(userPaule);


        //example process
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Process extraProcess = new Process("Kein Prozess", 0);

        de.gruppe3.bedrohungsidentifizierungssystem.entity.Process orpOrgPers = new Process("ORP: Organisation und Personal", 3);
        Process app3 = new Process("APP.3 Netzbasierte Dienste", 3);

//        testProcess1.setProcessId(0);
        Process app1 = new Process("APP.1 Client-Anwendungen", 2);


        //example component
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component compOrg
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("ORP.1Organisation", 1, "2021-04-11", 3);
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component compPers
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("ORP.2Personal", 3, "2021-02-23", 7);
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component app3_1
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("APP.3.1 Webanwendungen", 5, "2019-10-14", 7);
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component app3_2
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("APP.3.2 Webserver", 2, "2020-03-21", 2);
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component app3_6
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("APP.3.6 DNS-Server", 2, "2021-01-26", 4);


        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component app1_1
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("APP.1.1 Office Produkte", 3, "2020-03-07", 7);
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component app1_2
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("APP.1.2 Webbrowser", 4, "2007-08-14", 4);
        de.gruppe3.bedrohungsidentifizierungssystem.entity.Component app1_4
                = new de.gruppe3.bedrohungsidentifizierungssystem.entity.Component("APP.1.4 Mobile Anwendungen(Apps)", 3, "2014-03-17", 9);
        //example requirement
        Requirement reqOrg11 = new Requirement("Festlegung von Verantwortlichkeiten");
        Requirement reqOrg12 = new Requirement("Zuweisung der Zuständigkeiten");
        Requirement reqOrg13 = new Requirement("Beaufsichtigung von Fremdpersonen");

        Requirement reqPers11 = new Requirement("Einarbeitung neuer Mitarbeiter");
        Requirement reqPers12 = new Requirement("Festlegung von Vertretungsregelungen");
        Requirement reqPers13 = new Requirement("Qualifikation des Personals");

        Requirement reqApp3_1_1 = new Requirement("Autentisierung bei Webanwendung");
        Requirement reqApp3_1_2 = new Requirement("Schutz vertraulicher Daten");
        Requirement reqApp3_1_3 = new Requirement("Sichere Anbindung von Hintergrundsystem");

        Requirement reqApp3_2_1 = new Requirement("Sichere Konfiguration eines Webservers");
        Requirement reqApp3_2_2 = new Requirement("Schutz der Webserver-Dateien");

        Requirement reqApp3_6_1 = new Requirement("Planung des DNS-Einsatzes");
        Requirement reqApp3_6_2 = new Requirement("Absicherung von dynamischen DNS-Updates");
        Requirement reqApp3_6_3 = new Requirement("Überwachung von DNS-Server");

        Requirement app_1_1_A2 = new Requirement("Einschränken von Aktiven Inhalten");
        //G 0.19 G 0.22 G. 039
        Requirement app_1_1_A6 = new Requirement("Testen neuer Versionen von Office-Produkten");
        //G 0.18 G 0.20 G 0.28 G 0.45 G0.46

        Requirement app_1_2_A1 = new Requirement("Verwendung von grundlegenden Sicherheitsmechanismen");
        //G 0.23 G0.28 G 0.39
        Requirement app_1_2_A3 = new Requirement("Verwendung von vertrauenswürdigen Zertifikaten");
        //G 0.14 G 0.19 G 0.22 G 0.30

        Requirement app_1_4_A7 = new Requirement("Sichere Speicherung lokaler App-Daten");
        //G 0.14 G0.16 G 0.17 G 0.19
        Requirement app_1_4_A12 = new Requirement("Sichere Deinstallation von Apps");
        //G 0.14 G 0.15 G 0.16 G 0.17



        //example danger
        Danger spionage = new Danger("Spionage", 3);
        Danger diebstahl = new Danger("Diebstahl von Geräten/Dokumenten", 5);
        Danger fehlplanung = new Danger("Fehlplanung", 2);
        Danger manipulation = new Danger("Manipulation", 4);
        Danger ausfall = new Danger("Ausfall von Geräten/System", 1);
        Danger identitaetsdieebstahl = new Danger("Identitätsdieebstahl", 5);
        Danger missbrauchPersDaten = new Danger("Missbrauch personenbezogener Daten", 5);
        Danger verstoss = new Danger("Verstoß gegen Gesetzte/Regeln", 4);


        //example action
        Action testAction1 = new Action("Update durchführen", "2021-08-17", 3);
        Action testAction2 = new Action("IZ-Workshop vorbereiten", "2021-10-23", 1);
        Action trafficRed = new Action("Bewerbungen durchgehen", "2020-10-23", 1);
        Action trafficYellow = new Action("Server warten", "2021-07-23", 1);
        testAction1.setStatus(true);

        testAction1.setComponent(app1_1);
        testAction2.setComponent(compPers);
        trafficRed.setComponent(compPers);
        trafficYellow.setComponent(app3_1);




        /*
        ether you start with a component and add that to a process you pick
        or you start with a process and pick the component you want to add
         */
//        testComponent1.setProcess(testProcess1);
//        testComponent2.setProcess(testProcess1);


        orpOrgPers.addComponent(compOrg);
        orpOrgPers.addComponent(compPers);
        app1.addComponent(app1_1);
        app1.addComponent(app1_2);
        app1.addComponent(app1_4);
        app3.addComponent(app3_1);
        app3.addComponent(app3_2);
        app3.addComponent(app3_6);


        compOrg.addRequirement(reqOrg11);
        compOrg.addRequirement(reqOrg12);
        compOrg.addRequirement(reqOrg13);
        compPers.addRequirement(reqPers11);
        compPers.addRequirement(reqPers12);
        compPers.addRequirement(reqPers13);
        app1_1.addRequirement(app_1_1_A2);
        app1_1.addRequirement(app_1_1_A6);
        app1_2.addRequirement(app_1_2_A1);
        app1_2.addRequirement(app_1_2_A3);
        app1_4.addRequirement(app_1_4_A7);
        app1_4.addRequirement(app_1_4_A12);
        app3_1.addRequirement(reqApp3_1_1);
        app3_1.addRequirement(reqApp3_1_2);
        app3_1.addRequirement(reqApp3_1_3);
        app3_2.addRequirement(reqApp3_2_1);
        app3_2.addRequirement(reqApp3_2_2);
        app3_6.addRequirement(reqApp3_6_1);
        app3_6.addRequirement(reqApp3_6_2);
        app3_6.addRequirement(reqApp3_6_3);



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


        processService.saveProcess(extraProcess);
        processService.saveProcess(orpOrgPers);
        processService.saveProcess(app1);
        processService.saveProcess(app3);


        componentService.saveComponent(compOrg);
        componentService.saveComponent(compPers);
        componentService.saveComponent(app1_1);
        componentService.saveComponent(app1_2);
        componentService.saveComponent(app1_4);
        componentService.saveComponent(app3_1);
        componentService.saveComponent(app3_2);
        componentService.saveComponent(app3_6);


        requirementService.saveRequirement(reqOrg11);
        requirementService.saveRequirement(reqOrg12);
        requirementService.saveRequirement(reqOrg13);
        requirementService.saveRequirement(reqPers11);
        requirementService.saveRequirement(reqPers12);
        requirementService.saveRequirement(reqPers13);
        requirementService.saveRequirement(app_1_1_A2);
        requirementService.saveRequirement(app_1_1_A6);
        requirementService.saveRequirement(app_1_2_A1);
        requirementService.saveRequirement(app_1_2_A3);
        requirementService.saveRequirement(app_1_4_A7);
        requirementService.saveRequirement(app_1_4_A12);
        requirementService.saveRequirement(reqApp3_1_1);
        requirementService.saveRequirement(reqApp3_1_2);
        requirementService.saveRequirement(reqApp3_1_3);
        requirementService.saveRequirement(reqApp3_2_1);
        requirementService.saveRequirement(reqApp3_2_2);
        requirementService.saveRequirement(reqApp3_6_1);
        requirementService.saveRequirement(reqApp3_6_2);
        requirementService.saveRequirement(reqApp3_6_3);

        dangerService.saveDanger(spionage);
        dangerService.saveDanger(diebstahl);
        dangerService.saveDanger(fehlplanung);
        dangerService.saveDanger(manipulation);
        dangerService.saveDanger(ausfall);
        dangerService.saveDanger(identitaetsdieebstahl);
        dangerService.saveDanger(missbrauchPersDaten);
        dangerService.saveDanger(verstoss);

        actionService.saveAction(testAction1);
        actionService.saveAction(testAction2);
        actionService.saveAction(trafficRed);
        actionService.saveAction(trafficYellow);
    }
}