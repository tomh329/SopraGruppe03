package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import javax.persistence.*;
import java.util.*;


@Entity
public class Process {


    static Scanner sc = new Scanner(System.in);

    @Id
    @GeneratedValue
    private int processId;
    private String processName;
    private int protectionLevel;
    @JoinTable
    private int componentId;
    private static List<Component> components;


    public Process(String processName, int protectionLevel, int componentId) {
        // empty constructor for Hibernate
        this.processName = processName;
        this.protectionLevel = protectionLevel;
        this.componentId = componentId;
        components = new ArrayList<Component>();
    }

    public Process() {

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

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(Component newComponent) {
        components.add(newComponent);
    }


    public void addComponent() {

        System.out.println("Geben Sie die ID des Komponenten an den Sie hinzufügen wollen: ");
        int idComponent = sc.nextInt();

        for (Component component : ComponentList.componentList) {
            if (idComponent == component.getComponentId()) {
                setComponents(component);
            }
        }
    }


    /*
    used to create a new process with components
    needs html connection
     */
    public void createProcess() {
        System.out.println("Geben Sie den Namen ein: ");
        String name = sc.nextLine();
        System.out.println("Geben Sie die Gefahrenstufe ein: ");
        int protectionLevel = sc.nextInt();

        Process process = new Process(name, protectionLevel, componentId);

        System.out.println("Wie viele Komponenten möchten Sie hinzufügen? ");
        int amount = sc.nextInt();

        for (int i = 0; i < amount; i++) {
            process.addComponent();
        }

        System.out.println("Prozess erstellt!");
        ProcessList.processList.add(process);
    }

    public void editProcessName(){
        System.out.println("Geben Sie den neuen Namen ein: ");
        String newName = sc.nextLine();

        setProcessName(newName);
    }

    public void editProcessProtectionLevel(){
        System.out.println("Geben Sie den neuen Schutzbedarf ein: ");
        int newProtectionLevel = sc.nextInt();

        setProtectionLevel(newProtectionLevel);
    }

    public void deleteProcess(){

        int deleteId = getProcessId();

        ProcessList.processList.removeIf(process -> deleteId == process.getProcessId());
    }

}
