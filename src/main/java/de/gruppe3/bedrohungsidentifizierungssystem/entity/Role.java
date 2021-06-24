package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import java.util.List;

@Entity
public class Role {
    @NotBlank(message = "Die Rolle braucht einen Namen.")
    @Id
    private String role;



    @OneToMany(targetEntity = User.class, mappedBy = "role", fetch = FetchType.EAGER)
    private List<User> user;

    public void setUser(List<User> user){
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
