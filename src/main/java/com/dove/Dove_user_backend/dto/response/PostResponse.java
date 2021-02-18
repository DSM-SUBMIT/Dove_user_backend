package com.dove.Dove_user_backend.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class PostResponse {

    private Integer id;

    private String title;

    private String host;

    private LocalDate eventDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

}
