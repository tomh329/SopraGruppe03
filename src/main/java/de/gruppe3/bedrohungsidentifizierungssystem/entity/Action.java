package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Scanner;

public class Action {

    Scanner scA = new Scanner(System.in);

    @Id
    @GeneratedValue
    private int actionId;
    private String actionName;
    private String actionDueDate;
    private String protectionNeeds;


    public Action(String actionName, String actionDueDate, String protectionNeeds) {
        this.actionName = actionName;
        this.actionDueDate = actionDueDate;
        this.protectionNeeds = protectionNeeds;
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

    public String getProtectionNeeds() {
        return protectionNeeds;
    }

    public void setProtectionNeeds(String protectionNeeds) {
        this.protectionNeeds = protectionNeeds;
    }

    public void createAction() {
        System.out.println("Geben sie den Namen der Maßnahme an: ");
        String name = scA.nextLine();
        System.out.println("Geben sie das Umsetzungsdatum in der Form 'TT.MM.YYYY' an: ");
        String date = scA.nextLine();
        System.out.println("Geben sie den Schutzbedarf an: ");
        String protectionNeeds = scA.nextLine();

        Action action = new Action(name, date, protectionNeeds);

    }
}