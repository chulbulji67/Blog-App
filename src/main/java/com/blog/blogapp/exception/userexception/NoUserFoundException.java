package com.blog.blogapp.exception.userexception;

public class NoUserFoundException extends RuntimeException {
    public NoUserFoundException(String noUserExist) {
        super(noUserExist);
    }
}
