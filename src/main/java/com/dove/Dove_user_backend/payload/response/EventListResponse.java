package com.dove.Dove_user_backend.payload.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class EventListResponse {

    private List<EventResponse> eventResponses;

}
