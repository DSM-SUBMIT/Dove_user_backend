package com.dove.Dove_user_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Post is not exist")
public class PostNotFoundException extends RuntimeException{
}
