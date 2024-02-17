package com.blog.blogapp.controller;

import com.blog.blogapp.repo.ArticleRepo;
import com.blog.blogapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserArticle {

    @Autowired
    UserRepo userRepo;
    @Autowired
    ArticleRepo articleRepo;

    //find all Articles based on UserId
    @GetMapping("/user-article/{id}")
    public ResponseEntity<?> articlesBasedOnUserId(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(userRepo.findById(id).get().getArticles());
    }
}
