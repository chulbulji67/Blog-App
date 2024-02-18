package com.blog.blogapp.config;

import com.blog.blogapp.entity.Role;
import com.blog.blogapp.entity.User;
import com.blog.blogapp.repo.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.SecurityContextRepository;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsernamepwdAuthenticationProvider {

    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    SecurityContextRepository securityContextRepository;

    public boolean login(String userName, String password, HttpServletRequest request, HttpServletResponse response){
        UserDetails userDetails = userDetailService.loadUserByUsername(userName);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
         authenticationManager.authenticate(token);
         boolean result = token.isAuthenticated();

         if(result){
             SecurityContext context = SecurityContextHolder.getContext();
             context.setAuthentication(token);
             securityContextRepository.saveContext(context, request, response);
         }
         return result;
    }
}
