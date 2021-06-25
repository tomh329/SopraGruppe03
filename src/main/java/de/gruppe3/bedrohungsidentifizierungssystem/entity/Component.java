package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import jdk.jfr.Enabled;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int componentId;

    private String componentName;
    private int priority;
    private String lastAttack;
    private int occurrence;

    @ManyToOne
    @JoinColumn(name = "process_id")
    private Process process;

    @OneToMany(targetEntity = Requirement.class, mappedBy = "component")
    private List<Requirement> requirements;

    @ManyToMany
    public List<User> users;



    public Component(String componentName, int priority, String lastAttack, int occurrence) {

        this.componentName = componentName;
        this.priority = priority;
        this.lastAttack = lastAttack;
        this.occurrence = occurrence;
    }

    public Component() {

    }


    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getLastAttack() {
        return lastAttack;
    }

    public void setLastAttack(String lastAttack) {
        this.lastAttack = lastAttack;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public void addRequirement(Requirement requirement){
        requirement.setComponent(this);
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    /*
        used to create a new component without requirements
        needs html connection
         */
//    public void createComponent() {
//        System.out.println("Geben Sie den Namen ein: ");
//        String name = sc.nextLine();
//        System.out.println("Geben Sie die Priorität ein: ");
//        int priority = sc.nextInt();
////        Date lastAttack = new Date();
//        System.out.println("Geben Sie den letzten Angriff an: ");
//        String lastAttack = sc.nextLine();
//        System.out.println("Geben Sie das Aufkommen an: ");
//        int occurrence = sc.nextInt();
//
//        Component component = new Component(name, priority, lastAttack, occurrence);
//
//        System.out.println("Komponente erstellt");
//        ComponentList.componentList.add(component);
//    }

}
