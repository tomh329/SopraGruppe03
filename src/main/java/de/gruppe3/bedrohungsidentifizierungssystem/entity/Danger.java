package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Danger {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dangerID;

    @NotBlank(message = "Eine Gefahr braucht einen Gefahrenname.")
    private String dangerName;

    @NotNull(message = "Der Gefahr muss ein Gefahrenlevel zugeordnet werden.")
    private Enum<Severity> dangerLevel;

    @ManyToOne
    @JoinColumn(name = "requirement_id")
    private Requirement requirement;


    public Danger(String dangerName, Enum<Severity> dangerLevel) {
        this.dangerName = dangerName;
        this.dangerLevel = dangerLevel;
    }

    public Danger() {

    }


    public int getDangerID() {
        return dangerID;
    }

    public void setDangerID(int dangerID) {
        this.dangerID = dangerID;
    }

    public String getDangerName() {
        return dangerName;
    }

    public void setDangerName(String dangerName) {
        this.dangerName = dangerName;
    }

    public Enum<Severity> getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(Enum<Severity> dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

}
