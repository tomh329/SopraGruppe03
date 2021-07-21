package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.*;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RoleRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    public User findUserWithName(String username) {
        return userRepository.findByUsername(username);
    }



    public User createUser(String username, String password, String firstname, String lastname, int roleId){


        User user = new User(username, password, firstname, lastname);

        List<Role> roleList = roleRepository.findAll();

        for(Role role : roleList){

            if (roleId == role.getRoleId()) {

                user.setRole(role);
            }
        }

        return userRepository.save(user);
    }



    public boolean deleteUser(String userName){



        User userDelete = findUserWithName(userName);
        List<Component> componentList = componentRepository.findAll();
        List<Component> compOfUserList = userDelete.getComponents();

        for(Component componentOfUser : compOfUserList){
            for(Component component : componentList){
                if(component == componentOfUser){

                    component.removeUser(userDelete);
                }
            }
        }

        compOfUserList.clear();

        if(!userDelete.equals(null)) {
            userRepository.delete(userDelete);
            return true;
        }
        return false;
    }

    public void updateUser(String username, String firstname, String lastname, int roleId) {

        User editedUser = findUserWithName(username);
        editedUser.setFirstname(firstname);
        editedUser.setLastname(lastname);
        List<Role> editedUserRole = roleRepository.findAll();
        for(Role editedRole : editedUserRole){
            if(editedRole.getRoleId() == roleId) {
                editedUser.setRole(editedRole);
            }
        }

        userRepository.save(editedUser);

    }

    public void updateUser(User user, String password) {

        user.setPassword(password);
        userRepository.save(user);
    }


    public void removeComponent(String username, int componentId){


        User user = userRepository.findByUsername(username);
        Component component = componentRepository.findByComponentId(componentId);

        user.getComponents().remove(component);
        component.getUsers().remove(user);

        userRepository.save(user);
        componentRepository.save(component);
    }
}
