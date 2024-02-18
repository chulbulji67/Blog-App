package com.blog.blogapp.config;

import com.blog.blogapp.entity.Role;
import com.blog.blogapp.entity.User;
import com.blog.blogapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if(user == null) throw new UsernameNotFoundException("This username does not exist");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),getAuthrity(user.getRoles()));

    }

    private List<GrantedAuthority> getAuthrity(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role: roles
             ) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }
}
