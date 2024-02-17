package com.blog.blogapp.controller;

import com.blog.blogapp.entity.Comment;
import com.blog.blogapp.service.commentservice.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("articles")
public class CommentController {

    @Autowired
    CommentService commentService;

    // POST /articles/{articleId}/comments: Add a new comment to an article.
    @PostMapping("/{articleId}/comments")
    public ResponseEntity<?> addAComment(@RequestBody Comment comment){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.postACommentOnSpecificArticle(comment));
    }

    //    GET /articles/{articleId}/comments: Get comments for a specific article.

    @GetMapping("/{articleId}/comment")
    public ResponseEntity<?> getAllComments(){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.findAllCommentForSpecificArticle());

    }


    //    PUT /articles/{articleId}/comments/{commentId}: Update an existing comment.
    @PutMapping("/{articleId}/comments/{commentId}")
    public ResponseEntity<?> updateAComment(@RequestBody Comment comment, @PathVariable long commentId){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.updateExistingComment(comment, commentId));
    }

    //    DELETE /articles/{articleId}/comments/{commentId}: Delete a comment.
    @DeleteMapping("/{articleId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable long commentId){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.deleteCommentById(commentId));
    }



}
