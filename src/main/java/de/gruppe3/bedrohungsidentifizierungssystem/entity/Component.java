package de.gruppe3.bedrohungsidentifizierungssystem.entity;

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

    @NotNull(message = "Eine Komponente muss einem Prozess zugeordnet sein.")
    @ManyToOne
    @JoinColumn(name = "process_id")
    private Process process;

    @OneToMany(targetEntity = Requirement.class, mappedBy = "component")
    private static List<Requirement> requirements;

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

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public void addRequirement(Requirement requirement) {
        requirement.setComponent(this);
    }

}
