package com.dove.Dove_user_backend.service.calender;

import com.dove.Dove_user_backend.payload.response.EventListResponse;

public interface CalenderService {
    EventListResponse getCalender(Integer year, Integer month);
}
