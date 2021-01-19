package com.dove.Dove_user_backend.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@Builder
public class PostResponse {

    private String clubName;

    private String title;

    private String writer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

}
