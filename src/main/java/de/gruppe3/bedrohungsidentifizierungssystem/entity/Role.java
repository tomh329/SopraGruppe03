package de.gruppe3.bedrohungsidentifizierungssystem.entity;


import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import java.util.List;

@Entity
public class Role {

    @NotBlank(message = "Die Rolle braucht einen Namen.")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public void addUser(User user){

        user.setRole(this);
    }

    public String getRole() {
        return role;
    }


}
