package com.dove.Dove_user_backend.service.calender;

import com.dove.Dove_user_backend.entity.event.Event;
import com.dove.Dove_user_backend.entity.event.EventRepository;
import com.dove.Dove_user_backend.payload.response.EventListResponse;
import com.dove.Dove_user_backend.payload.response.EventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@Service
public class CalenderServiceImpl implements CalenderService {

    private final EventRepository eventRepository;

    @Override
    public EventListResponse getCalender(String year, String month) {
        String startDay = year+"-"+month+"-"+"01";
        String endDay = year+"-"+month;
        int int_year = Integer.parseInt(year);

        switch (month) {
            case "01": case "03": case "05": case "07": case "08": case "10": case "12":
                endDay = year+"-"+month+"-"+"31";
                break;
            case "04": case "06": case "09": case "11":
                endDay = year+"-"+month+"-"+"30";
                break;
            case "02":
                if(int_year%4==0||int_year%100!=0||int_year%400==0)
                    endDay = year+"-"+month+"-"+"29";
                else
                    endDay = year+"-"+month+"-"+"28";
                break;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDay, formatter);
        LocalDate end = LocalDate.parse(endDay, formatter);

        List<Event> events = eventRepository.findAllByEventDateBetween(start, end);
        List<EventResponse> eventResponses = new ArrayList<>();

        for(Event event : events) {
            eventResponses.add(
                    EventResponse.builder()
                            .date(event.getEventDate())
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
