package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import javax.persistence.*;

@Entity
public class Danger {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dangerId;
    private String dangerName;
    private int dangerLevel;

    @ManyToOne
    @JoinColumn(name = "requirement_id")
    private Requirement requirement;


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

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    //    public void createDanger() {
//        System.out.println("Geben sie den Namen ein:");
//        String name = scD.nextLine();
//        Enum<Severity> severity = null;
//        while (severity == null) {
//            System.out.println("Geben sie die Schwere inform von 'ZERO', 'ONE', 'TWO' oder 'THREE' an: ");
//            String severityTemp = scD.nextLine();
//            if (severityTemp.equalsIgnoreCase(Severity.ZERO.toString())) {
//                severity = Severity.ZERO;
//            } else if (severityTemp.equalsIgnoreCase(Severity.ONE.toString())) {
//                severity = Severity.ONE;
//            } else if (severityTemp.equalsIgnoreCase(Severity.TWO.toString())) {
//                severity = Severity.TWO;
//            } else if (severityTemp.equalsIgnoreCase(Severity.ZERO.toString())) {
//                severity = Severity.THREE;
//            }
//        }
//        Danger danger = new Danger(name, severity);
//    }

}
