package com.blog.blogapp.controller;

import com.blog.blogapp.entity.Article;
import com.blog.blogapp.service.articleservice.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    //    POST /articles: Create a new article.
    @PostMapping
    public ResponseEntity<?> addArticle(@RequestBody Article article){
        System.out.println("Working");
        return ResponseEntity.status(HttpStatus.CREATED).body(articleService.createNewArticle(article));
    }

    //    GET /articles: Get a list of all articles.
    @GetMapping()
    public ResponseEntity<?> getAllArticles(){
        return ResponseEntity.status(HttpStatus.OK).body(articleService.findAllArticles());
    }

    //    GET /articles/{id}: Get a specific article by ID.
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllArticleById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(articleService.findArticleById(id));
    }

    //    PUT /articles/{id}: Update an existing article.
    @PutMapping("/{id}")
    public ResponseEntity<?> updateArticle(@RequestBody Article article, @PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(articleService.updateArticle(article,id));
    }


    //    DELETE /articles/{id}: Delete an article
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(articleService.deleteArticle(id));
    }

}
