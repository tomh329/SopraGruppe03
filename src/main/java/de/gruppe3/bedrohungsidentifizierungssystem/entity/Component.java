package de.gruppe3.bedrohungsidentifizierungssystem.entity;


import jdk.jfr.Enabled;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int componentId;

    @NotBlank(message = "Die Komponente braucht einen Namen.")
    private String componentName;

    @PositiveOrZero(message = "Die Priorität darf nicht negativ sein.")
    @NotNull(message = "Einer Komponente muss eine Priorität zugeordnet werden.")
    private int priority;

    private String lastAttack;

    @Positive(message = "Eine Komponente muss mindestens einmal vorkommen.")
    @NotNull(message = "Vorkommen muss ein Wert zugewiesen werden.")
    private int occurrence;

//    @NotNull(message = "Eine Komponente muss einem Prozess zugeordnet sein.")
    @ManyToOne
    @JoinColumn(name = "process_id")
    private Process process;

    @OneToMany(targetEntity = Requirement.class, mappedBy = "component")
    private List<Requirement> requirements;

    @OneToMany(targetEntity = Action.class, mappedBy = "componentAct")
    private List<Action> actions;

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

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
