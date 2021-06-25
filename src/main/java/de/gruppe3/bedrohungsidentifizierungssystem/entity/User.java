package de.gruppe3.bedrohungsidentifizierungssystem.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @NotBlank(message = "Der Username darf nicht nur Leerzeichen beinhalten.")
    private String username;

    @Size(min = 5, max = 25, message = "Das Passwort muss zwischen 5 und 25 Zeichen lang sein.")
    @NotBlank(message = "Das Passwort darf nicht nur Leerzeichen beinhalten")
    private String password;
  
    private String firstname;
    private String lastname;

//    @NotNull(message = "Dem Benutzer muss eine Rolle zugewiesen werden.")
    @ManyToOne
    @JoinColumn(name = "roll_id", nullable = false)
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "user_components",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "componentId"))
    private List<Component> components;


    public User() {
    }


    public User(String username, String password, String firstname, String lastname){

        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
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

    public void addComponent(Component component) {

        components.add(component);
    }

    public void removeComponent(Component component){

        components.remove(component);
    }
}
