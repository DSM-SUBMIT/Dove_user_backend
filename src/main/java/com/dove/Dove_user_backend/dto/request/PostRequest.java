package com.dove.Dove_user_backend.dto.request;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PostRequest {

    @NotNull
    private String host;

    @NotNull
    private String title;

    @NotNull
    private String writer;

    private String description;

    private String link;

    @NotNull
    private LocalDate eventDate;

}
