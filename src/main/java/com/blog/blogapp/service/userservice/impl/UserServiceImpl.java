package com.blog.blogapp.service.userservice.impl;

import com.blog.blogapp.entity.User;
import com.blog.blogapp.exception.userexception.NoUserFoundException;
import com.blog.blogapp.exception.userexception.UserAlreadyExistException;
import com.blog.blogapp.repo.UserRepo;
import com.blog.blogapp.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Override
    public User registerUsre(User user) {
        //Check if UserAlready Exist
        User existUser = userRepo.findByEmail(user.getEmail());
        if(existUser != null) throw new UserAlreadyExistException("User with This email already exist");
        else {
            existUser = userRepo.findByUsername(user.getUsername());
            if(existUser != null) throw new UserAlreadyExistException("User with This email already exist");
        }

        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepo.findAll();
        if(users.isEmpty()) throw new NoUserFoundException("No user Exist");
        return users;
    }

    @Override
    public User getUserById(long id) {
        if(!userRepo.existsById(id)) {
            throw new NoUserFoundException("No user find with id " + id);
        }
        return userRepo.findById(id).get();
    }

    @Override
    public String deleteByUserId(long id) {
        if(!userRepo.existsById(id)) {
            throw new NoUserFoundException("No user find with id " + id);
        }

        userRepo.deleteById(id);
        return "user deleted successfully";
    }

    @Override
    public User updateUser(User user, long id) {
        if(!userRepo.existsById(id)) {
            throw new NoUserFoundException("No user find with id " + id);
        }
        User existingUser = userRepo.findById(id).get();
        existingUser.setId(id);
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());


        return userRepo.save(existingUser);
    }
}
