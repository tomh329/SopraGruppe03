package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {

    @Id
    private String username;

    private String password;

    private Role role;

    @ManyToMany
    @JoinTable(
            name = "user_actions",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "actionId"))
    private List<Action> actions;

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

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
