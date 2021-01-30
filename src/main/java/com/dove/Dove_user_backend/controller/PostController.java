package com.dove.Dove_user_backend.controller;

import com.dove.Dove_user_backend.dto.request.PostRequest;
import com.dove.Dove_user_backend.dto.response.PostContentResponse;
import com.dove.Dove_user_backend.dto.response.PostListResponse;
import com.dove.Dove_user_backend.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {
    
    private final PostService postService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void writePost(@RequestBody @Validated PostRequest postRequest) {
        postService.writePost(postRequest);
    }

    @GetMapping
    public PostListResponse viewList(Pageable page) {
        return postService.viewList(page);
    }

    @GetMapping("/post/{id}")
    public PostContentResponse viewPost(@PathVariable Integer id) {
        return postService.viewPost(id);
    }

}
