package com.dove.Dove_user_backend.controller;

import com.dove.Dove_user_backend.payload.response.EventListResponse;
import com.dove.Dove_user_backend.service.calender.CalenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/calender")
@RestController
public class CalenderController {

    private final CalenderService calenderService;

    @GetMapping
    public EventListResponse getCalender(@RequestParam String year,
                                         @RequestParam String month) {
        return calenderService.getCalender(year,month);
    }

}
