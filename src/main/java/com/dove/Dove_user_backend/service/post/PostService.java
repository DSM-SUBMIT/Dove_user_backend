package com.dove.Dove_user_backend.service.post;

import com.dove.Dove_user_backend.payload.request.PostRequest;
import com.dove.Dove_user_backend.payload.response.PostContentResponse;
import com.dove.Dove_user_backend.payload.response.PostListResponse;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostListResponse viewList(Pageable page);
    PostContentResponse viewPost(Integer id);
    void post(PostRequest postRequest);
}
