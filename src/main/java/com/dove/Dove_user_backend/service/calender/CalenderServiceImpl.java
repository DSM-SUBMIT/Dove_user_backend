package com.dove.Dove_user_backend.service.calender;

import com.dove.Dove_user_backend.entity.event.Event;
import com.dove.Dove_user_backend.entity.event.EventRepository;
import com.dove.Dove_user_backend.payload.response.EventListResponse;
import com.dove.Dove_user_backend.payload.response.EventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CalenderServiceImpl implements CalenderService {

    private final EventRepository eventRepository;
    
    @Override
    public EventListResponse getCalender(int year, int month) {
        List<Event> events = eventRepository.findAllByDateDayOfYearAndDateDayOfMonth(year, month);
        List<EventResponse> eventResponses = new ArrayList<>();

        for(Event event : events) {
            eventResponses.add(
                    EventResponse.builder()
                            .date(event.getDate())
                            .event(event.getEvent())
                            .host(event.getHost())
                            .build()
            );
        }

        return EventListResponse.builder()
                .eventResponses(eventResponses)
                .build();
    }

}
