package de.gruppe3.bedrohungsidentifizierungssystem.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthenticatedUser extends User implements UserDetails {


    private User user;

    public AuthenticatedUser(User user) {
        super(user.getUsername(), user.getPassword());
        this.user = user;
    }

/*    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = (Set<Role>) user.getRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return authorities;
    }*/


/*    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Role role = user.getRole();
        authorities.add(new SimpleGrantedAuthority(role.getRole()));

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
