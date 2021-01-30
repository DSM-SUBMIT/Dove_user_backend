package com.dove.Dove_user_backend.service.post;

import com.dove.Dove_user_backend.dto.request.PostRequest;
import com.dove.Dove_user_backend.dto.response.PostContentResponse;
import com.dove.Dove_user_backend.dto.response.PostListResponse;
import org.springframework.data.domain.Pageable;

public interface PostService {
    void writePost(PostRequest postRequest);
    PostListResponse viewList(Pageable page);
    PostContentResponse viewPost(Integer id);
}
