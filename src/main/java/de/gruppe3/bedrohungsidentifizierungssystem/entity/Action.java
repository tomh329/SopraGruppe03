package de.gruppe3.bedrohungsidentifizierungssystem.entity;


import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actionId;

    @NotBlank(message = "Die Maßnahme braucht einen Namen.")
    private String actionName;

//    @FutureOrPresent(message = "Das Datum darf nicht in der Vergangenheit liegen.")
    private String actionDueDate;

//    @NotBlank(message = "Es muss ein Wert eingetragen werden.")
    private int protectionNeeds;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private Component componentAct;


    public Action(String actionName, String actionDueDate, int protectionNeeds) {
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

    public String getActionDueDate() {
        return actionDueDate;
    }

    public void setActionDueDate(String actionDueDate) {
        this.actionDueDate = actionDueDate;
    }

    public int getProtectionNeeds() {
        return protectionNeeds;
    }

    public void setProtectionNeeds(int protectionNeeds) {
        this.protectionNeeds = protectionNeeds;
    }

    public Component getComponent() {
        return componentAct;
    }

    public void setComponent(Component component) {
        this.componentAct = component;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
