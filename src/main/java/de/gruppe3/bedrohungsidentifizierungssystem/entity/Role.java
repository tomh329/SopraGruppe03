package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Role {

    @NotBlank(message = "Die Rolle braucht einen Namen.")
    @Id
    private String role;

    @OneToMany(mappedBy = "role")
    private List<User> user;


    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<User> getUser() {
        return user;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }


}
