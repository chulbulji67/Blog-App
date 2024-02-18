package com.blog.blogapp.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends AbstractClass{

    private String username;
    private String email;
    private String password;
    private Date registration_date;


    @JsonIgnore
    @OneToMany(mappedBy = "user" ,fetch = FetchType.EAGER)
    private List<Article> articles;

    @JsonIgnore
    @OneToMany(mappedBy = "user" ,fetch = FetchType.EAGER)
    private List<Comment> comments;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

//    @OneToMany(mappedBy = "follower")
//    private Set<Follower> followers;
//
//    @OneToMany(mappedBy = "followedUser")
//    private Set<Follower> followedUsers;


}
