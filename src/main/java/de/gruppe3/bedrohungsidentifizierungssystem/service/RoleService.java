package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Role;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;


    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> findAllProcesses() {
        return roleRepository.findAll();
    }
}
