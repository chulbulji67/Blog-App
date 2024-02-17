package com.blog.blogapp.service.commentservice.impl;

import com.blog.blogapp.entity.Article;
import com.blog.blogapp.entity.User;
import com.blog.blogapp.exception.articleexception.NoArticleFoundException;
import com.blog.blogapp.exception.commentException.NoCommentFoundException;
import com.blog.blogapp.entity.Comment;
import com.blog.blogapp.exception.userexception.NoUserFoundException;
import com.blog.blogapp.repo.ArticleRepo;
import com.blog.blogapp.repo.CommentRepo;
import com.blog.blogapp.repo.UserRepo;
import com.blog.blogapp.service.commentservice.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ArticleRepo articleRepo;

    @Override
    public Comment postACommentOnSpecificArticle(Comment comment) {
        //Get user and set the user
        User user = userRepo.findById(comment.getUser().getId()).orElse(null);
        if(user == null) throw new NoUserFoundException("No User Found");
        Article article = articleRepo.findById(comment.getArticle().getId()).orElse(null);
        if(article == null) throw new NoArticleFoundException("No Article Found");
        comment.setArticle(article);
        comment.setUser(user);
        return commentRepo.save(comment);
    }

    @Override
    public List<Comment> findAllCommentForSpecificArticle() {
        List<Comment> comments = commentRepo.findAll();
        if(comments.isEmpty()) throw new NoCommentFoundException("No comment found with this id");
        return comments;
    }

    @Override
    public Comment updateExistingComment(Comment comment,long id) {
        if(!commentRepo.existsById(id)) throw new NoCommentFoundException("No comment found with id: "+id);
        //Check if User exist
        User user = userRepo.findById(comment.getUser().getId()).orElse(null);
        if(user == null) throw new NoUserFoundException("No user found");

        //Check if Article exist
        Article article = articleRepo.findById(comment.getArticle().getId()).orElse(null);
        if(article == null) throw new NoArticleFoundException("No article Found with id:");
        Comment existingComment = commentRepo.findById(id).orElse(null);
        if(existingComment == null) throw new NoCommentFoundException("No comment found with id "+id);

        existingComment.setContent(comment.getContent());
        existingComment.setUser(user);
        existingComment.setArticle(article);

        return commentRepo.save(existingComment);
    }

    @Override
    public Comment deleteCommentById(long id) {
        if(!commentRepo.existsById(id)) throw new NoCommentFoundException("No comment found with id: "+id);
        Comment comment = commentRepo.findById(id).get();
        commentRepo.delete(comment);
        return comment;
    }
}
