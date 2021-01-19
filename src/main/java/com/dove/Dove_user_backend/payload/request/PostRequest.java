package com.dove.Dove_user_backend.payload.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {

    @NotNull
    private String clubName;

    @NotNull
    private String title;

    @NotNull
    private String writer;

    private String description;

    @NotNull
    private String date;

    private String link;

}
