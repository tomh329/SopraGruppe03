package de.gruppe3.bedrohungsidentifizierungssystem.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int requirementId;
    String requirementName;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private Component component;

    @OneToMany(targetEntity = Danger.class, mappedBy = "requirement")
    private List<Danger> dangers;



    public Requirement(String requirementName) {

        this.requirementName = requirementName;
    }

    public Requirement() {

    }


    public int getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(int requirementId) {
        this.requirementId = requirementId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public void addDanger(Danger danger){
        danger.setRequirement(this);
    }

    public List<Danger> getDangers() {
        return dangers;
    }

    public void setDangers(List<Danger> dangers) {
        this.dangers = dangers;
    }
}
