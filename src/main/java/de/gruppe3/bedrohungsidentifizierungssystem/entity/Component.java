package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import jdk.jfr.Enabled;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Component {


    static Scanner sc = new Scanner(System.in);

    @Id
    @GeneratedValue
    private int componentId;

    private String componentName;
    private int priority;
    private String lastAttack;
    private int occurrence;
    private static List<Requirement> requirements;

    public Component(String componentName, int priority, String lastAttack, int occurrence) {

        this.componentName = componentName;
        this.priority = priority;
        this.lastAttack = lastAttack;
        this.occurrence = occurrence;
        requirements = new ArrayList<Requirement>();
    }

    public Component() {

    }


    public int getComponentId() {
        return componentId;
    }


    /*
    used to create a new component without requirements
    needs html connection
     */
    public void createComponent() {
        System.out.println("Geben Sie den Namen ein: ");
        String name = sc.nextLine();
        System.out.println("Geben Sie die Priorität ein: ");
        int priority = sc.nextInt();
//        Date lastAttack = new Date();
        System.out.println("Geben Sie den letzten Angriff an: ");
        String lastAttack = sc.nextLine();
        System.out.println("Geben Sie das Aufkommen an: ");
        int occurrence = sc.nextInt();

        Component component = new Component(name, priority, lastAttack, occurrence);

        System.out.println("Komponente erstellt");
        ComponentList.componentList.add(component);
    }

}
