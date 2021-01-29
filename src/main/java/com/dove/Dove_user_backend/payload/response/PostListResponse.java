package com.dove.Dove_user_backend.payload.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PostListResponse extends PageResponse {

    private List<PostListContentResponse> postResponses;

    @Builder
    public PostListResponse(int totalElements, int totalPages, List<PostListContentResponse> postResponses) {
        super(totalElements, totalPages);
        this.postResponses = postResponses;
    }

}
