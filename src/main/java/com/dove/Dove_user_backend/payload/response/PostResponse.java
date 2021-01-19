package com.dove.Dove_user_backend.payload.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PostResponse extends PageResponse {

    private List<PostContentResponse> postResponses;

    @Builder
    public PostResponse(int totalElements, int totalPages, List<PostContentResponse> postResponses) {
        super(totalElements, totalPages);
        this.postResponses = postResponses;
    }

}
