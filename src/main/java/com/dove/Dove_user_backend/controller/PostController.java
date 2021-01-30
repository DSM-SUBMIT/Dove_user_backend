package com.dove.Dove_user_backend.controller;

import com.dove.Dove_user_backend.dto.request.PostRequest;
import com.dove.Dove_user_backend.dto.response.PostContentResponse;
import com.dove.Dove_user_backend.dto.response.PostListResponse;
import com.dove.Dove_user_backend.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {
    
    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void writePost(PostRequest postRequest) {
        postService.writePost(postRequest);
    }

    @GetMapping
    PostListResponse viewList(Pageable page) {
        return postService.viewList(page);
    }

    @GetMapping("/{id}")
    PostContentResponse viewPost(@PathVariable Integer id) {
        return postService.viewPost(id);
    }

}
