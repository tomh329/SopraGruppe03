package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import de.gruppe3.bedrohungsidentifizierungssystem.service.DataLoader;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.*;


@Entity
public class Process {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int processId;
    @NotBlank(message = "Der Prozess braucht einen Namen.")
    private String processName;
    //Should there be a maximum security level?
    @PositiveOrZero(message = "Das Sicherheitslevel darf nicht negativ sein.")
    @NotNull(message = "Der Prozess benötigt ein Sicherheitslevel.")
    private int protectionLevel;

    @NotEmpty(message = "Ein Prozess muss mindestens aus einer Komponente bestehen.")
    @OneToMany(targetEntity = Component.class, mappedBy = "process")
    private List<Component> components;





    public Process(String processName, int protectionLevel) {

        this.processName = processName;
        this.protectionLevel = protectionLevel;
    }

    public Process() {

    }


    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getProtectionLevel() {
        return protectionLevel;
    }

    public void setProtectionLevel(int protectionLevel) {
        this.protectionLevel = protectionLevel;
    }



    public void addComponent(Component component){

        component.setProcess(this);
    }

}
