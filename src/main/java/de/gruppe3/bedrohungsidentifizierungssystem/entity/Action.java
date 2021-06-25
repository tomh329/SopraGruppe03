package de.gruppe3.bedrohungsidentifizierungssystem.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
public class Action {

    @Id
    @GeneratedValue
    private int actionId;

    @NotBlank(message = "Die Maßnahme braucht einen Namen.")
    private String actionName;

    @FutureOrPresent(message = "Das Datum darf nicht in der Vergangenheit liegen.")
    private Date actionDueDate;

    @NotBlank(message = "Es muss ein Wert eingetragen werden.")
    private String protectionNeeds;


    public Action(String actionName, Date actionDueDate, String protectionNeeds) {
        this.actionName = actionName;
        this.actionDueDate = actionDueDate;
        this.protectionNeeds = protectionNeeds;
    }

    public Action() {

    }


    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Date getActionDueDate() {
        return actionDueDate;
    }

    public void setActionDueDate(Date actionDueDate) {
        this.actionDueDate = actionDueDate;
    }

    public String getProtectionNeeds() {
        return protectionNeeds;
    }

    public void setProtectionNeeds(String protectionNeeds) {
        this.protectionNeeds = protectionNeeds;
    }

}
