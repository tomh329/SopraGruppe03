package de.gruppe3.bedrohungsidentifizierungssystem.entity;



import javax.persistence.*;
import java.util.*;

@Entity
public class User {

    @Id
    private String username;

    private String password;

    @ManyToOne()
    @JoinColumn(name = "FK_USERROLE", insertable = false, updatable = false)
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "user_components",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "componentId"))
    private List<Component> components;

    public User(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
