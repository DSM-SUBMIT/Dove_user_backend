package com.dove.Dove_user_backend.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PostResponse {

    private String title;

    private String host;

    private LocalDate eventDate;

}
