package com.dove.Dove_user_backend.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PostListResponse extends PageResponse{

    private List<PostResponse> postResponses;

    @Builder
    public PostListResponse(int totalElements, int totalPages, List<PostResponse> postResponses) {
        super(totalElements, totalPages);
        this.postResponses = postResponses;
    }
}
