package com.blog.blogapp.exception.articleexception;

public class NoArticleFoundException extends RuntimeException {
    public NoArticleFoundException(String noArticleFound) {
        super(noArticleFound);
    }
}
