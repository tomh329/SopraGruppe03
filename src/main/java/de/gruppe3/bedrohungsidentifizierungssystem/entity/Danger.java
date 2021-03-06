package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
public class Danger {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dangerId;

    @NotBlank(message = "Eine Gefahr braucht einen Gefahrenname.")
    private String dangerName;

    @NotNull(message = "Die Gefahr darf nicht Null sein.")
//  @PositiveOrZero(message = "Der Gefahr muss positiv sein.")
    private int dangerLevel;


    //    @ManyToOne
//    @JoinColumn(name = "requirement_id")
//    private Requirement requirement;
    @ManyToMany
    @JoinTable(
            name = "danger_requirement",
            joinColumns = @JoinColumn(name = "dangerId"),
            inverseJoinColumns = @JoinColumn(name = "requirementId"))
    private List<Requirement> requirements;


    public Danger(String dangerName, int dangerLevel) {
        this.dangerName = dangerName;
        this.dangerLevel = dangerLevel;
    }

    public Danger() {

    }


    public int getDangerId() {
        return dangerId;
    }

    public void setDangerId(int dangerID) {
        this.dangerId = dangerID;
    }

    public String getDangerName() {
        return dangerName;
    }

    public void setDangerName(String dangerName) {
        this.dangerName = dangerName;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(int dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

//    public Requirement getRequirement() {
//        return requirement;
//    }
//    public void setRequirement(Requirement requirement) {
//        this.requirement = requirement;
//    }


    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }
}
