package com.dove.Dove_user_backend.entity.event;

import com.dove.Dove_user_backend.payload.response.EventResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    List<Event> findAllByDateDayOfYearAndDateDayOfMonth(int year, int month);
}
