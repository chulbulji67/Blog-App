package com.blog.blogapp.service.authservice;

import com.blog.blogapp.dto.Login;
import org.springframework.stereotype.Service;

@Service
public interface Authentication {

    boolean login(Login login);
}
