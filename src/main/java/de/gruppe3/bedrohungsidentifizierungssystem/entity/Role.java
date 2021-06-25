package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Role {
    @Id
    private int roleId;
    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    @OneToMany(targetEntity = User.class, mappedBy = "role")
    private List<User> user;


    public String getRole() {
        return role;
    }
}
