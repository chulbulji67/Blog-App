package com.blog.blogapp.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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

//    @OneToMany(mappedBy = "follower")
//    private Set<Follower> followers;
//
//    @OneToMany(mappedBy = "followedUser")
//    private Set<Follower> followedUsers;


}
