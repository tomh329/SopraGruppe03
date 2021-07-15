package de.gruppe3.bedrohungsidentifizierungssystem.service;


import de.gruppe3.bedrohungsidentifizierungssystem.entity.AuthenticatedUser;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Role;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AuthenticatedUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("The user " + username + " does not exist");
        }
        AuthenticatedUser authenticatedUser = new AuthenticatedUser(user);
        authenticatedUser.getAuthorities();

        System.out.println(authenticatedUser.getAuthorities().toString());
        System.out.println(authenticatedUser.getUsername());
        System.out.println(authenticatedUser.getPassword());
        return new AuthenticatedUser(user);
    }


    private List<GrantedAuthority> getAuthorities(User user){
        Set<Role> userRoles = (Set<Role>) user.getRole();
        List<GrantedAuthority> authorities = new ArrayList<>(userRoles.size());
        for(Role userRole : userRoles){
            authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return authorities;
    }
}