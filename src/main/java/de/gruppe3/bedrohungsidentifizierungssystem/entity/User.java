package de.gruppe3.bedrohungsidentifizierungssystem.entity;


import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
public class User {

    @Id
    private String username;


    @Size(min = 5, max = 25, message = "Das Passwort muss zwischen 5 und 25 Zeichen lang sein.")
    @NotBlank(message = "Das Passwort darf nicht nur Leerzeichen beinhalten")
    private String password;

    @NotNull(message = "Dem Benutzer muss eine Rolle zugewiesen werden.")
    @ManyToOne()
    @JoinColumn(name = "FK_USERROLE", insertable = true, updatable = true)
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "user_components",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "componentId"))
    private List<Component> components;

    public User() {
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