package com.dove.Dove_user_backend.controller;

import com.dove.Dove_user_backend.DoveUserBackendApplication;
import com.dove.Dove_user_backend.entity.event.Event;
import com.dove.Dove_user_backend.entity.event.EventRepository;
import com.dove.Dove_user_backend.entity.post.PostRepository;
import com.dove.Dove_user_backend.payload.response.EventResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DoveUserBackendApplication.class)
@ActiveProfiles("test")
class CalenderControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private EventRepository eventRepository;

    private MockMvc mvc;

    @BeforeEach
    public void setUp() throws Exception {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @AfterEach
    public void after() {
        eventRepository.deleteAll();
    }

    @Test
    public void getCalender_no() throws Exception {
        mvc.perform(get("/calender")
                .param("year","2020")
                .param("month","03"))
                .andExpect(status().isOk());
    }

    @Test
    public void getCalender() throws Exception {
        addEvent("2020-04-09");
        addEvent("2020-05-07");
        addEvent("2020-03-19");
        addEvent("2020-03-15");
        addEvent("2020-02-11");

        mvc.perform(get("/calender")
                .param("year","2020")
                .param("month","02"))
                .andExpect(status().isOk());
    }

    private void addEvent(String date) {
        eventRepository.save(
                Event.builder()
                        .host("김해교")
                        .event("김해교가 알려주는 디자인 시간")
                        .eventDate(LocalDate.parse(date))
                        .build()
        );
    }

}
