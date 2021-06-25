package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import de.gruppe3.bedrohungsidentifizierungssystem.service.DataLoader;
import de.gruppe3.bedrohungsidentifizierungssystem.service.ProcessService;
import org.apache.tomcat.jni.Proc;
import org.hibernate.annotations.OnDelete;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.*;


@Entity
public class Process {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int processId;
    private String processName;
    private int protectionLevel;

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
