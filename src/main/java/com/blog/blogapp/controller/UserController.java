package com.blog.blogapp.controller;

import com.blog.blogapp.entity.User;
import com.blog.blogapp.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;



    //POST /users: Register a new user.
    @PostMapping()
    public ResponseEntity<?> registerUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUsre(user));
    }

    //GET /users/{id}: Get user profile by ID.
    @GetMapping("/{id}")
    public ResponseEntity<?> getUsersById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }
    //PUT /users/{id}: Update user profile.
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserByid(@RequestBody User user , @PathVariable long id){
    return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user,id));
    }
   // DELETE /users/{id}: Delete user profile
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserByID(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteByUserId(id));
    }
}
