<<<<<<< Updated upstream:holidaymaker/src/main/java/com/newton/holidaymaker/security/MyUserDetails.java
package com.newton.holidaymaker.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.newton.holidaymaker.models.Role;
import com.newton.holidaymaker.models.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {


    
    private User user;
    
    
    public MyUserDetails(User user) {
        this.user = user;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList <>();
        for (Role role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        return user.isActive();
    }

    
}
=======
// package com.newton.holidaymaker.services;

// import java.util.Collection;

// import com.newton.holidaymaker.models.User;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// public class MyUserDetails implements UserDetails {
    
//     /**
//      *
//      */
//     private static final long serialVersionUID = 1L;
//     private User user;
    
//     public User getUser() {
//         return user;
//     }
    
//     public void setUser(User user) {
//         this.user = user;
//     }
    

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         return null;
//     }

//     @Override
//     public String getPassword() {
//         return user.getPassword();
//     }

//     @Override
//     public String getUsername() {
//         return user.getUsername();
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         return true;
//     }

// }
>>>>>>> Stashed changes:holidaymaker/src/main/java/com/newton/holidaymaker/services/MyUserDetails.java