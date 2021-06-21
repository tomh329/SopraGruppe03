package de.gruppe3.bedrohungsidentifizierungssystem.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int requirementId;
    String requirementName;

    public Requirement(String requirementName) {

        this.requirementName = requirementName;
    }

    public Requirement() {

    }
}
