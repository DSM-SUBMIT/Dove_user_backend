package com.dove.Dove_user_backend.service.post;

import com.dove.Dove_user_backend.payload.request.PostRequest;
import com.dove.Dove_user_backend.payload.response.PostListResponse;
import com.dove.Dove_user_backend.payload.response.PostResponse;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostListResponse viewList(Pageable page);
    PostResponse viewPost(Integer id);
    void post(PostRequest postRequest);
}
