package com.blog.blogapp.service.commentservice;

import com.blog.blogapp.entity.Comment;

import java.util.List;

public interface CommentService {

    //POST /articles/{articleId}/comments: Add a new comment to an article.
    Comment postACommentOnSpecificArticle(Comment comment);

    // GET /articles/{articleId}/comments: Get comments for a specific article.
    List<Comment> findAllCommentForSpecificArticle();

    //PUT /articles/{articleId}/comments/{commentId}: Update an existing comment.
    Comment updateExistingComment(Comment comment,long id);

    //DELETE /articles/{articleId}/comments/{commentId}: Delete a comment.
    Comment deleteCommentById(long id);

}
