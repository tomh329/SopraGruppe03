package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Role;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RoleRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    public User findUserWithName(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean deleteUser(String userName){

        User userDelete = findUserWithName(userName);
        if(!userDelete.equals(null)) {
            userRepository.delete(userDelete);
            return true;
        }
        return false;
    }

    public void updateUser(String username, String userRole) {

        List<User> userList = userRepository.findAll();

        for(User user : userList){
            if(username == user.getUsername()){
                user.setUsername(username);
                Role role = new Role();
                role.setRole(userRole);
                user.setRole(role);

                userRepository.save(user);
                roleRepository.save(role);
            }
        }
    }
}
