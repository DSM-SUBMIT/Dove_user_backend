package com.dove.Dove_user_backend.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PostListContentResponse {

    private String clubName;

    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;

}
