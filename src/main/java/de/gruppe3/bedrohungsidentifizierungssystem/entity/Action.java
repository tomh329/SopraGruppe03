package de.gruppe3.bedrohungsidentifizierungssystem.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Scanner;
import java.util.*;


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



    /*
    needs to be in the actionService class
     */
//    public void createAction() {
//        System.out.println("Geben sie den Namen der Maßnahme an: ");
//        String name = scA.nextLine();
//        System.out.println("Geben sie das Umsetzungsdatum in der Form 'TT.MM.YYYY' an: ");
//        String date = scA.nextLine();
//        System.out.println("Geben sie den Schutzbedarf an: ");
//        String protectionNeeds = scA.nextLine();
//
//        Action action = new Action(name, date, protectionNeeds);
//
//    }
}
