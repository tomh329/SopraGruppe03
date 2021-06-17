package de.gruppe3.bedrohungsidentifizierungssystem.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Requirement {

    @Id @GeneratedValue
    int id;
    String name;

    public Requirement(String name) {
        this.name = name;
    }

    public Requirement() {

    }
}
