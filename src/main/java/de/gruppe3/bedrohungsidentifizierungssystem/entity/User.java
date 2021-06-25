package de.gruppe3.bedrohungsidentifizierungssystem.entity;



import javax.persistence.*;
import java.util.*;

@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String firstname;
    private String lastname;

    @ManyToOne()
    @JoinColumn(name = "FK_USERROLE")
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "user_components",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "componentId"))
    private List<Component> components;

    public User(){
    }

    public User(String firstname, String lastname) {

        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }
}
