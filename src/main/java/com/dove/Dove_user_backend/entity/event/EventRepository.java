package com.dove.Dove_user_backend.entity.event;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    @Query(value = "SELECT e FROM Event e WHERE e.eventDate>=?1 AND e.eventDate<=?2")
    List<Event> findAllByYearAndMonth(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
