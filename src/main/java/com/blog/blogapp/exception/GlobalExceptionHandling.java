package com.blog.blogapp.exception;

import com.blog.blogapp.exception.articleexception.NoArticleFoundException;
import com.blog.blogapp.exception.commentException.NoCommentFoundException;
import com.blog.blogapp.exception.tagException.NoTagFoundException;
import com.blog.blogapp.exception.userexception.NoUserFoundException;
import com.blog.blogapp.exception.userexception.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<String> handleUserAlreadyExistException(UserAlreadyExistException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<String > handleUsrNotFoundException(NoUserFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(NoArticleFoundException.class)
    public ResponseEntity<String> handleNoArticleFoundException(NoArticleFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(NoCommentFoundException.class)
    public ResponseEntity<String> handleNoArticleFoundException(NoCommentFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(NoTagFoundException.class)
    public ResponseEntity<String> handleNoArticleFoundException(NoTagFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
