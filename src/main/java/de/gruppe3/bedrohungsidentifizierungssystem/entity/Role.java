package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;

import java.util.List;

@Entity
public class Role {
    @Id
    private String role;


    @OneToMany(targetEntity = User.class, mappedBy = "role")
    private List<User> user;

    public void setUserList(List<User> user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return user;
    }

    public void addUser(User user) {
        getUserList().add(user);
    }

    public void removeUser(User user) {
        getUserList().remove(user);
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }


}
