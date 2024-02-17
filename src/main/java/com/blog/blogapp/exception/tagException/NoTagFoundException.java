package com.blog.blogapp.exception.tagException;

public class NoTagFoundException extends RuntimeException {
    public NoTagFoundException(String noTagFound) {
        super(noTagFound);
    }
}
