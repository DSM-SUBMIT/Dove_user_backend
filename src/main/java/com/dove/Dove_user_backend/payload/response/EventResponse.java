package com.dove.Dove_user_backend.payload.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class EventResponse {

    private LocalDate date;

    private String host;

    private String event;

}
